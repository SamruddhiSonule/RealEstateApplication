import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RealestateService } from '../../service/realestate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-agent-addproperties',
  templateUrl: './user-agent-addproperties.component.html',
  styleUrl: './user-agent-addproperties.component.css'
})
export class UserAgentAddpropertiesComponent implements OnInit {
  userAgent:any;
  showMore:boolean=true;
  showPropertyRBForm:string;
  showPropertyPGForm:string="pg";
  showPropertyPlotForm:string;
  showPropertyCommForm:string;
  showAddRoom:string;

  resultRBshow:boolean=false;
  resultPGshow:boolean=true;
  prpertyPGS:any[]=[];
  addNewPGs:string;
  addRoomToPG:string;
  propertyRB:FormGroup;
  propertyPG:FormGroup;
  images:any[]=[];
  localitiesInPune:string[]=["Kharadi","Wakad","Hinjewadi","Baner","Wagholi","Pimpri Chinchwad","Ravet","Hadapsar","Kothrud","Pimple Saudagar","Viman Nagar","Magar Patta","Aundh","KoreGao Park","Bavdhan","Dhanori","Undri","Balewadi","Katraj","Kalyani Nagar","Warje"];
  
  constructor(private fb:FormBuilder,
              private service:RealestateService,
              private router: Router
  ){}
  bhkFlat:string[]=["1Bhk","2Bhk","3Bhk", "4BHK", "5Bhk", "6Bhk"];
  propertyType:string[]=["Multistorey Apartment","Villa"]
  facing:string[]=["North-facing","South-facing","East-facing","West-facing","North-West-facing","North-East-facing","South-West-facing","South-East-facing"]
  constructionPhase:string[]=["Under Construction","Ready To move"]
  parking:string[]=["Available for Car and Bike","Available for Car","Available for Bike","Not available"]
  noOfBedrooms:string[]=["1","2","3","4","5","6"]
  
    ngOnInit(): void {
     this.propertyRB=this.fb.group(
      {
        propertyRentAndBuyId:[], 
        propertyRBName:[], 	
        description:[], 
        propertyLocality:[],
        price:[], 
        location:[], 
        flatBHK:[], 
        balcony:[], 
        parking:[], 
	    propertyTYPE:[], 
	    carpetArea:[], 
	    facing:[],
	    constructionPhase:[], 
	    furnishing:[], 
	    societyName:[], 
	    checkLonEligibilty:[], 
      numberOfBathroom:[],
	    amenities:[],
      forSaleOrRentString:[]

      }
     ) 
     this.propertyRB.controls['flatBHK'].setValue("1 Bhk"
     )
     this.propertyRB.controls['propertyTYPE'].setValue("Multistorey Apartment"
     )
     this.propertyRB.controls['facing'].setValue("North-facing"
     )
     this.propertyRB.controls['constructionPhase'].setValue("Under Construction"
     )
     this.propertyRB.controls['parking'].setValue("Available for Car and Bike"
     )
     this.propertyRB.controls['numberOfBathroom'].setValue("2"
     )
     this.propertyRB.controls['propertyLocality'].setValue("Kharadi"
     )

     let userAgentSring= sessionStorage.getItem("userAgent");
     this.userAgent=JSON.parse(userAgentSring);

     this.propertyPG=this.fb.group({
      propertyPGID:[], 
     propertyPGName:[], 	
      description:[], 
      depositeAmmount:[], 
      noticePeriod:[], 
      foodAvailability:[], 
      acRoomsAvailability:[], 
      parking:[], 
      locality:[],//done
      location:[],
      onePersonRent:[],
      powerBackup:[], 
      availableFor:[],
      totalNoOfBeds:[],
      localTime:[],
      localDate:[],
      userAgent1ID:[],
      userAgent2ID:[],
     })
  }//

  showPropertyForm(type:string){
    if(type === 'RB')
    {
      console.log("RB");
      
      this.showPropertyRBForm="RB";
      this.showPropertyPGForm='';
      this.showPropertyPlotForm='';
      this.showPropertyCommForm='';
      this.resultRBshow=true;
      this.resultPGshow=false;
    }
    if(type === 'PG')
    {
      console.log("PG");
      
      this.showPropertyRBForm="";
      this.showPropertyPGForm='PG';
      this.showPropertyPlotForm='';
      this.showPropertyCommForm='';
      this.resultPGshow=true;
      this.resultRBshow=false;
    }
    if(type === 'PLOT')
    {
      this.showPropertyRBForm="";
      this.showPropertyPGForm='';
      this.showPropertyPlotForm='PLOT';
      this.showPropertyCommForm='';
    }
    if(type === 'COMM')
    {
      this.showPropertyRBForm="";
      this.showPropertyPGForm='';
      this.showPropertyPlotForm='';
      this.showPropertyCommForm='COMM';
    }
  }
  onImages1(event:any){
      const maxNoOfFiles=7;
      const files=event.target.files;
      if(files.length > maxNoOfFiles)
        {
          alert("You can only upload 7 images..!")
          event.target.value=null;
        }
        else{
            for(let i=0;i< files.length;i++)
              {
                const file=files[i];
                this.images.push(file);
              }
              console.log(this.images);
              
        }
      
  }
  onSubmit(){
    const formData =new FormData();
    let text:string=JSON.stringify(this.propertyRB.value);
    console.log(text);
    formData.append("text", text);
    for(let i=0;i<this.images.length;i++)
      {
        formData.append("image", this.images[i])
      }
    console.log(formData);
    
    this.service.Agent_addProperty(this.userAgent.userAgent1ID,this.userAgent.userAgent2ID, formData).subscribe();
    this.propertyRB.reset();
  }

  onSubmitPG(){
   const userS= sessionStorage.getItem("userAgent");
   const userO=JSON.parse(userS);
   console.log(this.propertyPG.value);
   
    this.service.Agent_addPG(userO.userAgent1ID,userO.userAgent2ID, this.propertyPG.value).subscribe();
  }

  addNewPG(){
      this.addNewPGs="show";
      this.addRoomToPG="";
  }
  addRoomsToPG(){
      this.addRoomToPG="show";
      this.addNewPGs="";
      const userS= sessionStorage.getItem("userAgent");
      const userO=JSON.parse(userS);
      console.log(userO.userAgent1ID);
      console.log(userO.userAgent2ID);
      
      
      this.service.Agent_getAllPropPGByIDs(userO.userAgent1ID,userO.userAgent2ID).subscribe((data:any[])=>
      {
        this.prpertyPGS=data
        console.log(this.prpertyPGS);

      });

  }
  navigateToAddRoomTOPG(propertyID){
      this.router.navigateByUrl("userAgent/user-dashboard/addproperties/add-rooms-pg/"+propertyID);
      this.showAddRoom="asd";
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
  }
}//
