import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  pageTitle="Booking App";
  
  constructor(private router: Router, private authenticationService: AuthenticationService) {
    
  }
  ngOnInit(): void {
  }
  logOutClick(): void {
    this.authenticationService.logout();
  }
}
