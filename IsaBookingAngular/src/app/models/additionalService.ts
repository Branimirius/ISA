import { House } from "./house";
import { Pricelist } from "./pricelist";

export class AdditionalService {

    id: number;
    name: string;
    house: House[];
    pricelist: Pricelist;
    constructor(){
        this.id = 0;
        this.name = "";
        this.house = [];
        this.pricelist = new Pricelist();
    }
}