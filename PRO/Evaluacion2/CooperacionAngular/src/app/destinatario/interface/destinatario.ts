export interface IDestinatario {
    ID: number;
    nomDestinatario: string;
    direccion: string;
    paisID: number;
}

export class Destinatario implements IDestinatario {

    constructor(public ID: number, public nomDestinatario: string, public direccion: string, public paisID: number){
        
    }
}