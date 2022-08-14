import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Boat } from '../models/boat';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-boats',
  templateUrl: './boats.component.html',
  styleUrls: ['./boats.component.css']
})
export class BoatsComponent implements OnInit {

  
  query: string;
  boatProfile: Boat;
  boatProfiles: Boat[];
  backupProfiles: Boat[];
  boatOwner : User;

  
  public isCollapsed = false;
  public isCollapsed1 = false;

  @Input() public newBoat: Boat;
  constructor(
    private authenticationService: AuthenticationService,
    private httpClient: HttpClient
  ) { 
    this.boatOwner = this.authenticationService.currentUserValue;
    this.boatProfile = new Boat();
    this.boatProfiles = [];
    this.backupProfiles = [];
    this.newBoat = new Boat();
    this.query = "";

    this.getAllBoats();
  }

  ngOnInit(): void {
    this.getAllBoats();
  }

  searchBoats(){

  }

  getAllBoats(){

  }

  openBoat(){

  }

  closeBoat(){

  }

  removeBoat(){

  }

  addNewBoat(){

  }

  updateBoat(){
    
  }

}
