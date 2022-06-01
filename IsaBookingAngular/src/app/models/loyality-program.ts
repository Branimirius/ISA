export class LoyalityProgram {
    id: number;
    clientPointStep: number;
    ownerPointStep: number;
    bronzeLine: number;
    silverLine: number;
    goldLine: number;

    constructor(){
        this.id = 0;
        this.clientPointStep = 0;
        this.ownerPointStep = 0;
        this.bronzeLine = 0;
        this.silverLine = 0;
        this.goldLine = 0;
        
    }
}