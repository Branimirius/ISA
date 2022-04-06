import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  adminProfile: User;
  updatedProfile: User;
  pendingRegistrations: User[];
  activeUsers: User[];
  passwordConfirm : string;

  constructor(private authenticationService: AuthenticationService,
              private userService: UserService) { 
    this.adminProfile = authenticationService.currentUserValue;
    this.updatedProfile = authenticationService.currentUserValue;
    this.pendingRegistrations = [];
    this.activeUsers = [];
    this.passwordConfirm = "";
    this.GetUsers();
  }

  ngOnInit(): void {
    this.GetUsers();
  }

  GetUsers(){
    this.userService.GetAllUsers().subscribe((data: any) => {
      this.pendingRegistrations.length = 0;
      this.activeUsers.length = 0;
      for(const d of (data as any)){
        if(!d.active){
          this.pendingRegistrations.push(d);
        }
        else{
          this.activeUsers.push(d);
        }
      }
    })
  }

  ActivateRegistration(user: User){
    this.userService.UpdateUser(user).subscribe((data: any) => {
      this.RefreshData();
    });
  }

  DeleteRegistration(user: number){
    this.userService.DeleteUser(user).subscribe((data: any) => {
      this.RefreshData();
    }); 
  }

  RefreshData(){
    this.GetUsers();
    this.adminProfile = this.authenticationService.currentUserValue;
  }

  updateProfile(){
    this.adminProfile = this.updatedProfile;
    this.userService.UpdateUser(this.updatedProfile).subscribe((data:any) => {
      //this.authenticationService.login(this.updatedProfile.eMail, this.updatedProfile.password);
      this.RefreshData();
    });
  }

}
