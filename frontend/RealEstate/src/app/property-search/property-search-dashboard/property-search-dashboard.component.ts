import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { RealestateService } from '../../service/realestate.service';
import { MatDialog } from '@angular/material/dialog';
import { UsersContactPopupComponent } from '../users-contact-popup/users-contact-popup.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-property-search-dashboard',
  templateUrl: './property-search-dashboard.component.html',
  styleUrl: './property-search-dashboard.component.css'
})
export class PropertySearchDashboardComponent implements OnInit {

  @ViewChild('scroll')
  scrollH:ElementRef;
  propertySRP:string;

  constructor(private activeRoute:ActivatedRoute){}

    ngOnInit(): void {
       this.activeRoute.paramMap.subscribe((param)=>
      {
        this.propertySRP=param.get("choice");
        console.log("Choice: "+ this.propertySRP);
        sessionStorage.setItem("choice", this.propertySRP);
      }
      ) 
    }//

}//
