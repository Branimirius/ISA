import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../models/boat';

@Injectable({
    providedIn:'root'
  })
export class BoatService {
    constructor(private http: HttpClient){ }

    public getAllBoats(): Observable<any>{
        return this.http.get<any>("http://localhost:8081/api/boats");
    }

    public removeBoat(boatId: any): Observable<any>{
        return this.http.delete("http://localhost:8081/api/boats"+"/"+boatId);
    }

    public addNewBoat(boat: Boat): Observable<any>{
        return this.http.post<any>("http://localhost:8081/api/boats", boat);
    }

    public updateBoat(boat: Boat): Observable<any>{
        return this.http.put("http://localhost:8081/api/boats", boat);
    }
}