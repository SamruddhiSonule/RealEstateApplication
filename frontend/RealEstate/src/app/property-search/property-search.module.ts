import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PropertySearchRoutingModule } from './property-search-routing.module';
import { PropertysearchHeaderComponent } from './propertysearch-header/propertysearch-header.component';
import { PropertysearchViewsearchedComponent } from './propertysearch-viewsearched/propertysearch-viewsearched.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonHeaderModule } from '../common-header/common-header.module';
import { PropertySearchFiltersTabComponent } from './property-search-filters-tab/property-search-filters-tab.component';
import { PropertySearchDashboardComponent } from './property-search-dashboard/property-search-dashboard.component';
import { PropertySearchPropertyDetailsComponent } from './property-search-property-details/property-search-property-details.component';
import { UsersContactPopupComponent } from './users-contact-popup/users-contact-popup.component';
import { ComparePropertyComponent } from './compare-property/compare-property.component';
import { PopupCompareComponent } from './popup-compare/popup-compare.component';
import { EnquiryPopupComponent } from './enquiry-popup/enquiry-popup.component';
import { PropertySearchAddroomstopgComponent } from './property-search-addroomstopg/property-search-addroomstopg.component';
import { PopupEnquiryForPGComponent } from './popup-enquiry-for-pg/popup-enquiry-for-pg.component';





@NgModule({
  declarations: [
    PropertysearchHeaderComponent,
    PropertysearchViewsearchedComponent,

    PropertySearchFiltersTabComponent,
    PropertySearchDashboardComponent,
    PropertySearchPropertyDetailsComponent,
    UsersContactPopupComponent,
    ComparePropertyComponent,
    PopupCompareComponent,
    EnquiryPopupComponent,
    PropertySearchAddroomstopgComponent,
    PopupEnquiryForPGComponent,

 
  ],
  imports: [
    CommonModule,
    PropertySearchRoutingModule,
    FormsModule,
    CommonHeaderModule,
    ReactiveFormsModule
   
    
  ]
})
export class PropertySearchModule { }
