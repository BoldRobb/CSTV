import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MapaDTO } from '../models/DTO/mapaDTO';
import { MapaModel } from '../models/mapa-model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MapasService {
  private apiUrl = 'http://localhost:8080/api/mapas'; // URL de tu backend
  constructor(private http: HttpClient) { }

  getAllMapas(): Observable<MapaModel[]> {
    return this.http.get<MapaModel[]>(this.apiUrl);
  }

  getMapaById(id: number): Observable<MapaModel> {
    return this.http.get<MapaModel>(`${this.apiUrl}/${id}`);
  }

  createMapa(mapaDTO: MapaDTO): Observable<MapaModel> {
    return this.http.post<MapaModel>(this.apiUrl, mapaDTO);
  }

  updateMapa(id: number, mapaDTO: MapaDTO): Observable<MapaModel> {
    return this.http.put<MapaModel>(`${this.apiUrl}/${id}`, mapaDTO);
  }

  deleteMapa(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getMapasByPartidoId(idPartido: number): Observable<MapaModel[]> {
    return this.http.get<MapaModel[]>(`${this.apiUrl}/partido/${idPartido}`);
  }

  createListMapas(mapasDTO: MapaDTO[]): Observable<MapaModel[]> {
    return this.http.post<MapaModel[]>(`${this.apiUrl}/list`, mapasDTO);
  }
}
