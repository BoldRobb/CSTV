import { Component } from '@angular/core';
import { NoticiaContainerComponent } from '../noticia-container/noticia-container.component';
import { NoticiaMainComponent } from '../noticia-main/noticia-main.component';
import { OnInit } from '@angular/core';
import { NoticiaService } from '../../../services/noticia-service.service';
import { NoticiaModel } from '../../../models/noticia-model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-noticias-home',
  standalone: true,
  imports: [NoticiaContainerComponent, NoticiaMainComponent, CommonModule],
  templateUrl: './noticias-home.component.html',
  styleUrl: './noticias-home.component.css'
})
  export class NoticiasHomeComponent implements OnInit {
    noticiasHoy: NoticiaModel[] = [];
    noticiasAyer: NoticiaModel[] = [];
    noticiasRestantes: NoticiaModel[] = [];

    constructor(private noticiaService: NoticiaService) {}

    ngOnInit(): void {
      this.noticiaService.getNoticiasDesc().subscribe((noticias: NoticiaModel[]) => {
        const hoy = new Date();
        const ayer = new Date();
        ayer.setDate(hoy.getDate() - 1);

        noticias.forEach(noticia => {
          const noticiaFecha = new Date(noticia.fecha);
          if (this.isSameDay(noticiaFecha, hoy)) {
            this.noticiasHoy.push(noticia);
          } else if (this.isSameDay(noticiaFecha, ayer)) {
            this.noticiasAyer.push(noticia);
          } else {
            this.noticiasRestantes.push(noticia);
          }
        });
      });
    }

    private isSameDay(date1: Date, date2: Date): boolean {
      return date1.getFullYear() === date2.getFullYear() &&
             date1.getMonth() === date2.getMonth() &&
             date1.getDate() === date2.getDate();
    }
  }

