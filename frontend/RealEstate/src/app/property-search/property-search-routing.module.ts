import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PropertysearchViewsearchedComponent } from './propertysearch-viewsearched/propertysearch-viewsearched.component';

import { PropertySearchDashboardComponent } from './property-search-dashboard/property-search-dashboard.component';
import { PropertySearchPropertyDetailsComponent } from './property-search-property-details/property-search-property-details.component';
import { ComparePropertyComponent } from './compare-property/compare-property.component';

const routes: Routes = [
  {path:"searched-properties/:locality",component:PropertySearchDashboardComponent,children:[
    
  ]},
  {path:"searched-properties-buy/:choice/:locality/:bhk/:budget",component:PropertySearchDashboardComponent,children:[
    
  ]},
  {path:"searched-properties-buy-top/:locality/:bhk/:budget",component:PropertySearchDashboardComponent,children:[
    
  ]},
  {path:"property-details/:userAgent1ID/:userAgent2ID",component:PropertySearchPropertyDetailsComponent},
  {path:"property-detailsPG/:userAgent1ID/:userAgent2ID/:propPGID",component:PropertySearchPropertyDetailsComponent},
  {path:"compare-details/:userAgent1ID/:userAgent2ID/:propId/:choice",component:PropertySearchDashboardComponent},
  // {path:"compare-details-with/:user1IDC/:user2IDC/:user1IDCW/:user2IDCW",component:ComparePropertyComponent},
  {path:"compare-details-with/:user1IDC/:user2IDC",component:ComparePropertyComponent},
  
];
  
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PropertySearchRoutingModule { }
