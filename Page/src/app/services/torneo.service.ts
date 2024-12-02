import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TorneoModel } from '../models/torneo-model';
import { Observable, switchMap } from 'rxjs';
import { TorneomainModel } from '../models/torneomain-model';
import { TorneoEquiposModel } from '../models/torneo-equipos-model';

@Injectable({
  providedIn: 'root'
})
export class TorneoService {

  private apiUrl = 'http://localhost:8080/api/torneos'
  private apiUrlMain = 'http://localhost:8080/api/torneoMain'
  private apiUrlEquipos = 'http://localhost:8080/api/torneo-equipos'
  constructor(private http: HttpClient) { }
  
  addTorneo(torneo: TorneoModel): Observable<TorneoModel> {
    return this.http.post<TorneoModel>(this.apiUrl, torneo);
  }
  getTorneos(): Observable<TorneoModel[]>{
    return this.http.get<TorneoModel[]>(this.apiUrl);
  }

  getTorneoMain(): Observable<TorneoModel>{
    return this.http.get<TorneomainModel>(this.apiUrlMain).pipe(
      switchMap((torneoMain: TorneomainModel) => {
        return this.http.get<TorneoModel>(`${this.apiUrl}/${torneoMain.id}`);
      })
    );
  }

  getTorneo(id: number): Observable<TorneoModel>{
    return this.http.get<TorneoModel>(`${this.apiUrl}/${id}`);
  }
  getEquiposTorneo(id: number): Observable<TorneoEquiposModel[]>{
    return this.http.get<TorneoEquiposModel[]>(`${this.apiUrlEquipos}/${id}`);
  }
  getTorneosByNombre(nombre: string): Observable<TorneoModel[]>{
    return this.http.get<TorneoModel[]>(`${this.apiUrl}/nombre/${nombre}`);
  }
  
}
