import { Component, OnInit } from '@angular/core';
import { RealestateService } from '../../service/realestate.service';
import { UserDTO } from '../../model/user-dto';
import { FormBuilder, FormGroup } from '@angular/forms';
import { window } from 'rxjs';

@Component({
  selector: 'app-user-agent-enquirybox',
  templateUrl: './user-agent-enquirybox.component.html',
  styleUrl: './user-agent-enquirybox.component.css'
})
export class UserAgentEnquiryboxComponent implements OnInit {
  // private UUID enquiryBoxID; 
	// private UUID enquirySender1ID;
	// private UUID enquirySender2ID; //add 
	// private UUID enquiryGetter1ID;
	// private UUID enquiryGetter2ID;//add
	// private String enquiryMessage;
	// private String personMail;
	// private String mailSender;
	// private String mailReciever;
	// private String subject;
	// private String nameOfPerson;
	// private UUID propertyId;
	// private String propertyLocatilty;
	// private String location;
	// private String locaTimeStamp;
	// private String localDate;

  enquiryBox:any[]=[];
  userAgent1ID:any;
  userAgent2ID:any;
  cleseEnquiry:boolean=false;
  constructor(private service:RealestateService,
              private fb:FormBuilder
  ){}

  enquiryBoxStatus:FormGroup;

  

  ngOnInit(): void {

    this.enquiryBoxStatus=this.fb.group({
      status:[]
    })
    console.log("Enquiry");
    
    const userS = sessionStorage.getItem("userAgent");
    const userO:UserDTO = JSON.parse(userS);
    console.log(userO);
    
    this.userAgent1ID = userO.userAgent1ID;
    this.userAgent2ID = userO.userAgent2ID;

    this.service.Agent_getAllEnquiriesOFAgent(userO.userAgent1ID, userO.userAgent2ID).subscribe((data:any[])=>{
      console.log("Data: "+ data.length);
                            this.enquiryBox=data;
    });

   this.enquiryBox.forEach(element => {
      if(element.status==="Pending"){
        this.cleseEnquiry=true;
      }
   });
  }//

  closeRequest(status,enquiryBoxID){
      if(status =='Pending')
        {
          this.enquiryBoxStatus.controls['status'].setValue("Pending");
          this.service.Agent_updateEnquiryBoxWithStatus(enquiryBoxID, status).subscribe();
          
        }
      if(status =='Closed')
        {
          this.enquiryBoxStatus.controls['status'].setValue("Closed");
          this.service.Agent_updateEnquiryBoxWithStatus(enquiryBoxID, status).subscribe();
        }
          
  }//

  reloadPage(){

  }
}//
