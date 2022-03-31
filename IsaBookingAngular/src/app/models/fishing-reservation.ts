import { Timestamp } from "rxjs-compat";
import { Fishing } from "./fishing";

export class FishingReservation {
    id: number;
    userId: number;
    start: Date;
    end: Date;
    duration: number;
    location: string;
    maxCap: number;
    extraOffers: string;
    price: number;
    fishingClass: Fishing;

    constructor(){
        this.id = 0
        this.userId = 0
        this.start = new Date()
        this.end = new Date()
        this.duration = 0
        this.location = ""
        this.maxCap = 0
        this.extraOffers = ""
        this.price = 0
        this.fishingClass = new Fishing()
        
    }
}