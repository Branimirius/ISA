import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RegistrationDto } from '../registration/registration.dto';
import { environment } from 'src/environments/environment';
import { Availability } from '../models/availability';
import { Grade } from '../models/grade';

@Injectable({
    providedIn: 'root'
  })
export class GradeService {  
    constructor (private http: HttpClient) {
      
    }

    public GetGrades(): Observable<Grade> {
      return this.http.get<any>("http://localhost:8081/api/grade/grades");
    }

    
  
}