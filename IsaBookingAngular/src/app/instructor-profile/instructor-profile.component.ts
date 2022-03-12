import { Component, OnInit } from '@angular/core';
import { Fishing } from '../models/fishing';
import { FishingService } from '../services/fishing.service'
import { AuthenticationService } from '../services/authentication.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-instructor-profile',
  templateUrl: './instructor-profile.component.html',
  styleUrls: ['./instructor-profile.component.css']
})
export class InstructorProfileComponent implements OnInit {
  fishingProfile: Fishing

  constructor(private fishingService: FishingService,
              private authenticationService: AuthenticationService) {
    this.fishingProfile = new Fishing;
    this.GetFishingProfile();
   }

  ngOnInit(): void {
    this.GetFishingProfile();
    console.log("ODRADIO", this.fishingProfile.adress)
  }

  GetFishingProfile(){
    this.fishingService.GetFishingProfiles()
      .subscribe((data: any) => {
        for(const d of (data as any)){
          if(this.authenticationService.currentUserValue.id == d.userId){
            this.fishingProfile = d;
          }
      }
    })
  }
}
