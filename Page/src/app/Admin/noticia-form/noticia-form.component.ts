import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NoticiaModel } from '../../models/noticia-model';
import { UsuarioModel } from '../../models/usuario-model';
import { NoticiaService } from '../../services/noticia-service.service';
import { CommonModule } from '@angular/common';
import { AlertComponent } from "../../components/global/alert/alert.component";
import { UsuarioService } from '../../services/usuario-service.service';
import { NoticiaDTO } from '../../models/DTO/noticiaDTO';

@Component({
  selector: 'app-noticia-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, AlertComponent],
  templateUrl: './noticia-form.component.html',
  styleUrl: './noticia-form.component.css'
})
export class NoticiaFormComponent implements OnInit{
  noticiaForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  htmlContent: string = '';
  usuariosFiltrados: UsuarioModel[] = [];


  constructor(private fb: FormBuilder, private noticiaService: NoticiaService, private usuariosService: UsuarioService) {
    this.noticiaForm = this.fb.group({
      usuario: ['', Validators.required],
      imagen: ['', Validators.required],
      titulo: ['', Validators.required],
      fecha: ['', Validators.required],
      html: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onFileChange(event: any): void {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.htmlContent = e.target.result;
        this.noticiaForm.patchValue({ html: this.htmlContent });
      };
      reader.readAsText(file);
    }
  }

  onUsuarioInput(): void {
    const usuarioInput = this.noticiaForm.get('usuario')?.value;
    if (usuarioInput) {
      this.usuariosService.getUsuarioByNombre(usuarioInput).subscribe(
        (usuarios: UsuarioModel[]) => {
          this.usuariosFiltrados = usuarios;
        },
        error => {
          console.error('Error al buscar usuarios', error);
        }
      );
    } else {
      this.usuariosFiltrados = [];
    }
  }

  onSubmit(): void {
    if (this.noticiaForm.valid) {
      const formValue = this.noticiaForm.value;
      const usuario = this.usuariosFiltrados.find(u => u.username === formValue.usuario);
      if (!usuario) {
        this.showAlert('Usuario no encontrado', 'error');
        return;
      }
      const nuevaNoticia = new NoticiaDTO(
        usuario.id,
        formValue.imagen,
        this.htmlContent,
        new Date(formValue.fecha),
        formValue.titulo
      );
      this.noticiaService.addNoticia(nuevaNoticia).subscribe(
        response => {
          this.showAlert('Noticia guardada', 'success');
        },
        error => {
          this.showAlert('Error al guardar la noticia', 'error');
        }
      );
    }
  }
  private showAlert(message: string, type: 'success' | 'error'): void {
    this.alertMessage = message;
    this.alertType = type;
    setTimeout(() => {
      this.alertMessage = '';
    }, 5000);
  }
}
