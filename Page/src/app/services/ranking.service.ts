import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RankingModel } from '../models/ranking-model';

@Injectable({
  providedIn: 'root'
})
export class RankingService {

  private apiUrl = 'http://localhost:8080/api/ranking'
  constructor(private http: HttpClient) { }

  getRankingToday(): Observable<RankingModel[]>{
    const hoy = new Date();
    return this.http.get<RankingModel[]>(this.apiUrl+'fecha/'+hoy);
  }
}
