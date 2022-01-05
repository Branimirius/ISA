import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RegistrationDto } from '../registration/registration.dto';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })
export class RegistrationService {  
    constructor (private http: HttpClient) {
      
    }

    public RegisterUser(user: RegistrationDto, regType: string){
        const body = {
            firstName : user.FirstName,
            lastName: user.LastName,
            eMail : user.Email,
            password: user.Password,
            phoneNumber: user.PhoneNumber,
            adress : user.Adress,
            country : user.Country,
            city : user.City,
            regType : regType
          };
          let headers = new HttpHeaders({
            'Content-Type': 'application/json' });
          let options = { headers: headers };
        return this.http.post<any>("http://localhost:8081/api/users", body, options);
    }
}