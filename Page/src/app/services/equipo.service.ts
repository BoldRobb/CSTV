import { Injectable } from '@angular/core';
import { EquipoModel } from '../models/equipo-model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private apiUrl = "http://localhost:8080/api/equipos";
  constructor(private http: HttpClient) { }

  getEquipos(id: number): Observable<EquipoModel> {
    return this.http.get<EquipoModel>(this.apiUrl+"/"+id);
  }
  addEquipo(equipo: EquipoModel): Observable<EquipoModel> {
    return this.http.post<EquipoModel>(this.apiUrl, equipo);
  }
}
