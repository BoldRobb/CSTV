import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NoticiaModel } from './noticia-model';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService {

  private apiUrl = 'http://localhost:8080/api/noticias'; // URL de tu backend

  constructor(private http: HttpClient) { }

  getNoticias(id: number): Observable<NoticiaModel> {
    return this.http.get<NoticiaModel>(this.apiUrl+`/${id}`);
  }
}