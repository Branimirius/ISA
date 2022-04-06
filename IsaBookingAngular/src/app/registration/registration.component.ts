import { Component,Input, OnInit } from '@angular/core';
import { RegistrationService } from '../services/registration.service';
import { RegistrationDto } from './registration.dto';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  @Input() public newUser: RegistrationDto;
  public passwordConfirm : string;

  constructor(private rs : RegistrationService) {
    this.newUser = new RegistrationDto();
    this.passwordConfirm = "";
  }

  ngOnInit(): void {
  }

  registerHouseOwner(): void{
    if (this.validate() == true){
      console.log(this.newUser);
      this.sendRegistration("HOUSE_OWNER");
      alert("Uspesno ste se registrovali.");
    }
    else 
      alert("Niste uneli sve potrebne podatke !");
  }

  registerBoatOwner(): void{
    if (this.validate() == true){
      console.log(this.newUser);
      this.sendRegistration("BOAT_OWNER");
      alert("Uspesno ste se registrovali.");
    }
    else 
      alert("Niste ispravno uneli sve potrebne podatke !");
  }

  registerClient(): void{
    if (this.validate() == true){
      console.log(this.newUser);
      this.sendRegistration("CLIENT");
      alert("Uspesno ste se registrovali.");
    }
    else 
      alert("Niste ispravno uneli sve potrebne podatke !");
  }

  registerInstructor(): void{
    if (this.validate() == true){
      console.log(this.newUser);
      this.sendRegistration("INSTRUCTOR");
      alert("Uspesno ste se registrovali.");
    }
    else 
      alert("Niste ispravno uneli sve potrebne podatke !");
  }

  validate() : boolean{
    if (
      this.newUser.FirstName == "" || this.newUser.LastName == "" ||
      this.newUser.Email == "" || this.newUser.Password == "" || this.newUser.PhoneNumber == "" || this.newUser.Country == "" || this.newUser.City == "" ||
      this.newUser.Adress == "" || this.passwordConfirm != this.newUser.Password || this.passwordConfirm == ""
    )
      return false;
    else 
      return true;
  }

  public sendRegistration(regType: string): void{
    if(regType == "CLIENT"){
      this.rs.RegisterUser(this.newUser, regType, true).subscribe();
    }
    else{
      this.rs.RegisterUser(this.newUser, regType, false).subscribe();
    }
  }

}
