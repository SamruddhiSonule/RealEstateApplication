import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { UserDTO } from '../model/user-dto';

@Injectable({
  providedIn: 'root'
})
export class RealestateService implements OnInit {

  loggedOut:boolean=false;
  loggedIn:boolean=true;

  filteredPropertiesList:any[]=[];
  resultSearchNo:number;
  filteredPropertieShow:boolean=false;
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.resultSearchNo=this.filteredPropertiesList.length;
  }
//Agent
  Agent_UpdateProfile(userAgent1ID:any,userAgent2ID:any,userAgent:any){
    return this.http.put("http://localhost:8081/users/agent/update/"+userAgent1ID+"/"+userAgent2ID, userAgent)
  }//
  Agent_save(userAgent:any)
  {
    return this.http.post("http://localhost:8081/users/agent",userAgent)
  }
  Agent_getUserAgent(userBuilderEmail:any,password:any):Observable<UserDTO>
  {
   return this.http.get<UserDTO>("http://localhost:8081/users/agent/email/password/"+password+"/"+userBuilderEmail)
  }//
  Agent_getUserAgentByIDS(userAgent1ID,userAgent2ID)
  {
    return this.http.get("http://localhost:8081/users/agent/"+userAgent1ID+"/"+userAgent2ID);
  }
//Add Properties in Agent
  Agent_addProperty(userAgent1ID,userAgent2ID ,formData){
    return this.http.put("http://localhost:8081/properties/agent/"+userAgent1ID+"/"+userAgent2ID,formData);
  }
  Agent_getPropertyRentAndBuyListed(userAgent1ID,userAgent2ID)
  {
    return this.http.post("http://localhost:8081/properties/agent/"+userAgent1ID+"/"+userAgent2ID,null)
  }
//Property Search
  Location_Price_BudgetRB(location,flatBHK,budget,choice)
  {
    return this.http.get("http://localhost:8081/properties/agent/location/"+location+"/"+flatBHK+"/"+budget+"/"+choice);
  } 
  
  GetAllPropertiesRB()
  {
    return this.http.get("http://localhost:8081/properties/agent/getall")
  }

  Filters_SearchGetAll(propertylocality:string,price:number,propertyType:string,furnishing:string,forSaleOrRentString:string,facing:string,constructionPhase:string,flatBHK:string){
    return this.http.get("http://localhost:8081/properties/agent/filters/"+propertylocality+"/"+price+"/"+propertyType+"/"+furnishing+"/"+forSaleOrRentString+"/"+facing+"/"+constructionPhase+"/"+flatBHK);
  }
 //enquiry BOx Agent
  agent_storeEnquary(userAgent1ID,userAgent2ID,enquiryBox)
  {
    return this.http.post("http://localhost:8081/enquiryBox/agent/"+userAgent1ID+"/"+userAgent2ID,enquiryBox);
  } 

  //PG
  Agent_addPG(userAgent1ID,userAgent2ID,propertyPG)
  {
      return this.http.put("http://localhost:8081/properties/agent/pg/"+userAgent1ID+"/"+userAgent2ID, propertyPG);
  }

  Agent_getAllPropPGByIDs(userAgent1ID,userAgent2ID){
    return this.http.get("http://localhost:8081/properties/agent/pg/getall/"+userAgent1ID+"/"+userAgent2ID)
  }

  Agent_getPropertyPGByID(propertyID)
  {
    return this.http.get("http://localhost:8081/properties/agent/pg/"+propertyID);
  }
  Agent_addRoomsToPG(propertyPGID,formData)
  {
    return this.http.put("http://localhost:8081/properties/agent/pg/sharing/"+propertyPGID,formData);
  }
  Agent_getAllRoomsFromPGByID(propertyPGID)
  {
    return this.http.get("http://localhost:8081/sharingrooms/agent/pg/sharing/getall/"+propertyPGID);
  }
  Agent_getFilteredPGs(locality,onePersonRent,availableFor,foodAvailability,acRoomsAvailability,powerBackup)
  {
    return this.http.get("http://localhost:8081/properties/agent/filters/pg/"+locality+"/"+onePersonRent+"/"+availableFor+"/"+foodAvailability+"/"+acRoomsAvailability+"/"+powerBackup);
  }

  Agent_getPropertyPGListByLAR(locality,availableFor,onePersonRent)
  {
    return this.http.get("http://localhost:8081/property/agent/pg/LAR/"+locality+"/"+availableFor+"/"+onePersonRent);
  }
  Agent_getFilteredSR(propertyPGID,sharing,availableFor)
  {
    return this.http.get("http://localhost:8081/properties/agent/filters/pg/sr/"+propertyPGID+"/"+sharing+"/"+availableFor);
  }
//Enquiry Box
  Agent_getAllEnquiriesOFAgent(userAgent1ID,userAgent2ID)
  {
    return this.http.get("http://localhost:8081/enquiryBox/agent/getall/"+userAgent1ID+"/"+userAgent2ID);
  }
  Agent_updateEnquiryBoxWithStatus(enquiryBoxID,status)
  {
    return this.http.put("http://localhost:8081/enquiryBox/agent/status/"+enquiryBoxID+"/"+status, null )

  }

  
}//
