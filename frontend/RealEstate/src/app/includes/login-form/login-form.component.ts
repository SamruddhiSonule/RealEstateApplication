import { Component, ElementRef, OnInit, ViewChild, viewChild } from '@angular/core';
import { FormBuilder, FormGroup, RequiredValidator, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';
import { UserDTO } from '../../model/user-dto';
import { UserBuyerService } from '../../service/user-buyer.service';
import { UserBuyerDTO } from '../../model/user-buyer-dto';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent implements OnInit {

  user:UserDTO;
  count:number=0;
  userBuyer:UserBuyerDTO;
  userNotFound:string;
    constructor(private fb:FormBuilder,
                private router:Router,
                private service:RealestateService,
                private serviceB:UserBuyerService){}
    userauth:FormGroup;

    @ViewChild('pass')
      passwordInput: ElementRef;

    @ViewChild('show')
      show:ElementRef;  
    ngOnInit(): void {
        this.userauth=this.fb.group({
          userEmail:['',Validators.required],
          password:['',Validators.required]
        })
        console.log(this.passwordInput);
        
    }//
   async onLogin(){
      const userEmail=this.userauth.controls['userEmail'].value;
      const password=this.userauth.controls['password'].value;
      // this.service.Agent_getUserAgent(userEmail).subscribe((data:any)=>{this.user=data;

      
         this.service.Agent_getUserAgent(this.userauth.controls['userEmail'].value, this.userauth.controls['password'].value).subscribe((data:UserDTO)=>
            
           
            {
              if(data!=null)
                {  
                this.user={
                userAgent1ID:data.userAgent1ID,
                userAgent2ID:data.userAgent2ID, 
                userAgentName:data.userAgentName,
                userAgentEmail:data.userAgentEmail, 
                userAgentPassword:data.userAgentPassword, 
                userAgentContact:data.userAgentContact, 
                userAgentAddress:data.userAgentAddress, 
                typeOfDeals:data.typeOfDeals,
                typeOfResidentialProperties:data.typeOfResidentialProperties,
                operatingSince:data.operatingSince,
                expertiseIn:data.expertiseIn,
                descriptionOfBusiness:data.descriptionOfBusiness,
                canProvidesLoan:data.canProvidesLoan,
                localTime:data.localTime, 
                localDate:data.localDate, 
                userType:data.userType
              };
              console.log(this.user);
              let user:string=JSON.stringify(this.user);
              sessionStorage.setItem("userAgent",user);
               this.router.navigateByUrl("/users-dashboards/dashboard/"+this.user.userType);
                } 
              // else{
              //   console.log("else");
              //       this.count++;
                      
                     
              //     }
                  },
            );
           await this.userbuyerLogin(userEmail,password);
    }//

    userbuyerLogin(userEmail,password)
    {
      this.serviceB.Buyer_getUserbuyerByEmailAndPassword(userEmail, password).subscribe((data:UserBuyerDTO)=>
        {
          if(data!=null)
            {
              this.userBuyer={
                userBuyer1ID:data.userBuyer1ID,
                  userBuyer2ID:data.userBuyer2ID,
                   userBuyerName:data.userBuyerName,
                   userBuyerEmail:data.userBuyerEmail,
                   userBuyerPassword:data.userBuyerPassword,
                   userBuyerContact:data.userBuyerContact,
                   userBuyerAddress:data.userBuyerAddress,
                   localTime:data.localTime,
                   localDate:data.localDate,
                   userType:data?.userType,
                 };
                 console.log(this.userBuyer);
                 let userBuyer:string=JSON.stringify(this.userBuyer);
                 sessionStorage.setItem("userAgent",userBuyer);
                  this.router.navigateByUrl("/users-dashboards/dashboard/"+this.userBuyer.userType);
                }
  
        },
       
    )//

    if(this.user!=null ){
      
      }//
      else{
        console.log("else");
        this.count++;
        console.log("if user: "+this.count);
       this.userNotFoundU();
     // this.userNotFound="userBuyer Not Found with this Email Id and Password...! "
      }
      if(this.userBuyer!=null){
        
      }//
      else{
        console.log("else");
        this.count++;
        console.log("if user Buyer: "+this.count);
        this.userNotFoundU();
      // this.userNotFound="userBuyer Not Found with this Email Id and Password...! "
      }
    }
    userNotFoundU(){
      
      
        if(this.count==2)
          {
            console.log(this.count);
            this.count=0;
             this.userNotFound="user Not Found with this Email Id and Password...! "
  
          }
    }
    nevigateToSignup(){
      this.router.navigateByUrl("gharImarat/User-registration");
    }

    navigateToUserDashboard(){

      
    }
    hidePassword(){
     if(this.show.nativeElement.innerHTML=="Show")
      {
        this.passwordInput.nativeElement.type="text";
        this.show.nativeElement.innerHTML="Hide";
      }
      else{
        this.show.nativeElement.innerHTML="Show"
        this.passwordInput.nativeElement.type="password";
      }

      
    }//
}//class
