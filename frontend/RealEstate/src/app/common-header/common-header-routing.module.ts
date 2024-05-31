import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../common-dashboard/dashboard/dashboard.component';
import { SidebarComponent } from '../common-dashboard/sidebar/sidebar.component';
import { HeaderComponent } from './header/header.component';
import { LinkpagesComponent } from '../common-dashboard/linkpages/linkpages.component';

const routes: Routes = [
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CommonHeaderRoutingModule { }
