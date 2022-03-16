import { Fishing } from "./fishing";

export class FishingImage {
    id: number;
    image: Uint8Array;
    fishingClass: Fishing;

    constructor(){
        this.id = 0;
        this.image = new Uint8Array(1024*1024*8);
        this.fishingClass = new Fishing()
        
    }
}