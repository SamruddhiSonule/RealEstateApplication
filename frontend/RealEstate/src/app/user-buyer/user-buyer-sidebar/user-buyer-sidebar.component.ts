import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-buyer-sidebar',
  templateUrl: './user-buyer-sidebar.component.html',
  styleUrl: './user-buyer-sidebar.component.css'
})
export class UserBuyerSidebarComponent {

  constructor(private router:Router){}
  navigateToProfile(){
    this.router.navigateByUrl("url")
  }//

}//
