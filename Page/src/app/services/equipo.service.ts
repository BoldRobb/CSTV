import { Injectable } from '@angular/core';
import { EquipoModel } from '../models/equipo-model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { JugadorModel } from '../models/jugador-model';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private apiUrl = "http://localhost:8080/api/equipos";
  private apiUrlJugadores = "http://localhost:8080/api/equipo-jugadores"
  constructor(private http: HttpClient) { }

  getEquipos(id: number): Observable<EquipoModel> {
    return this.http.get<EquipoModel>(this.apiUrl+"/"+id);
  }
  addEquipo(equipo: EquipoModel): Observable<EquipoModel> {
    return this.http.post<EquipoModel>(this.apiUrl, equipo);
  }
  getEquiposNombre(nombre: string): Observable<EquipoModel[]>{
    return this.http.get<EquipoModel[]>(this.apiUrl+"/nombre/"+nombre);
  }
  getJugadoresEquipo(id: number): Observable<JugadorModel[]>{
    return this.http.get<JugadorModel[]>(this.apiUrlJugadores+"/equipo/"+id);
  }
}
