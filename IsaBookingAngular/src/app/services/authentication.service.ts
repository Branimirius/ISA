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
        return this.http.post<any>("http://localhost:8081/api/authenticate", body, options)
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                console.log("Ulogovani posle logovanja:", localStorage.getItem('currentUser'));
                return user;
            }));
    }

    logout() {
        // remove user from local storage and set current user to null
        console.log("Ulogovani:", localStorage.getItem('currentUser'));

        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(JSON.parse('{}'));
        this.router.navigate(['/login']);
        console.log("Ulogovani:", localStorage.getItem('currentUser'));
        
    }
}