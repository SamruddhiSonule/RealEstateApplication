import { Component, OnInit } from '@angular/core';
import { UsersContactPopupComponent } from '../users-contact-popup/users-contact-popup.component';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';
import { PopupCompareComponent } from '../popup-compare/popup-compare.component';

@Component({
  selector: 'app-compare-property',
  templateUrl: './compare-property.component.html',
  styleUrl: './compare-property.component.css'
})
export class ComparePropertyComponent implements OnInit {

  selectedProperty:any;
  compareProperty:any;
  userDetailsI:any;
  userDetailsC:any;
  
  userAgent1ID:any;
  userAgent2ID:any;
  userAgent1IdCW:any;
  userAgent2IdCW:any;
  currentImageIndex:number=0;
 //-------------------------------------------------------------------------------------------------- 
 constructor(public dialog:MatDialog,
              private activeRoute:ActivatedRoute,
              private service:RealestateService
 ){}
 //---------------------------------------------------------------------------------------------------

 ngOnInit(): void {
    const selectedProperty=sessionStorage.getItem("selectedProperty") ;
    this.selectedProperty=JSON.parse(selectedProperty);
    const compareProperty=sessionStorage.getItem("comparePropertyCameFromSearch") ;
    this.compareProperty=JSON.parse(compareProperty);
    
  this.activeRoute.paramMap.subscribe((param)=>{
                                      this.userAgent1ID=param.get("user1IDC");
                                      this.userAgent2ID=param.get("user2IDC");
                                      this.userAgent1IdCW=param.get("user1IDCW");
                                      this.userAgent2IdCW=param.get("user2IDCW");  
                                      this.service.Agent_getUserAgentByIDS(this.userAgent1ID,this.userAgent2ID).subscribe((data:any)=>
                                        this.userDetailsI=data);   
                                      this.service.Agent_getUserAgentByIDS(this.compareProperty.userAgent1ID,this.compareProperty.userAgent2ID).subscribe((data:any)=>
                                        this.userDetailsC=data);    
                                      
                                                                                       
  })      
  sessionStorage.setItem("userIDC1", this.compareProperty.userAgent1ID);
  sessionStorage.setItem("userIDC2", this.compareProperty.userAgent2ID);      
  console.log(this.compareProperty.userAgent1ID);
  console.log(this.compareProperty.userAgent2ID);
  setInterval(()=>
    {
      this.currentImageIndex=(this.currentImageIndex+1)% 4;
    },2000)





 }//

  formatPrice(price: number):string {
    if (price >= 10000000) { 
        return (price / 10000000).toFixed(2) + ' Cr';
    } 
    else if (price >= 100000) 
    { 
        return (price / 100000).toFixed(2) + ' Lac';
    } 
    else if (price > 0) 
    { 
        return price.toString();
    } 
    else 
    {
        return 'N/A'; 
    }

}//
openContactPop(){
  this.dialog.open(UsersContactPopupComponent, {
    width:'30%',
    height:'300px',
    panelClass: 'custom-dialog-container'
  });
}//

openContactPopForCompare(){
  this.dialog.open(PopupCompareComponent

    ,{
      width:'30%',
      height: '300px',
      panelClass:'custom-dialog-container'
  
    }
  )
}
}//
