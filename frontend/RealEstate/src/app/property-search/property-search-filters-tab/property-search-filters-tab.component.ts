import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RealestateService } from '../../service/realestate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-property-search-filters-tab',
  templateUrl: './property-search-filters-tab.component.html',
  styleUrl: './property-search-filters-tab.component.css'
})
export class PropertySearchFiltersTabComponent implements OnInit {
  localitiesInPune:string[]=["Kharadi","Wakad","Hinjewadi","Baner","Wagholi","Pimpri Chinchwad","Ravet","Hadapsar","Kothrud","Pimple Saudagar","Viman Nagar","Magar Patta","Aundh","KoreGao Park","Bavdhan","Dhanori","Undri","Balewadi","Katraj","Kalyani Nagar","Warje"];

  showRent:string="";
  noRecordsFound:boolean=false;
  selectedLocality:string;
  property:any[]=[];
  filteredProperties:any[]=[];

  showResultsForRentBuy:string;
 
  showResultsForPG:string;
  
//for Buy And rent
  budgetBuyOptions = [

    { label: '₹50 Lac', value: '5000000' },
    { label: '₹70 Lac', value: '7000000' },
    { label: '₹80 Lac', value: '8000000' },
    { label: '₹90 Lac', value: '9000000' },
    { label: '₹1 Cr.', value: '10000000' },
    { label: '₹1.5 Cr. or above', value: '15000000' }
  ];
  bhkFlat:string[]=["1Bhk","2Bhk","3Bhk", "4BHK", "5Bhk", "6Bhk"];
  propertyType:string[]=["Multistorey Apartment","Villa"]
  facing:string[]=["North-facing","South-facing","East-facing","West-facing","North-West-facing","North-East-facing","South-West-facing","South-East-facing"]
  constructionPhase:string[]=["Under Construction","Ready To move"]
  noOfBedrooms:string[]=["1","2","3","4","5","6"]

  furnishing:string[]=["Furnished","Unfurnished"];

  forSaleOrRentString:string[]=["Rent","buy"]
  numberOfBathrooms:number[]=[1,2,3,4,5,6];

  //for pg
  budgetPGOptions = [
    
    { label: '₹4000', value: '4000' },
    { label: '₹6000', value: '60000'},
    { label: '₹8000', value: '8000'},
    { label: '₹9000', value: '9000'},
    { label: '₹10000', value: '10000' },
    { label: '₹12000', value: '12000' },
    { label: '₹15000', value: '15000' },
    { label: '₹17000', value: '17000' },
    { label: '₹18000', value: '18000' },
    
  ];

  filters:FormGroup;
  filtersPG:FormGroup;
  constructor(private fb:FormBuilder,
              public service:RealestateService,
              private router:Router
  ){}

  ngOnInit(): void {
      this.filters=this.fb.group({
        locality:[],
        price:[],
        propertyType:[],
        furnishing:[],
        forSaleOrRentString:[],
        facing:[],
        constructionPhase:[],
        flatBHK:[],
      })
      this.filtersPG=this.fb.group({
          locality:[],
          onePersonRent:[],
          availableFor:[],
          foodAvailability:[],
          acRoomsAvailability:[],
          powerBackup:[]
      })
     
      this.filters.controls['price'].setValue(0);
      this.filtersPG.controls['onePersonRent'].setValue(0);
      const choice=sessionStorage.getItem("choice");

      if(choice=="buy")
        {
            this.showResultsForRentBuy="show";
            this.service.GetAllPropertiesRB().subscribe((data:any[])=>{
              this.property=data;
              this.showRent="";
            })
        }
      if(choice=="Rent")
        {
            this.showResultsForRentBuy="show";
            this.showRent="show"
        }
      if(choice=="PG")
        {
            this.showResultsForPG="show";
        }
          
  }//

  onSearchFilters(){
   
    if(this.showResultsForRentBuy!=null || this.showResultsForRentBuy!=null)
      {
        
    this.filteredProperties=this.property.filter(
      property=>{
                  return(
                          (!this.filters.controls['locality'].value || property.propertyLocality===this.filters.controls['locality'].value) &&
                          (!this.filters.controls['price'].value || property.price <= this.filters.controls['price'].value) &&
                          (!this.filters.controls['propertyType'].value || property.propertyTYPE === this.filters.controls['propertyType'].value) &&
                          (!this.filters.controls['furnishing'].value || property.furnishing === this.filters.controls['furnishing'].value) &&
                          (!this.filters.controls['forSaleOrRentString'].value || property.forSaleOrRentString === this.filters.controls['forSaleOrRentString'].value) &&
                          (!this.filters.controls['facing'].value || property.facing === this.filters.controls['facing'].value) &&
                          (!this.filters.controls['constructionPhase'].value || property.constructionPhase === this.filters.controls['constructionPhase'].value) &&
                          (!this.filters.controls['flatBHK'].value || property.flatBHK === this.filters.controls['flatBHK'].value)
                  );
                });
  //   this.service.Filters_SearchGetAll(this.filters.controls['locality'].value,
  //                                     this.filters.controls['price'].value,                                      
  //                                     this.filters.controls['propertyType'].value,
  //                                     this.filters.controls['furnishing'].value,
  //                                     this.filters.controls['forSaleOrRentString'].value,
  //                                     this.filters.controls['facing'].value,
  //                                     this.filters.controls['constructionPhase'].value,
  //                                     this.filters.controls['flatBHK'].value
  //  ).subscribe((data:any[])=>this.service.filteredPropertiesList=data)

    if(this.filteredProperties.length===0)
      { console.log("routeeeeeeeeeeeeeeeeeeee");
    alert("No RB Record Found..!")
         window.location.reload();
       
      }
    console.log("price: "+this.filters.controls['price'].value);
    
    console.log(this.filters.value);
    console.log( this.filteredProperties);
    this.service.filteredPropertiesList=this.filteredProperties;
    this.service.filteredPropertieShow=true;
      }//if

    if( this.showResultsForPG!=null){


    } //if 

    
  }//s
  onSearchFiltersPG(){

      this.service.Agent_getFilteredPGs(this.filtersPG.controls['locality'].value, 
      this.filtersPG.controls['onePersonRent'].value, 
      this.filtersPG.controls['availableFor'].value, 
      this.filtersPG.controls['foodAvailability'].value, 
      this.filtersPG.controls['acRoomsAvailability'].value, 
      this.filtersPG.controls['powerBackup'].value).subscribe((data:any)=>{
        this.filteredProperties=data;
        this.service.filteredPropertiesList=this.filteredProperties;
        console.log(data.length);
        if(data.length===0)
          { console.log("routeeeeeeeeeeeeeeeeeeee");
        alert("No PG Record Found..!")
             window.location.reload();
           
          }
      });
     
  }//onspg

  onLocalityChange(event)
  {
    if(event.target.value === 'null')
      {
        this.filters.controls['locality'].setValue(null,{emitEvent:false})
        this.filtersPG.controls['locality'].setValue(null,{emitEvent:false})
      }
  }
  onFacingChange(event)
  {
    if(event.target.value === 'null')
      {
        this.filters.controls['facing'].setValue(null,{emitEvent:false})
        this.filtersPG.controls['onePersonRent'].setValue(null,{emitEvent:false})
      }
  }
  // locality:[],
  //         onePersonRent:[],
  //         availableFor:[],
  //         foodAvailability:[],
  //         acRoomsAvailability:[],
  //         powerBackup:[]
  onBudgetChange(event){

    if(event.target.value === 'null')
      {
        this.filters.controls['price'].setValue(0);
        this.filtersPG.controls['availableFor'].setValue(null,{emitEvent:false})
      }

  }
  onProppertyTypeChange(event){

    if(event.target.value === 'null')
      {
        this.filters.controls['propertyType'].setValue(null,{emitEvent:false})
        this.filtersPG.controls['acRoomsAvailability'].setValue("UnAvailable",{emitEvent:false})
      }
  }
  onFurnishingChange(event){

    if(event.target.value === 'null')
      {
        this.filters.controls['furnishing'].setValue(null,{emitEvent:false})
      }
  }
  onForROSChange(event){

    if(event.target.value === 'null')
      {
        this.filters.controls['forSaleOrRentString'].setValue(null,{emitEvent:false})
      }
  }
  onConstrPhaseChange(event){
    if(event.target.value === 'null')
      {
        this.filters.controls['constructionPhase'].setValue(null,{emitEvent:false})
      }
  }
  onFlatBHKChange(event){
    if(event.target.value === 'null')
      {
        this.filters.controls['flatBHK'].setValue(null,{emitEvent:false})
      }
  }
  // locality:[],
  // price:[],
  // propertyType:[],
  // furnishing:[],
  // forSaleOrRentString:[],
  // facing:[],
  // constructionPhase:[],
  // flatBHK:[],
}//
