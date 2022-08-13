import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import { HouseService } from '../services/house.service';
import { House } from '../models/house';
import { isThursday } from 'date-fns';

@Component({
  selector: 'app-house-owner-profile',
  templateUrl: './house-owner-profile.component.html',
  styleUrls: ['./house-owner-profile.component.css']
})
export class HouseOwnerProfileComponent implements OnInit {

  houseOwner: User;
  currPass: string;
  newPass: string;
  confPass: string;


  @Input() public updateHouseOwner: User;
  constructor( private authenticationService: AuthenticationService,
              private httpClient: HttpClient,
              private userService: UserService,
              private dialog: MatDialog) { 

    this.houseOwner = this.authenticationService.currentUserValue;   
    this.updateHouseOwner = this.authenticationService.currentUserValue;   
    this.currPass = "";
    this.newPass = "";
    this.confPass = "";   

  }

  ngOnInit(): void {
    
  }


  updateHouseOwnerProfile(){
    if(this.currPass == "" && this.newPass == "" && this.confPass == ""){
      this.userService.UpdateUser(this.updateHouseOwner).subscribe((data: any) => {
        this.houseOwner = this.updateHouseOwner;  
        alert("Successfuly updated.");  
      }); 
    }
    else{
      if(this.currPass == this.houseOwner.password && this.newPass == this.confPass){
        this.updateHouseOwner.password = this.newPass;
        this.userService.UpdateUser(this.updateHouseOwner).subscribe((data: any) => {
          this.houseOwner = this.updateHouseOwner;
          alert("Successfuly updated.");  
        });
      }
      else{
        alert("Your current password or confirm password is wrong. Try again or leave empty.")
      }
    }
  }



requestDelete(){
  this.houseOwner.deleteRequested = true;
  this.userService.UpdateUser(this.houseOwner).subscribe();
}
 

}
