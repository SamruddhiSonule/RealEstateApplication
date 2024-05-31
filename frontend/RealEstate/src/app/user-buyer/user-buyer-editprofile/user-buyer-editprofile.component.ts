import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserBuyerDTO } from '../../model/user-buyer-dto';
import { UserBuyerService } from '../../service/user-buyer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-buyer-editprofile',
  templateUrl: './user-buyer-editprofile.component.html',
  styleUrl: './user-buyer-editprofile.component.css'
})
export class UserBuyerEditprofileComponent implements OnInit {

  userEdit:FormGroup;
  constructor(private fb:FormBuilder,
              private serviceB:UserBuyerService,
              private router:Router
  ){}
  userBuyer:UserBuyerDTO;
  ngOnInit(): void {
    this.userEdit=this.fb.group({
      userBuyerName:[], 
      userBuyerEmail:[], 
	    userBuyerPassword:[], 
	    userBuyerContact:[], 
	 
    }) 
    const userB=sessionStorage.getItem("userAgent");
                  this.userBuyer=JSON.parse(userB);
    this.userEdit.patchValue(this.userBuyer);
    
  }
  onSubmit(){
   
    this.serviceB.Buyer_updateUserBuyer(this.userBuyer.userBuyer1ID,this.userBuyer.userBuyer2ID, this.userEdit.value).subscribe();
    alert("Profile Updated You Need to Login Again to see changes...!");
    
    this.router.navigateByUrl("userauth/login");
  }
}//class
