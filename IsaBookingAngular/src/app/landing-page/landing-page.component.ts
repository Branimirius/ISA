import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  public loggedUser : User;
  constructor(private router: Router, private authenticationService: AuthenticationService) { 
    this.loggedUser = authenticationService.currentUserValue;
  }

  ngOnInit(): void {
  }

}
