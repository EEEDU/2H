import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'alumnoTitulo'
})
export class AlumnoTituloPipe implements PipeTransform {

  transform(value: string, sexo: string): string {
    if (sexo == 'Hombre'){
      return "Sr. " + value;
    } else if (sexo == 'Mujer'){
      return "Sra." + value;
    } else {
      return value;
    }
  }

}
