export class User {
    id: number;
    firstName: string;
    lastName: string;
    eMail: string;
    password: string;
    phone: string;
    adress: string;
    country: string;
    city: string;
    regType: string; 
    token: string;

    constructor(){
        this.id = 0;
        this.eMail = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.token = "";
        this.phone = "";
        this.adress = "";
        this.country = "";
        this.city = "";
        this.regType = ""; 
    }
}