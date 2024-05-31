import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-popup-compare',
  templateUrl: './popup-compare.component.html',
  styleUrl: './popup-compare.component.css'
})
export class PopupCompareComponent {

  userDetails:any;
  userAgent1ID:any;
  userAgent2ID:any;
  userType:any;
  constructor(public dialogRef:MatDialogRef<PopupCompareComponent>,
    private activeRoute:ActivatedRoute,
    private service:RealestateService
  ){}

  ngOnInit(): void {
    const userAgent1ID = sessionStorage.getItem("userIDC1");
    const userAgent2ID = sessionStorage.getItem("userIDC2");
    
  this.service.Agent_getUserAgentByIDS(userAgent1ID,userAgent2ID).subscribe((data:any)=>{
    this.userDetails=data;
  });
  console.log("userType:"+this.userDetails.userType);
  

   
  }//ng
  close():void{
    this.dialogRef.close();
  }
}//
