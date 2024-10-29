import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TopicoModel } from '../models/topico-model';


@Injectable({
  providedIn: 'root'
})
export class ForoServiceService {

  private apiUrl = 'http://localhost:8080/api/topicos';

  constructor(private http: HttpClient) { }

  getTopicos(): Observable<TopicoModel[]> {
    return this.http.get<TopicoModel[]>(this.apiUrl);
  }
}