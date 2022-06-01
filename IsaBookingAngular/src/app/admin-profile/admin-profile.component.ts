import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { RegistrationDto } from '../registration/registration.dto';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import { RegistrationService} from '../services/registration.service'
import { NumberValueAccessor } from '@angular/forms';
import { LoyalityProgram } from '../models/loyality-program';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  adminProfile: User;
  updatedProfile: User;
  newProfile: RegistrationDto;
  pendingRegistrations: User[];
  pendingDeletions: User[];
  activeUsers: User[];
  passwordChange: string;
  passwordConfirm : string;
  loyalityProgram: LoyalityProgram;

  constructor(private authenticationService: AuthenticationService,
              private userService: UserService,
              private registrationService: RegistrationService) { 
    this.adminProfile = authenticationService.currentUserValue;
    this.updatedProfile = authenticationService.currentUserValue;
    this.newProfile = new RegistrationDto();
    this.pendingRegistrations = [];
    this.activeUsers = [];
    this.pendingDeletions = [];
    this.passwordConfirm = "";
    this.passwordChange = "";
    this.loyalityProgram = new LoyalityProgram();
    this.GetUsers();
    this.GetLoyalityProgram();
  }

  ngOnInit(): void {
    this.GetUsers();
  }

  GetUsers(){
    this.userService.GetAllUsers().subscribe((data: any) => {
      this.pendingRegistrations.length = 0;
      this.activeUsers.length = 0;
      this.pendingDeletions.length = 0;
      for(const d of (data as any)){
        if(!d.active && d.regType !== "ADMIN"){
          this.pendingRegistrations.push(d);
        }
        else if(d.deleteRequested){
          this.pendingDeletions.push(d);
        }
        else{
          this.activeUsers.push(d);
        }
      }
    })
  }
  GetLoyalityProgram(){
    this.userService.GetLoyalityProgram().subscribe((data: any) => {
      this.loyalityProgram = data as LoyalityProgram;
    })
  }

  ActivateRegistration(user: User){
    this.userService.UpdateUser(user).subscribe((data: any) => {
      this.RefreshData();
    });
  }

  CancelDeleteRequest(user: User){
    user.deleteRequested = false;
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
    this.newProfile = new RegistrationDto();
  }

  updateProfile(){
    this.adminProfile = this.updatedProfile;
    this.userService.UpdateUser(this.updatedProfile).subscribe((data:any) => {
      this.RefreshData();
    });
  }

  registerAdmin(){
    this.registrationService.RegisterUser(this.newProfile, "ADMIN", false).subscribe((data:any) => {
      this.RefreshData();
    });
  }

  changePassword(){
    if(this.passwordChange === this.passwordConfirm){
      this.updatedProfile.password = this.passwordChange;
      this.adminProfile.password = this.passwordChange;
      this.adminProfile.active = true;
      this.userService.UpdateUser(this.updatedProfile).subscribe((data:any) => {
        this.RefreshData();
      });
    }
    else{
      alert("Passwords didn't match. Try again.");
      this.passwordConfirm = "";
    }
  }

  updateLoyality(){
    this.userService.UpdateLoyality(this.loyalityProgram).subscribe((data: any) => {
      this.GetLoyalityProgram();
    });
  }

}
