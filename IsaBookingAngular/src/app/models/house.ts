export class House {
    id: number;
    userId: number;
    name: string;
    address: string;
    description: string;
    rules: string;
    //dodati slike, slobodne termine za brzu rezervaciju, cenovnik sa info

    constructor(){
        this.id = 0;
        this.userId = 0;
        this.name = "";
        this.address = "";
        this.description = "";
        this.rules = "";
    }

}