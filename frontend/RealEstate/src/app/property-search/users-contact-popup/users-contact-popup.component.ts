import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-users-contact-popup',
  templateUrl: './users-contact-popup.component.html',
  styleUrl: './users-contact-popup.component.css'
})
export class UsersContactPopupComponent implements OnInit {

  userDetails:any;
  userAgent1ID:any;
  userAgent2ID:any;
  userType:any;
  constructor(public dialogRef:MatDialogRef<UsersContactPopupComponent>,
    private activeRoute:ActivatedRoute,
    private service:RealestateService
  ){}

  ngOnInit(): void {
    const userAgent1ID = sessionStorage.getItem("userAgent1ID");
    const userAgent2ID = sessionStorage.getItem("userAgent2ID");
    
  this.service.Agent_getUserAgentByIDS(userAgent1ID,userAgent2ID).subscribe((data:any)=>{
    this.userDetails=data;
  });
  console.log("userType:"+this.userDetails.userType);
  
  if(this.userDetails.userType =="UserAgent")
    {
      this.userType="Agent";
    }
  }//ng
  close():void{
    this.dialogRef.close();
  }
}//
