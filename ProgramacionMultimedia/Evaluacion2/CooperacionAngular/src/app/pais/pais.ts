export interface IPais {
    ID: number;
    nomPais: string;
    bandera: string;
}

export class Pais implements IPais {

    constructor(public ID: number, public nomPais: string, public bandera: string){
        
    }
}