import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserBuilderRoutingModule } from './user-builder-routing.module';
import { UserBuilderDashboardComponent } from './user-builder-dashboard/user-builder-dashboard.component';
import { UserBuilderAddpropertiesComponent } from './user-builder-addproperties/user-builder-addproperties.component';
import { UserBuilderAnalyticsComponent } from './user-builder-analytics/user-builder-analytics.component';
import { UserBuilderEditprofileComponent } from './user-builder-editprofile/user-builder-editprofile.component';
import { UserBuilderEnquiryboxComponent } from './user-builder-enquirybox/user-builder-enquirybox.component';
import { UserBuilderHeaderComponent } from './user-builder-header/user-builder-header.component';
import { UserBuilderProfileComponent } from './user-builder-profile/user-builder-profile.component';
import { UserBuilderSidebarComponent } from './user-builder-sidebar/user-builder-sidebar.component';


@NgModule({
  declarations: [
    UserBuilderDashboardComponent,
    UserBuilderAddpropertiesComponent,
    UserBuilderAnalyticsComponent,
    UserBuilderEditprofileComponent,
    UserBuilderEnquiryboxComponent,
    UserBuilderHeaderComponent,
    UserBuilderProfileComponent,
    UserBuilderSidebarComponent
  ],
  imports: [
    CommonModule,
    UserBuilderRoutingModule
  ]
})
export class UserBuilderModule { }
