import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { House } from '../models/house';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-houses',
  templateUrl: './houses.component.html',
  styleUrls: ['./houses.component.css']
})
export class HousesComponent implements OnInit {

  query: string;
  houseProfile: House;
  houses: House[];
  backupHouses: House[];
  houseOwner : User;

  @Input() public newHouse: House;
  constructor(private authenticationService: AuthenticationService,
    private httpClient: HttpClient) {

    this.houseOwner = this.authenticationService.currentUserValue;
    this.houseProfile = new House();
    this.houses = [];
    this.backupHouses = [];
    this.newHouse = new House();
    this.query = "";

   }

  ngOnInit(): void {
  }

  searchHouses(){
    this.houses = JSON.parse(JSON.stringify(this.backupHouses));
    this.houses = this.houses.filter(el => (el.address.toUpperCase().includes(this.query.toUpperCase()) || el.description.toUpperCase().includes(this.query.toUpperCase()) || el.name.toUpperCase().includes(this.query.toUpperCase()) ));
  
  }

  getHouses (){

  }

  openHouse(){
    
  }
  deleteHouse(){

  }
}
