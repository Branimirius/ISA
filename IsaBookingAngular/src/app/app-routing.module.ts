import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegistrationComponent } from './registration/registration.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { InstructorProfileComponent } from './instructor-profile/instructor-profile.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { InstructorCalendarComponent }from './instructor-calendar/instructor-calendar.component';



const routes: Routes = [
  { path: 'registration', component: RegistrationComponent},
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'login', component: LoginComponent},
  { path: 'instructorProfile', component: InstructorProfileComponent},
  { path: 'instructorCalendar', component: InstructorCalendarComponent},
  { path: 'adminProfile', component: AdminProfileComponent},

  { path: '', redirectTo: 'landingPage', pathMatch: 'full' },
  { path: '**', redirectTo: 'landingPage', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
