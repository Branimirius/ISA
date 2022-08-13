import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { House } from '../models/house';

@Injectable({
    providedIn:'root'
  })
export class HouseService {
    constructor(private http: HttpClient){}

    public getAllHouses(): Observable<any> {
        return this.http.get<any>("http://localhost:8081/api/houses");
    }

    public removeHouse(houseId: any): Observable<any>{
        return this.http.delete("http://localhost:8081/api/houses"+"/"+houseId);
    }
}