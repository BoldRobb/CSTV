export class TorneoModel {

    id: number;
    nombre: string;
    fechaFinal: Date;
    fechaInicial: Date;
    logo: string;
    tipo_bracket: string;

    constructor(id: number, nombre: string, fechaFinal: Date, fechaInicial: Date, logo: string, tipo_bracket: string){
        this.id=id;
        this.nombre=nombre;
        this.fechaFinal=fechaFinal;
        this.fechaInicial=fechaInicial;
        this.logo=logo;
        this.tipo_bracket=tipo_bracket;
    }

}
