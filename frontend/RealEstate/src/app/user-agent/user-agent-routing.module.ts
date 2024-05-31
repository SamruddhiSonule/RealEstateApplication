import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserAgentDashboardComponent } from './user-agent-dashboard/user-agent-dashboard.component';
import { UserAgentAddpropertiesComponent } from './user-agent-addproperties/user-agent-addproperties.component';
import { UserAgentUpdateprofileComponent } from './user-agent-updateprofile/user-agent-updateprofile.component';
import { UserAgentProfileComponent } from './user-agent-profile/user-agent-profile.component';
import { UserAgentEnquiryboxComponent } from './user-agent-enquirybox/user-agent-enquirybox.component';
import { UserAgentViewpropertiesComponent } from './user-agent-viewproperties/user-agent-viewproperties.component';
import { PropertySearchAddroomstopgComponent } from '../property-search/property-search-addroomstopg/property-search-addroomstopg.component';

const routes: Routes = [
  {path:'user-dashboard',component:UserAgentDashboardComponent,children:[
    {path:'addproperties',component:UserAgentAddpropertiesComponent,children:[
      {path:'add-rooms-pg/:propPGID',component:PropertySearchAddroomstopgComponent}
    ]},
    {path:'updateprofile',component:UserAgentUpdateprofileComponent},
    {path:'profile',component:UserAgentProfileComponent},
    {path:'updateprofile',component:UserAgentUpdateprofileComponent},
    {path:'enquiry',component:UserAgentEnquiryboxComponent},
    {path:'view-properties-listed',component:UserAgentViewpropertiesComponent},

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserAgentRoutingModule { }
