import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioModel } from '../models/usuario-model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8080/api/usuarios'; // URL de tu backend
  constructor(private http: HttpClient) { }
  getUsuarios(): Observable<UsuarioModel[]> {
    return this.http.get<UsuarioModel[]>(this.apiUrl);
  }
  getUsuario(id: number): Observable<UsuarioModel> {
    return this.http.get<UsuarioModel>(this.apiUrl+`/${id}`);
  }
  createUsuario(usuario: UsuarioModel): Observable<UsuarioModel> {
    return this.http.post<UsuarioModel>(this.apiUrl, usuario);
  }
  updateUsuario(usuario: UsuarioModel): Observable<UsuarioModel> {
    return this.http.put<UsuarioModel>(this.apiUrl+`/${usuario.id}`, usuario);
  }
  deleteUsuario(id: number): Observable<UsuarioModel> {
    return this.http.delete<UsuarioModel>(this.apiUrl+`/${id}`);
  }
  getUsuarioByNombre(nombre: string): Observable<UsuarioModel[]> {
    return this.http.get<UsuarioModel[]>(this.apiUrl+`/nombre/${nombre}`);
  }

}
