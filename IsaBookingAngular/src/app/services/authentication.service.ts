import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

import { User } from '../models/user';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser') || '{}'));
        //const userDummy: User = new User();
        //this.currentUserSubject = new BehaviorSubject<User>(userDummy);
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username:string, password:string) {
        const body = {
            eMail : username,
            pass: password            
          };
          let headers = new HttpHeaders({
            'Content-Type': 'application/json' });
          let options = { headers: headers };
        return this.http.post<any>("http://localhost:8081/api/login", body, options)
            .pipe(map(token => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                //localStorage.setItem('currentUser', JSON.stringify(user));
                localStorage.setItem('token', token.token);
               
                //console.log("Ulogovani posle logovanja:", localStorage.getItem('currentUser'));
               // return user;
               this.getCurrentUser().subscribe(data => {
                console.log(data)
                this.currentUserSubject.next(data);
                
                localStorage.setItem('currentUser', JSON.stringify(data));
               })
            
            }));
    }

    getCurrentUser() {
        
        let headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token') });
        let options = { headers: headers };
        return this.http.get<any>("http://localhost:8081/api/currentUser", options);
    }

    logout() {
        // remove user from local storage and set current user to null
        console.log("Ulogovani:", localStorage.getItem('currentUser'));

        localStorage.removeItem('currentUser');
        localStorage.removeItem('token');
        this.currentUserSubject.next(JSON.parse('{}'));
        this.router.navigate(['/login']);
        console.log("Ulogovani:", localStorage.getItem('currentUser'));
        
    }
}