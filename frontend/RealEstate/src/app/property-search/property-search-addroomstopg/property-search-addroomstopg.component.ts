import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RealestateService } from '../../service/realestate.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-property-search-addroomstopg',
  templateUrl: './property-search-addroomstopg.component.html',
  styleUrl: './property-search-addroomstopg.component.css'
})
export class PropertySearchAddroomstopgComponent implements OnInit {

  propertyPGID:any;
  propertyPG:any;

  images:any[]=[];
  sharingRooms:FormGroup;
  constructor(private fb :FormBuilder,
              private service:RealestateService,
              private activeRoute:ActivatedRoute
  ){}

ngOnInit(): void {
   this.sharingRooms=this.fb.group(
    {
      roomPGID:[],
      roomNo:[], 	
      sharing:[],
      rent:[],
      foodAvailability:[],  
      amenities:[],
      location:[],//done
      availableFor:[],
      propertyPGID:[]
   }
  ) 
  this.activeRoute.paramMap.subscribe((param)=>{
    this.propertyPGID=param.get("propPGID");
    this.service.Agent_getPropertyPGByID(this.propertyPGID).subscribe((data:any)=>{
      this.propertyPG=data;
      this.sharingRooms.controls['propertyPGID'].setValue(this.propertyPGID);
      this.sharingRooms.controls['location'].setValue(this.propertyPG.location);
    });
  })
  
  
 
  
}//
onImages1(event)
{
  const maxSize=7;
  if(event.target.files.length >= maxSize)
    {
      alert("Upload upto 7 Images..!");
      event.target.value=null;
    }
    else{
      for(let i=0;i<event.target.files.length;i++)
        {
          const file=event.target.files[i];
          this.images.push(file);
        }
        console.log(this.images);
    }

}
onSubmit(){
    const formData= new FormData;
    const sharingRoomsS=JSON.stringify(this.sharingRooms.value);
    formData.append("text", sharingRoomsS);
    for(let i=0;i<this.images.length;i++)
      {
        formData.append("images", this.images[i]);
      }
      
      console.log(this.sharingRooms.value);
      this.service.Agent_addRoomsToPG(this.propertyPGID, formData).subscribe();
      
}//
}//
