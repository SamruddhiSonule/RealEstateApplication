import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './includes/login/login.component';
import { SignupComponent } from './includes/signup/signup.component';
import { HomeComponent } from './common-header/home/home.component';
import { FrontPageComponent } from './common-header/front-page/front-page.component';



const routes: Routes = [
  
  {path:"", redirectTo:"property-for-sale-pune",pathMatch:"full"},
  {path:"property-for-sale-pune",component:FrontPageComponent},
  {path:"userauth/login",component:LoginComponent},
  {path:"gharImarat/User-registration",component:SignupComponent},
  {path:"userBuyer",loadChildren:()=>import('../app/user-buyer/user-buyer.module').then(file=>file.UserBuyerModule)},
  {path:'property-searched',loadChildren:()=>import('../app/property-search/property-search.module').then(file=>file.PropertySearchModule)},
  {path:"userAgent",loadChildren:()=>import('../app/user-agent/user-agent.module').then(file=>file.UserAgentModule)},
 {path:"users-dashboards",loadChildren:()=>import('../app/common-dashboard/common-dashboard.module').then(file=>file.CommonDashboardModule
  
 )}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
