import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-boat-owner-profile',
  templateUrl: './boat-owner-profile.component.html',
  styleUrls: ['./boat-owner-profile.component.css']
})
export class BoatOwnerProfileComponent implements OnInit {

  boatOwner: User;
  currPass: string;
  newPass: string;
  confPass: string;

  @Input() public updateBoatOwner: User;
  constructor(private authenticationService: AuthenticationService,
    private httpClient: HttpClient,
    private userService: UserService,
    private dialog: MatDialog) { 

      this.boatOwner = this.authenticationService.currentUserValue;   
      this.updateBoatOwner = this.authenticationService.currentUserValue;   
      this.currPass = "";
      this.newPass = "";
      this.confPass = "";   
    }

  ngOnInit(): void {
  }

  updateBoatOwnerProfile(){
    if(this.currPass == "" && this.newPass == "" && this.confPass == ""){
      this.userService.UpdateUser(this.updateBoatOwner).subscribe((data: any) => {
        this.boatOwner = this.updateBoatOwner;  
        alert("Successfuly updated.");  
      }); 
    }
    else{
      if(this.currPass == this.boatOwner.password && this.newPass == this.confPass){
        this.updateBoatOwner.password = this.newPass;
        this.userService.UpdateUser(this.updateBoatOwner).subscribe((data: any) => {
          this.boatOwner = this.updateBoatOwner;
          alert("Successfuly updated.");  
        });
      }
      else{
        alert("Your current password or confirm password is wrong. Try again or leave empty.")
      }
    }
  }
  
requestDelete(){
  this.boatOwner.deleteRequested = true;
  this.userService.UpdateUser(this.boatOwner).subscribe();
}

}
