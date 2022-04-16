import { Component, OnInit } from '@angular/core';
import { CalendarEvent, CalendarView } from 'angular-calendar';
import { startOfDay } from 'date-fns';

@Component({
  selector: 'app-instructor-calendar',
  templateUrl: './instructor-calendar.component.html',
  styleUrls: ['./instructor-calendar.component.css']
})
export class InstructorCalendarComponent implements OnInit {

  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;
  constructor() { }

  ngOnInit(): void {
  }

  setView(view: CalendarView) {
    this.view = view;
  }
  events: CalendarEvent[] = [
    {
      start: startOfDay(new Date()),
      title: 'An event with no end date',
    }
  ]
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
}
