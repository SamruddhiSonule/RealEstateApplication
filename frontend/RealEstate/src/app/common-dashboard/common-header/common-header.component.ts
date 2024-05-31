import { Component } from '@angular/core';
import { UsersSidebarLinks } from '../../model/users-sidebar-links';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-common-header',
  templateUrl: './common-header.component.html',
  styleUrl: './common-header.component.css'
})
export class CommonHeaderComponent {


    userAgent:any;
  constructor(private router:Router,
    private service:RealestateService){}

    ngOnInit(): void {
      let userAgentSring= sessionStorage.getItem("userAgent");
      this.userAgent=JSON.parse(userAgentSring);
      console.log(this.userAgent);
      
    }
  userLogout(){
    sessionStorage.clear();
    this.router.navigateByUrl("")
    this.service.loggedOut=false;
    this.service.loggedIn=true;
  }
}//
