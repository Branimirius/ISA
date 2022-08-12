export class House {
    id: number;
    name: string;
    address: string;
    description: string;
    numRooms: number;
    numBedsInRoom: number;
    rules: string;
    //dodati slike, slobodne termine za brzu rezervaciju, cenovnik sa info

    constructor(){
        this.id = 0;
        this.name = "";
        this.address = "";
        this.description = "";
        this.numRooms = 0;
        this.numBedsInRoom = 0;
        this.rules = "";
    }

}