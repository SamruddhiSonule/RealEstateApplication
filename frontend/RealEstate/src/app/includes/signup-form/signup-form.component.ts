import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterPreloader } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';
import { UserBuyerService } from '../../service/user-buyer.service';
import { map } from 'rxjs';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrl: './signup-form.component.css'
})
export class SignupFormComponent implements OnInit {

  error:Map<string,string>;
  saved:string;  
  selectedUserType:String="UserBuyer";

  constructor(private fb:FormBuilder,
    private router:Router,
    private service:RealestateService,
    private serviceB:UserBuyerService){}
    agree:string;
user:FormGroup;
userAgent:FormGroup;
userbuyer:FormGroup;
ngOnInit(): void {
  this.selectedUserType;
  this.userAgent=this.fb.group({
    userAgentName:['',Validators.required],
    userAgentEmail:['',Validators.required], 
    userAgentPassword:['',Validators.required], 
    userAgentContact:['',Validators.required],
    userType:['',Validators.required],
  })
  this.userAgent.controls['userType'].setValue("UserAgent");
             

  this.userbuyer=this.fb.group({
   userBuyerName:['',Validators.required],
   userBuyerEmail:['',Validators.required],
   userBuyerPassword:['',Validators.required],
   userBuyerContact:['',Validators.required],
   userType:['',Validators.required]
  })
  this.userbuyer.controls['userType'].setValue("UserBuyer");
  
}//


onSignUp(){
    if(this.selectedUserType=="UserAgent")
      {
        this.service.Agent_save(this.userAgent.value).subscribe();
        alert("User Agent Saved...!")
              this.router.navigateByUrl("userauth/login");
             
              
      }
    if(this.selectedUserType=="UserBuyer")
      {
      
        this.serviceB.Buyer_PostUser(this.userbuyer.value).subscribe((data:any)=>{
                        this.saved="Registered Successfully...!"
              this.error=null;
              alert("User Buyer Saved...!")
              this.router.navigateByUrl("userauth/login");
        },
      (error)=>{
        this.error=error.error;
      }
      );
      }  
  
  }


nevigateToLogIn(){
this.router.navigateByUrl("userauth/login");
}


}//
