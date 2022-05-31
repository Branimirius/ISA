import { Component, OnInit } from '@angular/core';
import { CalendarEvent, CalendarView } from 'angular-calendar';
import { startOfDay } from 'date-fns';
import { Fishing } from '../models/fishing';
import { FishingReservation } from '../models/fishing-reservation';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';
import { FishingService } from '../services/fishing.service';

@Component({
  selector: 'app-instructor-calendar',
  templateUrl: './instructor-calendar.component.html',
  styleUrls: ['./instructor-calendar.component.css']
})
export class InstructorCalendarComponent implements OnInit {

  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;
  fishingReservations: FishingReservation[];
  allFishingReservations: FishingReservation[];
  availableReservations: FishingReservation[];
  instructor: User;
  fishingProfile: Fishing;
  events: CalendarEvent[];

  constructor(private authenticationService: AuthenticationService,
              private fishingService: FishingService) {
    this.fishingReservations = [];
    this.availableReservations = [];
    this.allFishingReservations = [];
    this.fishingProfile = new Fishing();
    this.instructor = this.authenticationService.currentUserValue;
    this.events = [
      {
        start: startOfDay(new Date()),
        title: 'An event with no end date',
      }
    ]

    this.GetFishingProfileReservations();

   }

  ngOnInit(): void {
  }

  setView(view: CalendarView) {
    this.view = view;
  }
  // events: CalendarEvent[] = [
  //   {
  //     start: startOfDay(new Date()),
  //     title: 'An event with no end date',
  //   }
  // ]
  // let data=fromdb();
  // for(let x of data)
  // {
  // this.events = [
  //           ...this.events,
  //           {
  //   start:x["appointment_date"],
  //   title:x["patient_name"]+x["medical_problem"]
  //   }
  //   ]
  // }
  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    console.log(date);
    //this.openAppointmentList(date)
  }
  GetFishingProfileReservations(){
    this.fishingService.GetFishingReservations()
    .subscribe((data: any) => {
      this.fishingReservations.length = 0;
      this.availableReservations.length = 0;
      this.allFishingReservations.length = 0;
      for(const d of (data as any)){
        if(this.instructor.id == d.fishingClass.userId){
          this.allFishingReservations.push(d);
          
          this.events.push({start: startOfDay(new Date(d.start)), title: d.fishingClass.description})
          
          console.log(d.start);
        }
        if(this.fishingProfile.id == d.fishingClass.id){
          if(d.userId != 0){
            console.log(d)
            this.fishingReservations.push(d);
          }
          else{
            console.log(d)

            this.availableReservations.push(d);
          }
        }
      }
      console.log(this.events);
    })
  }
  
}
