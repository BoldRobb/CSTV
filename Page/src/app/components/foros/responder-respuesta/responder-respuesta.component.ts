import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RespuestaServiceService } from '../../../services/respuesta-service.service';
import { RespuestasModel } from '../../../models/respuestas-model';
import { AuthService } from '../../../services/auth.service';
import { CommonModule } from '@angular/common';
import { RespuestaDTO } from '../../../models/DTO/respuestaDTO';

@Component({
  selector: 'app-responder-respuesta',
  standalone: true,
  templateUrl: './responder-respuesta.component.html',
  styleUrls: ['./responder-respuesta.component.css'],
  imports: [CommonModule, ReactiveFormsModule],
})
export class ResponderRespuestaComponent implements OnInit {
  @Input() respuestaPadre!: RespuestasModel;
  responderForm: FormGroup;
  isLoggedIn = false;
  currentUserId?: number;

  constructor(
    private fb: FormBuilder,
    private respuestaService: RespuestaServiceService,
    private authService: AuthService
  ) {
    this.responderForm = this.fb.group({
      respuesta: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.authService.isLoggedIn().subscribe(isLoggedIn => {
      this.isLoggedIn = isLoggedIn;
      if (isLoggedIn) {
        const currentUser = JSON.parse(localStorage.getItem('user') || '{}');
        this.currentUserId = currentUser.id;
      }
    });
  }

  onSubmitResponder(): void {
    if (this.responderForm.valid) {
      const formValue = this.responderForm.value;
      const nuevaRespuesta = new RespuestaDTO(
        0,
        this.currentUserId || 0,
        this.respuestaPadre.topico.id,
        formValue.respuesta,
        new Date(),
        this.respuestaPadre.id
      );

      this.respuestaService.addRespuesta(nuevaRespuesta).subscribe(
        response => {
          this.responderForm.reset();
        },
        error => {
          console.error('Error creating respuesta', error);
        }
      );
    }
  }
}