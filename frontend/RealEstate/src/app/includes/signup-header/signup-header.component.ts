import { Component } from '@angular/core';

@Component({
  selector: 'app-signup-header',
  templateUrl: './signup-header.component.html',
  styleUrl: './signup-header.component.css'
})
export class SignupHeaderComponent {

  nevigateToLogin(){
    //  const url= this.router.navigateByUrl("userauth/login",{replaceUrl: true});
     window.open("userauth/login","_blank");
    }
}//class
