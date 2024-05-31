import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-agent-profile',
  templateUrl: './user-agent-profile.component.html',
  styleUrl: './user-agent-profile.component.css'
})
export class UserAgentProfileComponent implements OnInit {

  userAgent:any;
ngOnInit(): void {
  let userAgentSring= sessionStorage.getItem("userAgent");
  this.userAgent=JSON.parse(userAgentSring);
  console.log(this.userAgent);
  
}
}//
