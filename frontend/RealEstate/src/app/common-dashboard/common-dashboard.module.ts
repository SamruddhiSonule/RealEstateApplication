import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CommonDashboardRoutingModule } from './common-dashboard-routing.module';

import { DashboardComponent } from './dashboard/dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { LinkpagesComponent } from './linkpages/linkpages.component';
import { CommonHeaderComponent } from './common-header/common-header.component';


@NgModule({
  declarations: [
  
    DashboardComponent,
    SidebarComponent,
    LinkpagesComponent,
    CommonHeaderComponent
  ],
  imports: [
    CommonModule,
    CommonDashboardRoutingModule
  ]
})
export class CommonDashboardModule { }
