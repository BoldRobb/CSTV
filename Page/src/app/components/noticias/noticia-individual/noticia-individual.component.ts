import { Component, Input } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { NavbarComponent } from '../../navbar/navbar.component';
import { NoticiaService } from '../../../services/noticia-service.service';
import { NoticiaModel } from '../../../models/noticia-model';
import { CommonModule } from '@angular/common';
import { UsuarioModel } from '../../../models/usuario-model';
import { UsuarioService } from '../../../services/usuario-service.service';

@Component({
  selector: 'app-noticia-individual',
  standalone: true,
  imports: [NavbarComponent, CommonModule, RouterModule],
  templateUrl: './noticia-individual.component.html',
  styleUrl: './noticia-individual.component.css'
})
export class NoticiaIndividualComponent {
  id?: number;
  noticia?: NoticiaModel;
  isloading = true;
  usuario?: UsuarioModel;
  fechapublicacion?: string;
  constructor(private route: ActivatedRoute, private noticiaService: NoticiaService, private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.getNoticia();
  }
  getNoticia(): void {
    if (this.id !== undefined) {
      this.noticiaService.getNoticias(this.id).subscribe(
        data => {
          this.noticia = data;
          console.log(this.noticia);
            this.isloading = false;
            const fecha = new Date(this.noticia.fecha);
            const dia = fecha.getDate().toString().padStart(2, '0');
            const mes = (fecha.getMonth() + 1).toString().padStart(2, '0');
            const anio = fecha.getFullYear();
            this.fechapublicacion = `${dia}-${mes}-${anio}`;
          
        },
        error =>{console.error(error);
          this.isloading = false;
        } ,
      );
    } else {
      console.error('ID is undefined');
    }
  }
  getUsuario(): void {
    if (this.noticia !== undefined) {
      this.usuarioService.getUsuario(this.noticia.usuario.id).subscribe(
        data => {
          this.usuario = data;
          console.log(this.usuario);
          this.isloading = false;
        },
        error =>{console.error(error);
          this.isloading = false;
        } ,
      );
    } else {
      console.error('ID is undefined');
    }
  }
}
