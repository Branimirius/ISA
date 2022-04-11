import { User } from "./user";

export class FishingReview {
    id: number;
    instructor: User;
    client: User;
    comment: string;
    report: boolean;
    showUp: boolean;
    

    constructor(){
        this.id = 0;
        this.instructor = new User();
        this.client = new User();
        this.comment = "";
        this.report = false;
        this.showUp = false;
        
    }
}