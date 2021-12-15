import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationOwnerComponent } from './registration-owner/registration-owner.component';
import { RegistrationClientComponent } from './registration-client/registration-client.component';
import { NavigationComponent } from './navigation/navigation.component';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatBadgeModule } from '@angular/material/badge';
import { ToastrModule } from 'ngx-toastr';
import { timeout } from 'rxjs/operators';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationOwnerComponent,
    RegistrationClientComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatBadgeModule,
    ToastrModule.forRoot({
      preventDuplicates: false,
      timeOut: 4000,
      positionClass: 'toast-top-right',
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
