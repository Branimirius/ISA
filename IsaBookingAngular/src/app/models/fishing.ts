export class Fishing {
    id: number;
    userId: number;
    adress: string;
    description: string;
    instructorBio: string;
    maxCap: number;
    rules: string;
    equipment: string;
    menu: string; 
    cancelConditions: string;

    constructor(){
        this.id = 0;
        this.userId = 0;
        this.adress = "";
        this.description = "";
        this.instructorBio = "";
        this.maxCap = 5;
        this.rules = "";
        this.equipment = "";
        this.menu = "";
        this.cancelConditions = "";
        
    }
}