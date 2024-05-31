import { Component, OnInit } from '@angular/core';
import { RealestateService } from '../../service/realestate.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { UsersContactPopupComponent } from '../users-contact-popup/users-contact-popup.component';
import { EnquiryPopupComponent } from '../enquiry-popup/enquiry-popup.component';
import { PopupEnquiryForPGComponent } from '../popup-enquiry-for-pg/popup-enquiry-for-pg.component';
import { PropertyPG } from '../../model/property-pg';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-property-search-property-details',
  templateUrl: './property-search-property-details.component.html',
  styleUrl: './property-search-property-details.component.css'
})
export class PropertySearchPropertyDetailsComponent implements OnInit {

  constructor(private service:RealestateService,
              private activeRoute:ActivatedRoute,
              public dailog:MatDialog,
              private router:Router,
              private fb:FormBuilder
             
              
  ){}

  selectedProperty:any;
  selectedPG:string;
  propertyPGID:any;
  propertyPG:any;
  userDetails:any;
  userAgent1ID:any;
  userAgent2ID:any;
  currentImageIndex:number=0;
  sharingRooms:any[]=[];
  showMore:boolean=true;

  filtersSR:FormGroup;

  ngOnInit(): void {

    this.filtersSR=this.fb.group({
      sharing:[],
      availableFor:[]
    })

     const propertyString= sessionStorage.getItem("selectedProperty");
      const propertyObject=JSON.parse(propertyString);
      this.selectedProperty=propertyObject;
      console.log(this.selectedProperty);
      this.activeRoute.paramMap.subscribe((param)=>{
          this.userAgent1ID=param.get("userAgent1ID");
          this.userAgent2ID=param.get("userAgent2ID");
          this.propertyPGID=param.get("propPGID");
      })
      sessionStorage.setItem("userAgent1ID", this.userAgent1ID);
      sessionStorage.setItem("userAgent2ID", this.userAgent2ID);
     
      this.service.Agent_getUserAgentByIDS(this.userAgent1ID, this.userAgent2ID).subscribe((data:any)=>{
        this.userDetails=data;
      });
      console.log(this.propertyPGID);
      debugger
      this.service.Agent_getPropertyPGByID(this.propertyPGID).subscribe((data:any)=>{
        this.propertyPG=data;
        this.selectedPG="show";
        const selectedPGDTO:PropertyPG={
          propertyPGID:data.propertyPGID, 
          propertyPGName:data.propertyPGName, 	
          location:data.location,
          userAgent1ID:data.userAgent1ID,
          userAgent2ID:data.userAgent2ID,
        }
        const selectedPGS=JSON.stringify(selectedPGDTO);
        sessionStorage.setItem("selectedPG",selectedPGS);
        console.log(selectedPGDTO);
        
      });
      this.service.Agent_getAllRoomsFromPGByID(this.propertyPGID).subscribe((data:any[])=>{
        this.sharingRooms=data;
      })

      setInterval(()=>
        {
          this.currentImageIndex=(this.currentImageIndex+1)% 2;
          
        },2000)
        // private UUID roomPGID;
        // private String roomNo; 	
        // private String sharing;
        // private int rent; //
        // private String foodAvailability;  
        // private String amenities;
        // private String location;
        // private String availableFor;
        // private UUID propertyPGID;
    }//ng

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
toggleDescription(){
  this.showMore=!this.showMore;
}
openContactPop(){
  
  this.dailog.open(UsersContactPopupComponent, {
    width:'40%',
    height:'300px',
    panelClass: 'custom-dialog-container'
  });
}
compareProperty(){
    this.router.navigateByUrl("property-searched/compare-details/"+this.userAgent1ID+"/"+this.userAgent2ID+"/"+this.selectedProperty.propertyRentAndBuyId+"/"+'buy');
}

onCreateEnquiry(propType:string,roomNO){

 const user= sessionStorage.getItem("userAgent");
 const userO=JSON.parse(user);
  if(userO!=null){
    if(propType=="RB"){
      this.dailog.open(EnquiryPopupComponent,{
        width:'80%',
        height:'500px',
      })
    }
    else{
      sessionStorage.setItem("roomNo", roomNO);
      this.dailog.open(PopupEnquiryForPGComponent,{
        width:'80%',
        height:'500px',
      })
    }
  }else{
          alert("LogIn First")

          this.router.navigateByUrl("userauth/login");
  }//
}//

onSearchFiltersPG(){
  this.service.Agent_getFilteredSR(this.propertyPGID, this.filtersSR.controls['sharing'].value, this.filtersSR.controls['availableFor'].value).subscribe((data:any[])=>{
    this.sharingRooms=data;
    if(data.length===0)
      {
        alert("No Rooms Found...!")
        window.location.reload();
      }
  })
}
}//
