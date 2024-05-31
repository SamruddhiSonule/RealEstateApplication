import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';
import { UserBuyerDTO } from '../../model/user-buyer-dto';

@Component({
  selector: 'app-user-buyer-header',
  templateUrl: './user-buyer-header.component.html',
  styleUrl: './user-buyer-header.component.css'
})
export class UserBuyerHeaderComponent implements OnInit {
  constructor(private router:Router,
              private service:RealestateService){}

userBuyer:UserBuyerDTO;
              ngOnInit(): void {
                  const userB=sessionStorage.getItem("userAgent");
                  this.userBuyer=JSON.parse(userB);
              }

  nevigateToLogin(){
  //  const url= this.router.navigateByUrl("userauth/login",{replaceUrl: true});
   window.open("userauth/login","_blank");
  }

  navigateToSignUp()
  {
    window.open("gharImarat/User-registration","_blank");
  }
  userLogout(){
    sessionStorage.clear();
    this.router.navigateByUrl("")
    this.service.loggedOut=false;
    this.service.loggedIn=true;
  }
}//
