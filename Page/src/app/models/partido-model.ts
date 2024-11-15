import { EquipoModel } from "./equipo-model";
import { TorneoModel } from "./torneo-model";

export class PartidoModel{

    id!: number;
    equipo1: EquipoModel;
    equipo2: EquipoModel;
    idTorneo: TorneoModel;
    idGanador: EquipoModel;
    formato: string;
    marcador:string;
    constructor(
        id: number,
        equipo1: EquipoModel,
        equipo2: EquipoModel,
        idTorneo: TorneoModel,
        idGanador: EquipoModel,
        formato: string,
        marcador: string
    ) {
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.idTorneo = idTorneo;
        this.idGanador = idGanador;
        this.formato = formato;
        this.marcador = marcador;
    }


}