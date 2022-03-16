import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RegistrationDto } from '../registration/registration.dto';
import { environment } from 'src/environments/environment';
import { FishingDto } from '../dto/fishingDto';
import { Fishing } from '../models/fishing';
import { FishingImage } from '../models/fishing-image';

@Injectable({
    providedIn: 'root'
  })
export class FishingService {  
    constructor (private http: HttpClient) {
      
    }

    public GetFishingProfiles(): Observable<Fishing> {
      return this.http.get<any>("http://localhost:8081/api/fishing/classes");
    }

    public GetFishingImages(): Observable<FishingImage> {
      return this.http.get<any>("http://localhost:8081/api/fishingImages/fishingClassImages");
    }
    
  
}