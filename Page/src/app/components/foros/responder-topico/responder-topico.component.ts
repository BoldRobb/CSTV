import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RespuestaServiceService } from '../../../services/respuesta-service.service';
import { TopicoModel } from '../../../models/topico-model';
import { AuthService } from '../../../services/auth.service';
import { CommonModule } from '@angular/common';
import { RespuestaDTO } from '../../../models/DTO/respuestaDTO';
@Component({
  selector: 'app-responder-topico',
  standalone: true,
  templateUrl: './responder-topico.component.html',
  styleUrls: ['./responder-topico.component.css'],
  imports: [CommonModule, ReactiveFormsModule],
})
export class ResponderTopicoComponent implements OnInit {
  @Input() topico!: TopicoModel;
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
        this.topico.id,
        formValue.respuesta,
        new Date(),
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