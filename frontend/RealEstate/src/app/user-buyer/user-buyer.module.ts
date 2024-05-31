import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserBuyerRoutingModule } from './user-buyer-routing.module';
import { UserBuyerDashboardComponent } from './user-buyer-dashboard/user-buyer-dashboard.component';

import { UserBuyerSidebarComponent } from './user-buyer-sidebar/user-buyer-sidebar.component';
import { UserBuyerHeaderComponent } from './user-buyer-header/user-buyer-header.component';
import { UserBuyerFavoritesComponent } from './user-buyer-favorites/user-buyer-favorites.component';
import { UserBuyerFormComponent } from './user-buyer-form/user-buyer-form.component';
import { UserBuyerProfileComponent } from './user-buyer-profile/user-buyer-profile.component';

import { UserBuyerEditprofileComponent } from './user-buyer-editprofile/user-buyer-editprofile.component';
import { ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    UserBuyerDashboardComponent,
    UserBuyerFormComponent,
    UserBuyerSidebarComponent,
    UserBuyerHeaderComponent,
    UserBuyerFavoritesComponent,
    UserBuyerProfileComponent,
    UserBuyerEditprofileComponent,



  ],
  imports: [
    CommonModule,
    UserBuyerRoutingModule,
    ReactiveFormsModule
  ]
})
export class UserBuyerModule { }
