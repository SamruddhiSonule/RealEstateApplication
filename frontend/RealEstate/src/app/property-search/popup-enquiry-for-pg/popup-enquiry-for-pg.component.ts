import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { RealestateService } from '../../service/realestate.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserDTO } from '../../model/user-dto';
import { PropertyPG } from '../../model/property-pg';

@Component({
  selector: 'app-popup-enquiry-for-pg',
  templateUrl: './popup-enquiry-for-pg.component.html',
  styleUrl: './popup-enquiry-for-pg.component.css'
})
export class PopupEnquiryForPGComponent {

  userAgent1ID:any;
  userAgent2ID:any;
  userLoggedIn:UserDTO;
  userAgentDetails:any;
  propertyPG:any;
  constructor(private fb:FormBuilder,
              private service:RealestateService,
              public matDialogRef: MatDialogRef<PopupEnquiryForPGComponent>

  ){}

  enquiryBox:FormGroup;


ngOnInit(): void {
   this.enquiryBox=this.fb.group({

    enquiryBoxID:[], 
    enquirySender1ID:[],
    enquirySender2ID:[],

    enquiryGetter1ID:[],
    enquiryGetter2ID:[],
    enquiryMessage:[],
    personMail:[],
    mailSender:[],
    mailReciever:[],
    subject:[],
    nameOfPerson:[],
    propertyId:[],
    propertyLocatilty:[],
    location:[],
    locaTimeStamp:[],
    localDate:[],
    status:[]
   }) 
   this.enquiryBox.controls['status'].setValue("Pending");
  this.userAgent1ID= sessionStorage.getItem("userAgent1ID");
  this.userAgent2ID= sessionStorage.getItem("userAgent2ID");
   
  const propertyString= sessionStorage.getItem("selectedProperty");
  this.propertyPG=JSON.parse(propertyString);

  
  // console.log(this.property);
  
  // console.log(this.userAgent1ID);

  const userS= sessionStorage.getItem("userAgent");//userAgent
  this.userLoggedIn=JSON.parse(userS);

  const selectedPGS= sessionStorage.getItem("selectedPG");//userAgent
  this.propertyPG=JSON.parse(selectedPGS);
  


  const userAgent1ID = sessionStorage.getItem("userAgent1ID");
    const userAgent2ID = sessionStorage.getItem("userAgent2ID");
    
  this.service.Agent_getUserAgentByIDS(userAgent1ID,userAgent2ID).subscribe((data:any)=>{
    this.userAgentDetails=data;})
    this.enquiryBox.controls['enquiryMessage'].setValue("I am Interested In this Property.");
    const formValues = this.enquiryBox.value;
    let customMessage = `${formValues.enquiryMessage}\n\n`;
    const roomNO=sessionStorage.getItem("roomNo");
    customMessage += `PG Name: ${this.propertyPG.propertyPGName}\n`;
    customMessage += `PG RoomNo: ${roomNO}\n`;
    customMessage += `Property Location: ${this.propertyPG.location}\n`;
    customMessage += `Name of Person: ${this.userLoggedIn?.userAgentName}\n`;
    customMessage += `Email of Person: ${this.userLoggedIn.userAgentEmail}\n`;
    customMessage += `Contact of Person: ${this.userLoggedIn.userAgentContact}\n`;
    this.enquiryBox.patchValue({
      enquiryMessage: customMessage
    });
    console.log("customeMessage "+customMessage);
    
}//

onSubmit()
{
  
  this.service.agent_storeEnquary(this.userAgent1ID, this.userAgent2ID, this.enquiryBox.value);
  this.enquiryBox.patchValue({
    enquirySender1ID:this.userLoggedIn.userAgent1ID,
    enquirySender2ID:this.userLoggedIn.userAgent2ID,
    enquiryGetter1ID:this.userAgentDetails.userAgent1ID,
    enquiryGetter2ID:this.userAgentDetails.userAgent2ID,
    personMail:this.userLoggedIn?.userAgentEmail,
    mailSender:"akshaysuroshe4@gmail.com",
    // mailReciever:this.userAgentDetails.userAgentEmail,
    mailReciever:"nimation22@gmail.com",
    subject:"Regarding Gharr Imarat Property",
    nameOfPerson:this.userLoggedIn?.userAgentName,
    propertyId:this.propertyPG.propertyPGID,
    propertyLocatilty:this.propertyPG.locality,
    location:this.propertyPG.location
  })
  console.log(this.enquiryBox.value);
  this.service.agent_storeEnquary(this.userAgentDetails.userAgent1ID,this.userAgentDetails.userAgent2ID,this.enquiryBox.value).subscribe();
  alert("Enquiry has been sent to Agent, Agent will contact you within 1 week...!")
  this.close();
}

close(){
this.matDialogRef.close();
}
}
