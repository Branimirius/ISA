import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Availability } from '../models/availability';
import { LoyalityProgram } from '../models/loyality-program';
import { Mail } from '../models/mail';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
  })
export class UserService {  
    constructor (private http: HttpClient) {
      
    }

    public GetAllUsers(): Observable<User> {
      return this.http.get<any>("http://localhost:8081/api/users");
    }

    public GetLoyalityProgram(): Observable<LoyalityProgram> {
      return this.http.get<any>("http://localhost:8081/api/loyality");
    }

    public UpdateUser(user: User){
        const body = {
            id: user.id,
            firstName : user.firstName,
            lastName: user.lastName,
            eMail : user.eMail,
            password: user.password,
            phoneNumber: user.phone,
            adress : user.adress,
            country : user.country,
            city : user.city,
            regType : user.regType,
            active: true,
            deleteRequested: user.deleteRequested
          };
          let headers = new HttpHeaders({
            'Content-Type': 'application/json' });
          let options = { headers: headers };
        return this.http.put<any>("http://localhost:8081/api/users", body, options);
    }

    public UpdateLoyality(loyality: LoyalityProgram){
      const body = {
        id: loyality.id,
        clientPointStep: loyality.clientPointStep,
        ownerPointStep: loyality.ownerPointStep,
        bronzeLine: loyality.bronzeLine,
        silverLine: loyality.silverLine,
        goldLine: loyality.goldLine
      };
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
    return this.http.put<any>("http://localhost:8081/api/loyality", body, options);
    }

    public DeleteUser(id: number){
      return this.http.delete<any>("http://localhost:8081/api/users/" + id)
    }
    
    public SendMail(){
      const body = {
        id: 1,
        destination: "branimirmaricic@gmail.com",
        object: "napravljen termin",
        message: "termin novi napravljen"
      };
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
      return this.http.post<any>("http://localhost:8081/api/mail", body, options);
    }

    public AddAvailability(avail: Availability){
      const body = {
        id: avail.id,
        start: avail.from,
        endTime: avail.to,
        userId: avail.instructor
      };
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
      return this.http.post<any>("http://localhost:8081/api/availabilities", body, options);
    }
    
}