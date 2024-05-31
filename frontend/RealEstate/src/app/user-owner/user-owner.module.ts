import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserOwnerRoutingModule } from './user-owner-routing.module';
import { UserOwnerDashboardComponent } from './user-owner-dashboard/user-owner-dashboard.component';
import { UserOwnerAddpropertiesComponent } from './user-owner-addproperties/user-owner-addproperties.component';
import { UserOwnerAnalyticsComponent } from './user-owner-analytics/user-owner-analytics.component';
import { UserOwnerEditprofileComponent } from './user-owner-editprofile/user-owner-editprofile.component';
import { UserOwnerEnquiryboxComponent } from './user-owner-enquirybox/user-owner-enquirybox.component';
import { UserOwnerHeaderComponent } from './user-owner-header/user-owner-header.component';
import { UserOwnerProfileComponent } from './user-owner-profile/user-owner-profile.component';
import { UserOwnerSidebarComponent } from './user-owner-sidebar/user-owner-sidebar.component';


@NgModule({
  declarations: [
    UserOwnerDashboardComponent,
    UserOwnerAddpropertiesComponent,
    UserOwnerAnalyticsComponent,
    UserOwnerEditprofileComponent,
    UserOwnerEnquiryboxComponent,
    UserOwnerHeaderComponent,
    UserOwnerProfileComponent,
    UserOwnerSidebarComponent
  ],
  imports: [
    CommonModule,
    UserOwnerRoutingModule
  ]
})
export class UserOwnerModule { }
