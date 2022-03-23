export interface IProyecto {
    ID: number;
    nomProyecto: string;
    fechaInicio: string;
    destinatarioID: number;
    odsID: number;
}

export class Proyecto implements IProyecto {

    constructor(public ID: number, public nomProyecto: string, public fechaInicio: string, public destinatarioID: number, public odsID:number){
        
    }
}