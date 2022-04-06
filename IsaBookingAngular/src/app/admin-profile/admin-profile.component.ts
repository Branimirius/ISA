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
  pendingRegistrations: User[];

  constructor(private authenticationService: AuthenticationService,
              private userService: UserService) { 
    this.adminProfile = authenticationService.currentUserValue;
    this.pendingRegistrations = [];
    this.GetPendingRegistrations();
  }

  ngOnInit(): void {
    this.GetPendingRegistrations();
  }

  GetPendingRegistrations(){
    this.userService.GetAllUsers().subscribe((data: any) => {
      this.pendingRegistrations.length = 0;
      for(const d of (data as any)){
        if(!d.active){
          this.pendingRegistrations.push(d);
        }
      }
      console.log("Pending: ", this.pendingRegistrations);
    })
  }

  ActivateRegistration(user: User){
    this.userService.UpdateUser(user).subscribe();
  }

}
