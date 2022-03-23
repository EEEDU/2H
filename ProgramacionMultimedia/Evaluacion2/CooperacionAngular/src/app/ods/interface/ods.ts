export interface IOds {
    ID: number;
    nomODS: string;
    foto: string;
}

export class Ods implements IOds {

    constructor(public ID: number, public nomODS: string, public foto: string){
        
    }
}