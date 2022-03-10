export interface IClase {
    ID: number;
    nombre: string;
    seccion: string;
}

export class Clase implements IClase{

    constructor(public ID: number, public nombre: string, public seccion: string){
        
    }
}