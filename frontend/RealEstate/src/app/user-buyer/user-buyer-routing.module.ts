import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserBuyerDashboardComponent } from './user-buyer-dashboard/user-buyer-dashboard.component';
import { UserBuyerSidebarComponent } from './user-buyer-sidebar/user-buyer-sidebar.component';
import { UserBuyerProfileComponent } from './user-buyer-profile/user-buyer-profile.component';
import { UserBuyerEditprofileComponent } from './user-buyer-editprofile/user-buyer-editprofile.component';
import { UserBuyerFavoritesComponent } from './user-buyer-favorites/user-buyer-favorites.component';

const routes: Routes = [
  {path:"user-dashboard",component:UserBuyerDashboardComponent,children:[
    {path:"user-profile",component:UserBuyerProfileComponent},
    {path:"user-editprofile", component:UserBuyerEditprofileComponent},
    {path:"user-favorites", component:UserBuyerFavoritesComponent},
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserBuyerRoutingModule { }
