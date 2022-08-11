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

  public loggedUser : any;
  constructor(private router: Router, private authenticationService: AuthenticationService) { 
    
  }

  ngOnInit(): void {
    
  }

  getUser() : any {
    let userString = localStorage.getItem('currentUser');
    
    if(userString)
    {
      return JSON.parse(userString);
    }

    return null;
  }

}
