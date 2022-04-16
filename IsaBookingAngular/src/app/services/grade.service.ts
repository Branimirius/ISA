import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Grade } from '../models/grade';

@Injectable({
    providedIn: 'root'
  })
export class GradeService {  
    constructor (private http: HttpClient) {
      
    }

    public GetGrade(id: number): Observable<Grade> {
      return this.http.get<any>("http://localhost:8081/api/grade/grades/" + id);
    }

    public GetGradesBySubject(id: number): Observable<Grade> {
      return this.http.get<any>("http://localhost:8081/api/grade/bySubject/" + id);
    }

    
  
}