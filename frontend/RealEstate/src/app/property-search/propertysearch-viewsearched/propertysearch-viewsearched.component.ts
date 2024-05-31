import { AfterContentChecked, AfterContentInit, AfterViewInit, Component, ElementRef, HostListener, ViewChild } from '@angular/core';
import { RealestateService } from '../../service/realestate.service';
import { ActivatedRoute, Router, Scroll } from '@angular/router';
import { UserDTO } from '../../model/user-dto';
import { UserBuyerService } from '../../service/user-buyer.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserBuyerDTO } from '../../model/user-buyer-dto';
import { LoginComponent } from '../../includes/login/login.component';

@Component({
  selector: 'app-propertysearch-viewsearched',
  templateUrl: './propertysearch-viewsearched.component.html',
  styleUrl: './propertysearch-viewsearched.component.css'
})
export class PropertysearchViewsearchedComponent implements AfterViewInit,AfterContentInit {

  @ViewChild('scroll')
  scrollH:ElementRef;  
  @ViewChild('fav')
  favHeart:ElementRef;
  favSelect:boolean=false;
  resultRBshow:boolean=false;
  resultPGshow:boolean=true;
  resultPlotshow:boolean=true;
  resultCommshow:boolean=true;
  searchResultsNo:number;

  favPropertiesList:any[]=[];
  isFavorite:boolean=false
  openheart:string='<i class="fa fa-heart-o" aria-hidden="true">';
  closeheart:string='<i class="fa fa-heart" aria-hidden="true">';

  favPropConfirm:any;
  showPGResults:string;
  showFavorite:string="show";
  user:UserDTO;
  userAgent1Id:any;
  userAgent2Id:any;
  comparisonInitialPropID:any;
  comparisonMsg:string;
  showFavSelected:string;

  fromSearch:string;
  fromCompare:string;
  location:any;
     flatBHK:any;
      budget:any;
      choice:any;
      choiceByUser:any;
      propertyRB:FormGroup;
  propertiesRentAndBuy: any[] = [
   
  
  ];

  favPropertyRB:FormGroup;
  currentImageIndex:number=0;
  images:string[]=["https://threedpower.com/assets/img/apartment/3d-apartment-visualization-company-exterior-elevation-3d-rendering-architectural.jpg","https://5.imimg.com/data5/SELLER/Default/2021/8/TG/EQ/IO/14012326/flats-3d-elevation-plan-design-service.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYZEDKxr6DC7-zZF8WbAsJO1pOC3ZKspgmIiAxty5asw&s"]

  currentImageURL:string=this.images[0];
  showMore:boolean=true;
  currentImagePGIndex:number;
  propertiesRB:any[]=[];

  userBuyer:UserBuyerDTO;
  constructor(public service:RealestateService,
              private activeRoute:ActivatedRoute,
              private router:Router,
              private serviceB:UserBuyerService,
              private fb:FormBuilder
  ){}
  ngOnInit(): void {
    const userB =  sessionStorage.getItem("userAgent");
    this.userBuyer = JSON.parse(userB);
    setInterval(()=>
      {
        this.currentImageIndex=(this.currentImageIndex+1)% 4;
        this.currentImagePGIndex=(this.currentImageIndex+1)% 2;
      },2000)
      
       this.activeRoute.paramMap.subscribe((param)=>
          {
            this.location = param.get("locality");
            this.flatBHK = param.get("bhk");
            this.budget = param.get("budget")
            this.choice=param.get("choice");
            if(this.location!=null)
              {
                this.fromSearch="show";
              }
          }
      )
      if(this.choice=="buy"){
        this.service.Location_Price_BudgetRB(this.location, this.flatBHK, this.budget, this.choice).subscribe((data:any[])=>{
          this.service.filteredPropertiesList=data;
          this.searchResultsNo=this.service.resultSearchNo      
        })
      }
      if(this.choice=="Rent"){
        this.service.Location_Price_BudgetRB(this.location, this.flatBHK, this.budget,this.choice).subscribe((data:any[])=>{
          this.service.filteredPropertiesList=data;
          this.searchResultsNo=this.service.resultSearchNo      
        })
      }
      console.log(this.propertiesRentAndBuy[0])
      console.log(this.service.filteredPropertieShow);
      if(this.choice=="PG")
        {
          this.service.Agent_getPropertyPGListByLAR(this.location, this.flatBHK, this.budget).subscribe((data:any[])=>{
            this.service.filteredPropertiesList=data;
            this.searchResultsNo=this.service.resultSearchNo  
            this.showPGResults="show";    
          });
        }

        //       private UUID propertyRBID; 
	// private UUID propertyRBIDSave;
	// private UUID userBuyer1ID;
	// private UUID userBuyer2ID;
  //   private String localTime;
  //   private String localDate;

      this.activeRoute.paramMap.subscribe((param)=>{
        this.userAgent1Id=param.get("userAgent1ID");
        this.userAgent2Id=param.get("userAgent2ID");
        this.comparisonInitialPropID=param.get("propId");
      })  
      if(this.userAgent1Id!=null)
        {
            this.comparisonMsg="Select Property For Comparison";
            this.fromSearch="";
            this.fromCompare="show";
        }
      
        const userS=sessionStorage.getItem("userAgent");
        this.user=JSON.parse(userS);
        if(this.user?.userType == "UserAgent")
          {
            this.showFavorite='';
          }
      
          this.propertiesRB
       
          this.favPropertyRB=this.fb.group({
           
                  propertyRBIDSave:[],
                  userBuyer1ID:[],
                userBuyer2ID:[]
          })

          console.log("Start");
          console.log(this.service.filteredPropertiesList.length);

          

        
              
         console.log("ngOnInit");
         

          
  }//ng

  ngAfterViewInit(): void {
    console.log("ngAfterViewInit");
    
    console.log(this.service.filteredPropertiesList.length);
      
      setTimeout(()=>{
        this.favoriteIcon();
      },2000)
  }//after
  ngAfterContentInit(): void {
    console.log("ngAfterContentInit");
  }

  favoriteIcon()
  {
    
   if(this.service.filteredPropertiesList.length>0)
    {
       
    for(let i=0;i<this.service.filteredPropertiesList.length;i++)
      {
        const property = this.service.filteredPropertiesList[i];

        this.serviceB.Buyer_confirmFavoriteProRB(this.userBuyer?.userBuyer1ID,this.userBuyer?.userBuyer2ID, this.service.filteredPropertiesList[i]?.propertyRentAndBuyId).subscribe((data:any)=>{
          
          
          this.favPropConfirm=data;
          if(data!=null)
            {
              property.isFavorite=true;
              console.log(data);
              //  this.favHeart.nativeElement.innerHTML='<i class="fa fa-heart" aria-hidden="true"></i>'
              // this.isFavorite=true;
              this.favPropertiesList.push(data);
              
            }
            else{
              property.isFavorite=false;
            }
           
        });
      }//
    }
  
  }
  changeimage(){
    this.currentImageIndex=(this.currentImageIndex+1)%this.images.length;
    this.currentImageURL=this.images[this.currentImageIndex];
  }

  onFavorite(event, propertyRentAndBuy:any, i:number){
    event.stopPropagation();
    console.log(i);
    
    this.favPropertyRB.patchValue({
      propertyRBIDSave:propertyRentAndBuy.propertyRentAndBuyId,
      userBuyer1ID:this.userBuyer.userBuyer1ID,
      userBuyer2ID:this.userBuyer.userBuyer2ID
    })
    // console.log(this.favPropertyRB.value);
    propertyRentAndBuy.isFavorite = !propertyRentAndBuy.isFavorite;
    
    if(propertyRentAndBuy.isFavorite)
      {
        console.log("true");
        console.log("userBuyer1ID: "+this.userBuyer?.userBuyer1ID+"\n"+
        "userBuyer2ID: "+this.userBuyer?.userBuyer2ID+"\n"+
        "PropertyID: "+this.favPropertyRB.value+"\n"
);
        //  this.favHeart.nativeElement.innerHTML='<i class="fa fa-heart" aria-hidden="true"></i>';
        // //  this.isFavorite=true;
        
         this.serviceB.Buyer_postPropertyRentAndBuyID(this.userBuyer.userBuyer1ID,this.userBuyer.userBuyer2ID, this.favPropertyRB.value).subscribe();

      }
      else{
        console.log("false");
        
        console.log("userBuyer1ID: "+this.userBuyer?.userBuyer1ID+"\n"+
                    "userBuyer2ID: "+this.userBuyer?.userBuyer2ID+"\n"+
                    "PropertyID: "+this.favPropertiesList[i]?.propertyRBID+"\n"
        );
        
        this.serviceB.Buyer_deletePropRB(this.userBuyer.userBuyer1ID,this.userBuyer.userBuyer2ID,this.favPropertiesList[i].propertyRBID).subscribe();
        //  this.favHeart.nativeElement.innerHTML='<i class="fa fa-heart-o" aria-hidden="true"></i>'
        //  this.isFavorite=false;
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
        return 'N/A'; 
    }

}//
navigateToPropertyDetails(property:any,userAgent1ID:any,userAgent2ID:any){
  const propertyString=JSON.stringify(property);
  sessionStorage.setItem("selectedProperty",propertyString );
  this.router.navigateByUrl("property-searched/property-details/"+userAgent1ID+"/"+userAgent2ID)
}//

navigateToCompare(property,propID){
if(this.comparisonInitialPropID!=propID)
{
  const propertyString=JSON.stringify(property);
  sessionStorage.setItem("comparePropertyCameFromSearch", propertyString);
  console.log(this.userAgent1Id+"/"+this.userAgent2Id+"/"+property.userAgent1ID+"/"+property.userAgent1ID);
 
  this.router.navigateByUrl("property-searched/compare-details-with/"+this.userAgent1Id+"/"+this.userAgent2Id)
}
else{
  alert("Comparison Can not be done For same Property Select Different Property");
}
}
@HostListener('scroll')
changeheight(){
  
     this.scrollH.nativeElement.style.height='900px';
     console.log(this.scrollH);
     this.scrollH.nativeElement.className="main-properties-box-onscroll";
    
}
navigateToViewRoomsOfPG(propertyPGID)
{

  this.router.navigateByUrl("/property-searched/property-detailsPG/"+this.user?.userAgent1ID+"/"+this.user?.userAgent2ID+"/"+propertyPGID)

}
}//
