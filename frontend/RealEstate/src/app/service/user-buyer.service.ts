import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserBuyerService {

  constructor(private http:HttpClient) { }

  Buyer_PostUser(userBuyer)
  { debugger
    return this.http.post("http://localhost:8082/users/buyer",userBuyer);
  }//

  Buyer_getUserbuyerByEmailAndPassword(email,password)
  {
    return this.http.get("http://localhost:8082/users/buyer/getUsers/"+email+"/"+password);
  }//

  Buyer_updateUserBuyer(userBuyer1ID,userBuyer2ID,userBuyer)
  {
    return this.http.put("http://localhost:8082/users/buyer/updateUserBuyer/"+userBuyer1ID+"/"+userBuyer2ID,userBuyer)
  }

  Buyer_getUserbuyerByIds(userBuyer1ID,userBuyer2ID)
  {
    return this.http.get("http://localhost:8082/users/buyer/"+userBuyer1ID+"/"+userBuyer2ID );
  }

  Buyer_postPropertyRentAndBuyID(userBuyer1ID,userBuyer2ID,propRB)
  {
    return this.http.put("http://localhost:8082/properties/buyer/rentbuy/"+userBuyer1ID+"/"+userBuyer2ID, propRB);

  }
  Buyer_deletePropertyRentAndBuy(propertyRBID)
  {
    return this.http.delete("http://localhost:8082/properties/buyer/rb/del/"+propertyRBID);
  }
  Buyer_confirmFavoriteProRB(userBuyer1ID,userBuyer2ID,propertyRBIDSave)
  {
    return this.http.get("http://localhost:8082/properties/buyer/rb/fav/"+userBuyer1ID+"/"+userBuyer2ID+"/"+propertyRBIDSave)
  }
  Buyer_deletePropRB(userBuyer1ID,userBuyer2ID,propertyRBID){
    return this.http.delete("http://localhost:8082/properties/buyer/rb/del/"+userBuyer1ID+"/"+userBuyer2ID+"/"+propertyRBID);
  }
  Buyer_getFavProperties(userBuyer1ID,userBuyer2ID)
  {
     return this.http.get("http://localhost:8082/properties/buyer/rb/getall/"+userBuyer1ID+"/"+userBuyer2ID);
  }
}//
