import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { RealestateService } from '../../service/realestate.service';
import { UserDTO } from '../../model/user-dto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
  encapsulation: ViewEncapsulation.None  // Disable view encapsulation
})
export class HeaderComponent implements OnInit {

  sellYourProperty:string="";
  user:any;
  localitiesInPune:string[]=["Kharadi","Wakad","Hinjewadi","Baner","Wagholi","Pimpri Chinchwad","Ravet","Hadapsar","Kothrud","Pimple Saudagar","Viman Nagar","Magar Patta","Aundh","KoreGao Park","Bavdhan","Dhanori","Undri","Balewadi","Katraj","Kalyani Nagar","Warje"];
  selectedLocalityy:string;
  userLogedin:boolean=false;
  userProfileLogged:boolean=true;
  constructor(private router:Router,
              public service:RealestateService){}

  ngOnInit(): void {
    if(this.service.loggedOut==false){
      this.userLogedin=true;
      this.userProfileLogged=false;
    }
    if(this.service.loggedIn==true)
    {
      this.userLogedin=false;
      this.userProfileLogged=true;
    }
    const user= sessionStorage.getItem("userAgent")
    this.user=JSON.parse(user);

    if(sessionStorage.getItem("userAgent")!=null && this.user.userType==="UserAgent")
      {
        this.service.loggedIn=false;
        this.service.loggedOut=true;
        this.sellYourProperty="show";
      }
      else{
       
        this.service.loggedIn=false;
        this.service.loggedOut=true;
      }

      
  }//ng

  nevigateToLogin(){
  //  const url= this.router.navigateByUrl("userauth/login",{replaceUrl: true});
   window.open("userauth/login","_blank");
  }

  navigateToSignUp()
  {
    window.open("gharImarat/User-registration","_blank");
  }

  nevigateToProfile(){
   const user= sessionStorage.getItem("userAgent");
   const userObject=JSON.parse(user);
   
   
   if(userObject.userType =="UserAgent")
    {
      this.router.navigateByUrl("users-dashboards/dashboard/"+userObject.userType);
      
    }
    if(userObject.userType =="UserBuyer")
      {
        this.router.navigateByUrl("users-dashboards/dashboard/"+userObject.userType);
        
      }
    // window.open("userBuyer/user-dashboard","_blank");
  }
  userLogout(){
    this.service.loggedOut=false;
    this.service.loggedIn=true;
    sessionStorage.clear();
    this.sellYourProperty=""
    
  }
  selectedLocality(locality:string){
    this.selectedLocalityy=locality;
    console.log(this.selectedLocalityy);
    this.router.navigateByUrl("property-searched/searched-properties/"+this.selectedLocalityy)
    
  }
  navigateToAddProperty(){
    this.router.navigateByUrl("userAgent/user-dashboard/addproperties");
  }
}//
