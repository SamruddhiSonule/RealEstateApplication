import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';

@Component({
  selector: 'app-user-agent-header',
  templateUrl: './user-agent-header.component.html',
  styleUrl: './user-agent-header.component.css'
})
export class UserAgentHeaderComponent implements OnInit {

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
