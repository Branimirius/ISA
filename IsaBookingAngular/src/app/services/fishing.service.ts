import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RegistrationDto } from '../registration/registration.dto';
import { environment } from 'src/environments/environment';
import { Fishing } from '../models/fishing';
import { FishingImage } from '../models/fishing-image';
import { FishingReservation } from '../models/fishing-reservation';
import { FishingReview } from '../models/fishing-review';
import { Availability } from '../models/availability';

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

    public GetFishingReservations(): Observable<FishingReservation> {
      return this.http.get<any>("http://localhost:8081/api/fishingReservations/fishingClassReservations");
    }

    public uploadImage(image: File): Observable<Object> {
      const formData = new FormData();
  
      formData.append('image', image);
  
      return this.http.post('/api/v1/image-upload', formData);
    }
    
    public AddReservation(res: FishingReservation){
      const body = {
        id: res.id,
        userId : res.userId,
        start : res.start,
        end: res.end,
        duration : res.duration,
        location: res.location,
        extraOffers: res.extraOffers,
        maxCap : res.maxCap,
        price : res.price,
        fishingClass : res.fishingClass
      };
      console.log(body);
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
      return this.http.post<any>("http://localhost:8081/api/fishingReservations/fishingClassReservations", body, options);
    }

    public AddNewFishing(fishing: Fishing){
      const body = {
        id: fishing.id,
        userId : fishing.userId,
        adress : fishing.adress,
        cancelConditions: fishing.cancelConditions,
        description : fishing.description,
        equipment: fishing.equipment,
        maxCap : fishing.maxCap,
        instructorBio : fishing.instructorBio,
        menu : fishing.menu,
        rules : fishing.rules
      };
      console.log(body);
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
      return this.http.post<any>("http://localhost:8081/api/fishing/classes", body, options);
    }

    public DeleteFishing(id: number){
      return this.http.delete<any>("http://localhost:8081/api/fishing/classes/" + id);
    }

    public AddFishingReview(review: FishingReview){
      const body = {
        id: review.id,
        client: review.client,
        instructor: review.instructor,
        comment: review.comment,
        report: review.report,
        showUp: review.showUp
      };
      console.log(body);
      let headers = new HttpHeaders({
        'Content-Type': 'application/json' });
      let options = { headers: headers };
      return this.http.post<any>("http://localhost:8081/api/fishingReservations/fishingClassReviews", body, options);
    }

    
  
}