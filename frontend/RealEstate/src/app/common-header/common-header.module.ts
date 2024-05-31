import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CommonHeaderRoutingModule } from './common-header-routing.module';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { EngagementComponent } from './engagement/engagement.component';
import { SearchComponent } from './search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FrontPageComponent } from './front-page/front-page.component';


@NgModule({
  declarations: [
    HeaderComponent,
     HomeComponent,
      FooterComponent,
      EngagementComponent,
      SearchComponent,
      FrontPageComponent
    ],
  imports: [
    CommonModule,
    CommonHeaderRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  exports:[
    HeaderComponent,
     HomeComponent,
      FooterComponent,
      EngagementComponent,
      SearchComponent,
      FrontPageComponent
  ]
})
export class CommonHeaderModule { }
