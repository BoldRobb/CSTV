import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { UsuarioModel } from '../models/usuario-model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(this.hasToken());
  private username = new BehaviorSubject<string | null>(this.getUsername());
  private userId = new BehaviorSubject<number | null>(this.getUserId());
  private userPais = new BehaviorSubject<string | null>(this.getUserPais());
  private hasToken(): boolean {
    return !!localStorage.getItem('user');
  }

  private getUsername(): string | null {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user).username : null;
  }
  private getUserId(): number | null {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user).id : null;
  }
  private getUserPais(): string | null {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user).pais : null;
  }
  login(user: any): void {
    localStorage.setItem('user', JSON.stringify(user));
    this.loggedIn.next(true);
    this.username.next(user.username);
    this.userId.next(user.id);
    this.userPais.next(user.pais);
  }

  logout(): void {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.username.next(null);
    this.userId.next(null);
    this.userPais.next(null);
  }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  getUsernameObservable(): Observable<string | null> {
    return this.username.asObservable();
  }
  getUserIdObservable(): Observable<number | null> {
    return this.userId.asObservable();
  }
  getUserPaisObservable(): Observable<string | null> {
    return this.userPais.asObservable();
  }
}