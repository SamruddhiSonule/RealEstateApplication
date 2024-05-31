import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-engagement',
  templateUrl: './engagement.component.html',
  styleUrl: './engagement.component.css'
})
export class EngagementComponent {


  constructor(private router:Router){}
  navigateToViewSearched(choice){
    if(choice=='buy')
      {
        this.router.navigateByUrl("property-searched/searched-properties-buy/"+"buy"+"/"+"Hinjewadi"+"/"+"3Bhk"+"/"+7000000);
      }
      if(choice=='Rent')
        {
          this.router.navigateByUrl("property-searched/searched-properties-buy/"+"Rent"+"/"+"Hinjewadi"+"/"+"2Bhk"+"/"+30000);
        }
      if(choice=='PG')
          {
            this.router.navigateByUrl("property-searched/searched-properties-buy/"+"PG"+"/"+"Hinjewadi"+"/"+"Combine"+"/"+15000);
          }
  }//
}//
