import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-user-agent-updateprofile',
  templateUrl: './user-agent-updateprofile.component.html',
  styleUrl: './user-agent-updateprofile.component.css'
})
export class UserAgentUpdateprofileComponent implements OnInit {

  constructor(private fb:FormBuilder,
              private service:RealestateService
  ){}
  typesOfDeals:string[]=['Rent','PreLaunch','Sell'];
  typesOfPropertyDeals:string[]=['Multistorey Appartment','Builder Floor Apartment','Resedential Houses','Villa'];
  

  userAuthAgent:FormGroup;
  userAgent:any;
  ngOnInit(): void {
      this.userAuthAgent=this.fb.group(
        {
          userAgent1ID:[], 
	        userAgent2ID:[], 
	        userAgentName:[], 
	        userAgentEmail:[], 
	        userAgentPassword:[], 
	        userAgentContact:[], 
          userAgentAddress:[], 
          typeOfDeals:[],
          typeOfResidentialProperties:[],
          operatingSince:[],
          expertiseIn:[],
          descriptionOfBusiness:[],
          canProvidesLoan:[],
          userType:[]
        }
      )
      let userAgentSring= sessionStorage.getItem("userAgent");
      this.userAgent=JSON.parse(userAgentSring);
      console.log(this.userAgent);
     this.userAuthAgent.controls['typeOfDeals'].setValue("Select");
     this.userAuthAgent.patchValue(this.userAgent);
    
  }//
  onSubmit(){
    console.log(this.userAuthAgent.value);
    
    this.service.Agent_UpdateProfile(this.userAgent.userAgent1ID,this.userAgent.userAgent2ID, this.userAuthAgent.value).subscribe();
  }
}//
