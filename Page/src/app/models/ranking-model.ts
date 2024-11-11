import { EquipoModel } from "./equipo-model";

export class RankingModel {

    id: number;
    equipo: EquipoModel;
    ranking: number;
    fecha: Date;
    puntos: number;

    constructor(id: number, equipo: EquipoModel, ranking: number, fecha: Date, puntos: number){
        this.id=id;
        this.equipo=equipo;
        this.ranking=ranking;
        this.fecha=fecha;
        this.puntos=puntos;
    }

    getId(): number {
        return this.id;
      }
    
      setId(id: number): void {
        this.id = id;
      }
    
      getEquipo(): EquipoModel {
        return this.equipo;
      }
    
      setUsuario(equipo: EquipoModel): void {
        this.equipo = equipo;
      }
      getRanking(): number{
        return this.ranking;
      }
      setRanking( ranking: number){
        this.ranking = ranking;
      }

    getFecha(): Date{
        return this.fecha;
    }

    setFecha(fecha: Date){
        this.fecha = fecha;
    }

    getPuntos(): number{
        return this.puntos;
    }

    setPuntos(puntos: number){
        this.puntos = puntos;
    }
}
