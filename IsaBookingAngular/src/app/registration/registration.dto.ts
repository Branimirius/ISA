export class RegistrationDto{
    FirstName: string;
    LastName: string;
    Email: string;
    Password: string;
    PhoneNumber: string;
    Adress: string;
    Country: string;
    City: string;
    RegType: string;

    constructor(){
        this.FirstName = '';
        this.LastName = '';
        this.Email = '';
        this.Password = '';
        this.PhoneNumber = '';
        this.Adress = '';
        this.Country = '';
        this.City = '';
        this.RegType = '';
    }
}

