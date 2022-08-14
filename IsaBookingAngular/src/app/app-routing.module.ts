import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegistrationComponent } from './registration/registration.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { InstructorProfileComponent } from './instructor-profile/instructor-profile.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { InstructorCalendarComponent }from './instructor-calendar/instructor-calendar.component';
import { HouseOwnerProfileComponent } from './house-owner-profile/house-owner-profile.component';
import { HousesComponent } from './houses/houses.component';
import { BoatOwnerProfileComponent } from './boat-owner-profile/boat-owner-profile.component';
import { BoatsComponent } from './boats/boats.component';


const routes: Routes = [
  { path: 'registration', component: RegistrationComponent},
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'login', component: LoginComponent},
  { path: 'instructorProfile', component: InstructorProfileComponent},
  { path: 'instructorCalendar', component: InstructorCalendarComponent},
  { path: 'adminProfile', component: AdminProfileComponent},
  { path: 'houseOwnerProfile', component: HouseOwnerProfileComponent},
  { path: 'houses', component: HousesComponent },
  { path: 'boatOwnerProfile', component: BoatOwnerProfileComponent},
  { path: 'boats', component: BoatsComponent },

  { path: '', redirectTo: 'landingPage', pathMatch: 'full' },
  { path: '**', redirectTo: 'landingPage', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
