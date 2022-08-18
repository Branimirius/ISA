import { AdditionalService } from "./additionalService";

export class House {
    id: number;
    userId: number;
    name: string;
    address: string;
    description: string;
    room: string;
    beds: number;
    rules: string;
    additionalService: AdditionalService;
    //dodati slike, slobodne termine za brzu rezervaciju


    constructor(){
        this.id = 0;
        this.userId = 0;
        this.name = "";
        this.address = "";
        this.description = "";
        this.room = "";
        this.beds = 0;
        this.rules = "";
        this.additionalService = new AdditionalService();
    }

}