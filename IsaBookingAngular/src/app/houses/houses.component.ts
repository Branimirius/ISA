import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { House } from '../models/house';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { HouseService } from '../services/house.service';

@Component({
  selector: 'app-houses',
  templateUrl: './houses.component.html',
  styleUrls: ['./houses.component.css']
})
export class HousesComponent implements OnInit {

  query: string;
  houseProfile: House;
  houseProfiles: House[];
  backupProfiles: House[];
  houseOwner : User;

  


  @Input() public newHouse: House;
  constructor(private authenticationService: AuthenticationService,
    private httpClient: HttpClient, private houseService: HouseService) {

    this.houseOwner = this.authenticationService.currentUserValue;
    this.houseProfile = new House();
    this.houseProfiles = [];
    this.backupProfiles = [];
    this.newHouse = new House();
    this.query = "";

    this.getAllHouses();

   }

  ngOnInit(): void {

    this.getAllHouses();
    
  }

  searchHouses(){

    this.houseProfiles = JSON.parse(JSON.stringify(this.backupProfiles));
    this.houseProfiles = this.houseProfiles.filter(el => (el.address.toUpperCase().includes(this.query.toUpperCase()) || (el.name.toUpperCase().includes(this.query.toUpperCase())) || el.description.toUpperCase().includes(this.query.toUpperCase())));
  
  }

  getAllHouses(){
    this.houseService.getAllHouses()
      .subscribe((data: any) => {
        this.houseProfiles.length = 0;
        this.backupProfiles.length = 0;
        for(const d of (data as any)){
          if(this.authenticationService.currentUserValue.id == d.userId){          
            this.houseProfiles.push(d);
            this.backupProfiles.push(d); 
          }         
        }
      })
  }

  openHouse(){
    
  }

  removeHouse(house: number){
    this.houseService.removeHouse(house).subscribe((data:any) => {
      if(data.deleted == true){
        this.houseProfiles.filter(el => el.id != house);
        this.getAllHouses();
      }else{
        alert("You can't delete this house.");
      }
    })
  }
}
