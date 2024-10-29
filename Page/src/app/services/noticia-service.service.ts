import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, switchMap } from 'rxjs';
import { NoticiaModel } from '../models/noticia-model';
import { NoticiaMainModel } from '../models/noticia-main-model';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService {

  private apiUrl = 'http://localhost:8080/api/noticias'; // URL de tu backend
  private apiUrlMain = 'http://localhost:8080/api/noticiaMain'; // URL de tu backend
  constructor(private http: HttpClient) { }

  getNoticias(id: number): Observable<NoticiaModel> {
    return this.http.get<NoticiaModel>(this.apiUrl+`/${id}`);
  }

  getNoticiaMain(): Observable<NoticiaModel> {
    return this.http.get<NoticiaMainModel>(this.apiUrlMain).pipe(
      switchMap((noticiaMain: NoticiaMainModel) => {
        console.log("noticiaMain: ", noticiaMain);
        return this.http.get<NoticiaModel>(`${this.apiUrl}/${noticiaMain.idNoticia}`);
      })
    );
  }
  getNoticiasDesc(): Observable<NoticiaModel[]> {
    return this.http.get<NoticiaModel[]>(this.apiUrl+'/date');
  }
}