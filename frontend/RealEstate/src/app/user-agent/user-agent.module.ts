import { ApplicationModule, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserAgentRoutingModule } from './user-agent-routing.module';
import { UserAgentDashboardComponent } from './user-agent-dashboard/user-agent-dashboard.component';
import { UserAgentHeaderComponent } from './user-agent-header/user-agent-header.component';
import { UserAgentSidebarComponent } from './user-agent-sidebar/user-agent-sidebar.component';
import { UserAgentProfileComponent } from './user-agent-profile/user-agent-profile.component';
import { UserAgentEditprofileComponent } from './user-agent-editprofile/user-agent-editprofile.component';
import { UserAgentAddpropertiesComponent } from './user-agent-addproperties/user-agent-addproperties.component';

import { UserAgentEnquiryboxComponent } from './user-agent-enquirybox/user-agent-enquirybox.component';
import { UserAgentUpdateprofileComponent } from './user-agent-updateprofile/user-agent-updateprofile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserAgentViewpropertiesComponent } from './user-agent-viewproperties/user-agent-viewproperties.component';
import { HttpClientModule } from '@angular/common/http';
import { AppModule } from '../app.module';



@NgModule({
  declarations: [
    UserAgentDashboardComponent,
    UserAgentHeaderComponent,
    UserAgentSidebarComponent,
    UserAgentProfileComponent,
    UserAgentEditprofileComponent,
    UserAgentAddpropertiesComponent,
    UserAgentEnquiryboxComponent,
    UserAgentUpdateprofileComponent,
    UserAgentViewpropertiesComponent,

  ],
  imports: [
    CommonModule,
    UserAgentRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ApplicationModule

  ]
})
export class UserAgentModule { }
