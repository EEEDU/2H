export interface IAlumno {
    nombre: string;
    apellidos: string;
    direccion: string;
    fnac: string;
    sexo: string;
}

export class Alumno implements IAlumno{

    constructor(public nombre: string, public apellidos: string, public direccion: string, public fnac: string, public sexo: string){
        
    }
}