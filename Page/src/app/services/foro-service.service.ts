import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TopicoModel } from '../models/topico-model';
import { ForoModel } from '../models/foro-model';


@Injectable({
  providedIn: 'root'
})
export class ForoServiceService {

  private apiUrl = 'http://localhost:8080/api/topicos';
  private apiUrlForums = 'http://localhost:8080/api/foros'

  constructor(private http: HttpClient) { }

  getTopicosDesc(): Observable<TopicoModel[]>{
    return this.http.get<TopicoModel[]>(this.apiUrl+'/date');
  }
  getTopicosLatest(): Observable<TopicoModel[]>{
    return this.http.get<TopicoModel[]>(this.apiUrl+'/latest');
  }
  getTopicos(): Observable<TopicoModel[]> {
    return this.http.get<TopicoModel[]>(this.apiUrl);
  }

  getTopico(id: number): Observable<TopicoModel> {
    return this.http.get<TopicoModel>(this.apiUrl + '/' + id);
  }

  getForos(): Observable<ForoModel[]>{
    return this.http.get<ForoModel[]>(this.apiUrlForums);
  }

}