import { Component, OnInit } from '@angular/core';
import { UsersSidebarLinks } from '../../model/users-sidebar-links';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent implements OnInit{

  userOption:string="UserAgent";
  userType:any[]=UsersSidebarLinks.options;

  
  constructor(private activeRoute:ActivatedRoute){}


  ngOnInit(): void {
      this.activeRoute.paramMap.subscribe((param)=>{
        this.userOption=param.get("userType");
      })
  }//ng
}//
