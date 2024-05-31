import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent implements OnInit {
  constructor(private router:Router,private service:RealestateService){}
isClicked:boolean[]=Array(5).fill(false);
indexArray:Array<any>=[];
searchedLocation:string;
seachBoxShow:boolean=true;
erroSearchMsgflat:string="";
errorSearch:string;
selectedBHK:string;
selectedBudget:string;
 //BHKoptions:string[]=["1 Bhk","2 Bhk","3 Bhk","4 Bhk","5 Bhk","6 Bhk"];
// PGOccupancy:string[]=["Boys","Girls"];

localitiesInPune:string[]=["Kharadi","Wakad","Hinjewadi","Baner","Wagholi","Pimpri Chinchwad","Ravet","Hadapsar","Kothrud","Pimple Saudagar","Viman Nagar","Magar Patta","Aundh","KoreGao Park","Bavdhan","Dhanori","Undri","Balewadi","Katraj","Kalyani Nagar","Warje"];
filteredlocation:string[]=[];

toggleArray1:any[]=[];
toggleArray2:any[]=[];
selectPlaceHolder1:string;
selectPlaceHolder2:string;
choiceType:string;
//buy
BHKoptions = [
  { label: 'Flat Bhk', value: '' },
  { label: '1 Bhk', value: '1Bhk' },
  { label: '2 Bhk', value: '2Bhk' },
  { label: '3 Bhk', value: '3Bhk' },
  { label: '4 Bhk', value: '4Bhk' },
  { label: '5 Bhk', value: '5Bhk' },
  { label: '5+ Bhk', value: '6Bhk' }
];

budgetBuyOptions = [
  { label: "Budget", value: '' },
  { label: 'upto ₹50 lac', value: '5000000' },
  { label: 'upto ₹70 lac', value: '7000000' },
  { label: 'upto ₹80 lac', value: '8000000' },
  { label: 'upto ₹90 lac', value: '9000000' },
  { label: 'upto ₹1 Cr.', value: '10000000' },
  { label: 'upto ₹1.5 Cr. or above', value: '15000000' }
];
//Rent

budgetRentOptions = [
  { label: 'Rent Budget', value: '' },
  { label: '₹5000', value: '5000' },
  { label: '₹10000', value: '10000 ' },
  { label: '₹15000', value: '15000' },
  { label: '₹20000', value: '20000' },
  { label: '₹30000', value: '30000' },
  { label: '₹35000', value: '35000' }
];
//PG

PGOccupancy = [
  { label: 'Occupancy', value: ''},
  { label: 'Girls', value: 'Girls'},
  { label: 'Boys', value: 'Boys'},
  { label: 'Combine', value: 'Combine'}
  
];

budgetPGOptions = [
  { label: 'Budget', value:''},
  { label: '₹4000', value: '4000' },
  { label: '₹6000', value: '60000 ' },
  { label: '₹8000', value: '8000' },
  { label: '₹9000', value: '9000' },
  { label: '₹10000', value: '10000' },
  { label: '₹12000', value: '12000' },
  { label: '₹15000', value: '15000' },
  { label: '₹17000', value: '17000' },
  { label: '₹18000', value: '18000' },
  
];
//Plot
// PlotType:string[]=["ResidentialPlot","CommercialLand", "AgriculturalLand"];
PlotType = [
  { label: 'Resedential', value:''},
  { label: 'Resedential Plot', value: 'ResidentialPlot' },
  { label: 'Commercial Plot', value: 'CommercialLand' },
  { label: 'Agricultural Land', value: 'AgriculturalLand' }
];
budgetPlotOptions = [
  { label: 'Budget', value:''},
  { label: '₹5 lac', value: '500000' },
  { label: '₹10 lac', value: '1000000 ' },
  { label: '₹20 lac', value: '2000000' },
  { label: '₹30 lac', value: '3000000' },
  { label: '₹40 lac', value: '4000000' },
  { label: '₹50 lac', value: '5000000' },
  { label: '₹60 lac', value: '6000000' }
];
//commercial
//commercialType:string[]=["Office Space","Shop/Showroom", "Commercialland","Coworking Space","Warehouse/Godown","IndustrialShed"];
commercialType = [
  { label: 'Property Type', value:''},
  { label: 'Office Space', value: 'OfficeSpace' },
  { label: 'Shop/Showroom', value: 'Shop/Showroom' },
  { label: 'Commercial Land', value: 'Commercialland' },
  {label: 'Coworking Space',value:'CoworkingSpace'},
  {label: 'Warehouse/Godown',value:'Warehouse/Godown'},
  {label: 'IndustrialShed',value:'IndustrialShed'}

];
budgetCommOptions = [
  { label: 'Budget', value:''},
  { label: '₹4000', value: '4000' },
  { label: '₹6000', value: '60000 ' },
  { label: '₹8000', value: '8000' },
  { label: '₹9000', value: '9000' },
  { label: '₹10000', value: '10000' },
  { label: '₹12000', value: '12000' },
  { label: '₹15000', value: '15000' },
  { label: '₹17000', value: '17000' },
  { label: '₹18000', value: '18000' },
];

ngOnInit(): void {
    this.isFilterClickedBTN(0,'buy');
}

  isFilterClickedBTN(index:any,choice:any){
    this.erroSearchMsgflat='';
    this.choiceType=choice;
    console.log(this.choiceType);
    
    if(this.indexArray.length >0){
      const prevIndex= this.indexArray.pop();
      this.isClicked[prevIndex]=false;
    }
    this.isClicked[index] = true;
    this.indexArray.push(index);

    if(index==0) //Buy
    {
      this.toggleArray1=this.BHKoptions;
      this.toggleArray2=this.budgetBuyOptions;
   
      this.selectedBHK="";
      this.selectedBudget="";
      
    }
    else if(index==1) //Rent
    {
      this.toggleArray1=this.BHKoptions;
      this.toggleArray2=this.budgetRentOptions;
      this.selectedBHK="";
      this.selectedBudget=""
    }
    else if(index==2) //PG
    {
      this.toggleArray1=this.PGOccupancy;
      this.toggleArray2=this.budgetPGOptions;
      this.selectedBHK="";
      this.selectedBudget="";
    }
    else if(index==3) //Plot
    {
      this.toggleArray1=this.PlotType;
      this.toggleArray2=this.budgetPlotOptions;

      this.selectedBHK="";
      this.selectedBudget="";
    }
    else if(index==4) //Commercial
    {
      this.toggleArray1=this.commercialType;
      this.toggleArray2=this.budgetCommOptions;
      
      this.selectedBHK="";
      this.selectedBudget="";
      
    }
 }//

 onSearch(){
  console.log(this.selectedBHK);
  console.log(this.selectedBudget);
 }//
 navigateToViewProperties(){
  
  if(this.localitiesInPune.includes(this.searchedLocation) )
  {
    this.errorSearch=""
  }
  else{
    this.errorSearch="search valid locality from Pune..."
  }
  if(!this.selectedBHK)
  {
      this.erroSearchMsgflat="select above fields"
  }
  else{
    this.erroSearchMsgflat=""
  }

  if(!this.selectedBudget){
    this.erroSearchMsgflat="select above fields"
  }else{
    this.erroSearchMsgflat=""
  }
if((this.choiceType ==="buy") || (this.choiceType === "Rent"))
  {
      console.log(this.choiceType);
              if (!this.erroSearchMsgflat && this.localitiesInPune.includes(this.searchedLocation)) {
                this.router.navigateByUrl("property-searched/searched-properties-buy/" + this.choiceType + "/" + this.searchedLocation + "/" + this.selectedBHK + "/" + this.selectedBudget);
                }
}//if
if(this.choiceType ==='PG')
  { 
   if (!this.erroSearchMsgflat && this.localitiesInPune.includes(this.searchedLocation)) {
    this.router.navigateByUrl("property-searched/searched-properties-buy/" + this.choiceType + "/" + this.searchedLocation + "/" + this.selectedBHK + "/" + this.selectedBudget);
    }
}//if

 }//

  filterLocalities()
  {
   
        if(this.searchedLocation.trim() === '' ||!this.localitiesInPune.some(locality =>
          locality.toLowerCase().includes(this.searchedLocation.trim().toLowerCase())))
        {
          this.filteredlocation=[];
          this.seachBoxShow=true;
        }
        else 
        {
          this.filteredlocation=this.localitiesInPune.filter(locality =>
            locality.toLowerCase().includes(this.searchedLocation.toLowerCase())
            );
            this.seachBoxShow=false;
        }
      }
      

   

  selectedSearchedLocality(locality:any){
      this.searchedLocation=locality;
      this.filteredlocation=[];
      this.seachBoxShow=true;
      this.erroSearchMsgflat='';
  }
}//class
