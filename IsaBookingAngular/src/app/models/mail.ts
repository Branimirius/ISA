export class Mail{
    id: number;
    destination: string;
    object: string;
    message: string;

    constructor(){
        this.id = 0;
        this.destination = "";
        this.object = "";
        this.message = "";
    }

}