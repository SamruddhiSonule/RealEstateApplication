import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';



import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './includes/login/login.component';
import { LoginHeaderComponent } from './includes/login-header/login-header.component';
import { LoginFormComponent } from './includes/login-form/login-form.component';
import { LoginFooterComponent } from './includes/login-footer/login-footer.component';
import { SignupComponent } from './includes/signup/signup.component';
import { SignupFormComponent } from './includes/signup-form/signup-form.component';
import { SignupHeaderComponent } from './includes/signup-header/signup-header.component';
import { SignupFooterComponent } from './includes/signup-footer/signup-footer.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonHeaderModule } from './common-header/common-header.module';
import { MatDialogModule } from '@angular/material/dialog';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';





@NgModule({
  declarations: [
    AppComponent,


    LoginComponent,
  
    LoginHeaderComponent,
    LoginFormComponent,
    LoginFooterComponent,
    SignupComponent,
    SignupFormComponent,
    SignupHeaderComponent,
    SignupFooterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonHeaderModule,
    MatDialogModule,
    
    
  
    
  ],
  exports:[
  
  ],

  providers: [
    provideAnimationsAsync('noop')
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
