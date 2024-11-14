import { EquipoModel } from "./equipo-model";


export class JugadorModel{
id!: number;
 nombreReal: string;
 mote: string;
 estatus: string;
foto: string;
 equipoActual: EquipoModel;

    constructor(nombreReal: string, mote: string, estatus: string, foto: string, equipoActual: EquipoModel){
        this.nombreReal = nombreReal;
        this.mote = mote;
        this.estatus = estatus;
        this.foto = foto;
        this.equipoActual = equipoActual;

    }
    setId(id: number): void{
        this.id=id;
    }
    getId(): number{
        return this.id;
    }
    setNombreReal(nombre: string): void{
        this.nombreReal = nombre;
    }
    getNombreReal(): string{
        return this.nombreReal;
    }
    setMote(nombre: string): void{
        this.mote = nombre;
    }
    getMote(): string{
        return this.mote;
    }



}