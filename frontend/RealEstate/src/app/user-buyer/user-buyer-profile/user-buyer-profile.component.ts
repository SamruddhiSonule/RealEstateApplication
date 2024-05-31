import { Component, OnInit } from '@angular/core';
import { UserBuyerDTO } from '../../model/user-buyer-dto';
import { UserBuyerService } from '../../service/user-buyer.service';

@Component({
  selector: 'app-user-buyer-profile',
  templateUrl: './user-buyer-profile.component.html',
  styleUrl: './user-buyer-profile.component.css'
})
export class UserBuyerProfileComponent implements OnInit {

  userBuyer:UserBuyerDTO;

  constructor(private serviceB:UserBuyerService){}
  
 ngOnInit(): void {
    const userBuyer=sessionStorage.getItem("userAgent");
    this.userBuyer=JSON.parse(userBuyer);
  // console.log(userB.userBuyer1ID,userB.userBuyer2ID);
  
    // this.serviceB.Buyer_getUserbuyerByIds(userB.userBuyer1ID,
    //   userB.userBuyer2ID).subscribe((data:UserBuyerDTO)=>{
    //     console.log(data);
        
    //     this.userBuyer=data;
    //   })
    
 }//
}//
