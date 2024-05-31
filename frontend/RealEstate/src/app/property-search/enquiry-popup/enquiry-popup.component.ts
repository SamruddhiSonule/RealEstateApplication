import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RealestateService } from '../../service/realestate.service';
import { MatDialogRef } from '@angular/material/dialog';
import { UserDTO } from '../../model/user-dto';

@Component({
  selector: 'app-enquiry-popup',
  templateUrl: './enquiry-popup.component.html',
  styleUrl: './enquiry-popup.component.css'
})
export class EnquiryPopupComponent implements OnInit {

  userAgent1ID:any;
  userAgent2ID:any;
  userLoggedIn:any;
  userAgentDetails:any;
  property:any;
  constructor(private fb:FormBuilder,
              private service:RealestateService,
              public matDialogRef: MatDialogRef<EnquiryPopupComponent>

  ){}

  enquiryBox:FormGroup;

  userLoggedInB:any;
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
  this.property=JSON.parse(propertyString);

  
  // console.log(this.property);
  
  // console.log(this.userAgent1ID);

  const userS= sessionStorage.getItem("userAgent");//userAgent
  this.userLoggedIn=JSON.parse(userS);
 

 
 
  
  
  



  const userAgent1ID = sessionStorage.getItem("userAgent1ID");
    const userAgent2ID = sessionStorage.getItem("userAgent2ID");
    
  this.service.Agent_getUserAgentByIDS(userAgent1ID,userAgent2ID).subscribe((data:any)=>{
    this.userAgentDetails=data;})

    if(this.userLoggedIn.userType ==="UserAgent")
      {
        this.enquiryBox.controls['enquiryMessage'].setValue("I am Interested In this Property.")
        const formValues = this.enquiryBox.value;
        let customMessage = `${formValues.enquiryMessage}\n\n`;
        customMessage += `Society Name: ${this.property.societyName}\n`;
        customMessage += `Property Location: ${this.property.location}\n`;
        customMessage += `Name of Person: ${this.userLoggedIn.userAgentName}\n`;
        customMessage += `Email of Person: ${this.userLoggedIn.userAgentEmail}\n`;
        customMessage += `Contact of Person: ${this.userLoggedIn.userAgentContact}\n`;
        
        this.enquiryBox.patchValue({
          enquiryMessage: customMessage
        });
        console.log("customeMessage "+customMessage);

        this.enquiryBox.controls['mailReciever'].setValue(this.userLoggedIn?.userAgentEmail);
          console.log(this.enquiryBox.controls['mailReciever'].value);
      }
      if(this.userLoggedIn.userType ==="UserBuyer")
        {
          this.enquiryBox.controls['enquiryMessage'].setValue("I am Interested In this Property.")
          const formValues = this.enquiryBox.value;
          let customMessage = `${formValues.enquiryMessage}\n\n`;
          customMessage += `Society Name: ${this.property.societyName}\n`;
          customMessage += `Property Location: ${this.property.location}\n`;
          customMessage += `Name of Person: ${this.userLoggedIn.userBuyerName}\n`;
          customMessage += `Email of Person: ${this.userLoggedIn.userBuyerEmail}\n`;
          customMessage += `Contact of Person: ${this.userLoggedIn.userBuyerContact}\n`;
          
          this.enquiryBox.patchValue({
            enquiryMessage: customMessage
          });
          console.log("customeMessage "+customMessage);

          this.enquiryBox.controls['mailReciever'].setValue(this.userLoggedIn?.userBuyerEmail);
          console.log(this.enquiryBox.controls['mailReciever'].value);
        }
   
    
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
    propertyId:this.property.propertyRentAndBuyId,
    propertyLocatilty:this.property.propertyLocality,
    location:this.property.location
  })
  console.log(this.enquiryBox.value);
  this.service.agent_storeEnquary(this.userAgentDetails.userAgent1ID,this.userAgentDetails.userAgent2ID,this.enquiryBox.value).subscribe();
  alert("Enquiry has been sent to Agent, Agent will contact you within 1 week...!")
  this.close();
}

close(){
this.matDialogRef.close();
}

}//
