import { Component, ElementRef, ViewChild } from '@angular/core';
import { RealestateService } from '../../service/realestate.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserBuyerService } from '../../service/user-buyer.service';

@Component({
  selector: 'app-user-buyer-favorites',
  templateUrl: './user-buyer-favorites.component.html',
  styleUrl: './user-buyer-favorites.component.css'
})
export class UserBuyerFavoritesComponent {


  propertyRentAndBuyId:any;
  
  @ViewChild('fav')
  favHeart:ElementRef;
  favSelect:boolean=false;
  resultRBshow:boolean=false;
  resultPGshow:boolean=true;
  resultPlotshow:boolean=true;
  resultCommshow:boolean=true;

  hideResultsRBPG:string="show";
  showPropertyDetails:string="";

favProperties:any[]=[];
  userAgent:any;
  propertiesRentAndBuy: any[] = [
    {
      propertyImages: [
        { image: 'image_url_1' },
      ]
    },
   
  ];

  propertiesPGs:any[]=[];
  sharingRoom1:any;
  currentImageIndex:number=0;
  currentImageIndexPG:number=0;
  
  images:string[]=["https://threedpower.com/assets/img/apartment/3d-apartment-visualization-company-exterior-elevation-3d-rendering-architectural.jpg","https://5.imimg.com/data5/SELLER/Default/2021/8/TG/EQ/IO/14012326/flats-3d-elevation-plan-design-service.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYZEDKxr6DC7-zZF8WbAsJO1pOC3ZKspgmIiAxty5asw&s"]

  currentImageURL:string=this.images[0];
  showMore:boolean=true;

  propertiesRB:any[]=[];
constructor(private service:RealestateService,
            private activeRoute:ActivatedRoute,
            private router:Router,
            private serviceB:UserBuyerService
){}
  ngOnInit(): void {
    let userAgentSring= sessionStorage.getItem("userAgent");
      this.userAgent=JSON.parse(userAgentSring);
      setInterval(()=>
      {
        this.currentImageIndex=(this.currentImageIndex+1)% 4;
        this.currentImageIndexPG=(this.currentImageIndex+1)% 2;
      },2000)
      
       this.serviceB.Buyer_getFavProperties(this.userAgent.userBuyer1ID, this.userAgent.userBuyer2ID).subscribe((data:any[])=> {
              this.favProperties=data;
              if(this.favProperties!=null)
                {
                  this.favProperties.forEach((f:any)=>{
                    this.propertyRentAndBuyId= f.propertyRBIDSave;
                    console.log("id:" +this.propertyRentAndBuyId);
                  })
                }
          });
  }//ng

  showPropertyForm(type:any)
  {
    if(type=="RB"){
      this.resultRBshow=false;
      this.resultPGshow=true;
    }
    if(type=="PG")
      {
      this.resultPGshow=false;
      this.resultRBshow=true;
    } 
 
  }
  onFavorite(){
    this.favSelect=!this.favSelect;
    if(this.favSelect)
      {
        this.favHeart.nativeElement.innerHTML='<i class="fa fa-heart" aria-hidden="true"></i>'
      }
      else{
        this.favHeart.nativeElement.innerHTML='<i class="fa fa-heart-o" aria-hidden="true"></i>'
      }
      
   
  }
  toggleDescription(){
    this.showMore=!this.showMore;
  }
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
                return 'N/A'; // Return N/A for invalid or unspecified price
            }
      // // Assuming the price is in Indian Rupees (INR)
      // return (price / 100000).toFixed(2) + ' Lac';
  }
  navigateToAddRoomTOPG(propertyPGID)
  {
    this.router.navigateByUrl("/property-searched/property-detailsPG/"+this.userAgent.userAgent1ID+"/"+this.userAgent.userAgent2ID+"/"+propertyPGID)
    this.hideResultsRBPG="";
    this.showPropertyDetails="show";
  }//

}//
