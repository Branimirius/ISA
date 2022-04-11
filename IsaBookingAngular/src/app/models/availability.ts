export class Availability {
    id: number;
    instructor: number;
    from: Date;
    to: Date;
    

    constructor(){
        this.id = 0;
        this.instructor = 0;
        this.from = new Date();
        this.to = new Date();
        
    }
}