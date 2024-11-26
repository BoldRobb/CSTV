import { Component, OnInit } from '@angular/core';
import { AlertComponent } from '../../global/alert/alert.component';
import { CommonModule } from '@angular/common';
import { TopicoModel } from '../../../models/topico-model';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ForoServiceService } from '../../../services/foro-service.service';
import { RespuestaServiceService } from '../../../services/respuesta-service.service';
import { RespuestasModel } from '../../../models/respuestas-model';

@Component({
  selector: 'app-topico-individual',
  standalone: true,
  imports: [AlertComponent, CommonModule, RouterModule ],
  templateUrl: './topico-individual.component.html',
  styleUrl: './topico-individual.component.css'
})
export class TopicoIndividualComponent implements OnInit {
  alertMessage!: string;
  alertType!: 'success' | 'error';
  isLoading= true;
  pageNotFound = false;
  topico?: TopicoModel;
  respuestas: RespuestasModel[] = [];
  respuestasDeRespuestas: { [key: number]: RespuestasModel[] } = {};
  constructor(
    private route: ActivatedRoute,
    private foroService: ForoServiceService,
    private respuestaService: RespuestaServiceService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const idTopico = +params['idTopic'];
      if (isNaN(idTopico)) {
        this.pageNotFound = true;
        this.isLoading = false;
      } else {
        this.loadTopico(idTopico);
        this.loadRespuestas(idTopico);
      }
    });
  }

  loadTopico(idTopico: number): void {
    this.foroService.getTopico(idTopico).subscribe(
      topico => {
        this.topico = topico;
        this.isLoading = false;
      },
      error => {
        console.error('Topico not found', error);
        this.pageNotFound = true;
        this.isLoading = false;
      }
    );
  }

  loadRespuestas(idTopico: number): void {
    this.respuestaService.getRespuestasByTopico(idTopico).subscribe(
      (respuestas: RespuestasModel[]) => {
        this.respuestas = respuestas;
        this.respuestas.forEach(respuesta => {
          this.loadRespuestasDeRespuestas(respuesta.id);
        });
      },
      error => {
        console.error('Error loading respuestas', error);
      }
    );
  }

  loadRespuestasDeRespuestas(idRespuesta: number): void {
    this.respuestaService.getRespuestasByPadre(idRespuesta).subscribe(
      (respuestas: RespuestasModel[]) => {
        this.respuestasDeRespuestas[idRespuesta] = respuestas;
      },
      error => {
        console.error('Error loading respuestas de respuestas', error);
      }
    );
  }
  normalizeDate(date: Date | undefined): string {        
    if(!date) return '';  
    const fecha = new Date(date);
    const dia = fecha.getDate().toString().padStart(2, '0');
    const mes = (fecha.getMonth() + 1).toString().padStart(2, '0');
    const anio = fecha.getFullYear();
    return `${dia}-${mes}-${anio}`;
  }
  responderTopico(){
    
  }
}

