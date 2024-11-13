import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EquipoModel } from '../../models/equipo-model';
import { EquipoService } from '../../services/equipo.service';
import { AlertComponent } from '../../components/global/alert/alert.component';


@Component({
  selector: 'app-equipo-form',
  standalone: true,
  templateUrl: './equipo-form.component.html',
  styleUrls: ['./equipo-form.component.css'],
  imports: [ReactiveFormsModule, AlertComponent],

})
export class EquipoFormComponent implements OnInit {
  equipoForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  constructor(private fb: FormBuilder, private equipoService: EquipoService) {
    this.equipoForm = this.fb.group({
      nombre: ['', Validators.required],
      rankingActual: ['', Validators.required],
      rankingMaximo: ['', Validators.required],
      twitter: [''],
      instagram: [''],
      foto: ['']
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.equipoForm.valid) {
      const nuevoEquipo: EquipoModel = this.equipoForm.value;
      this.equipoService.addEquipo(nuevoEquipo).subscribe(
        response => {
          this.showAlert('Equipo guardado', 'success');
        },
        error => {
          this.showAlert('Error al guardar el equipo', 'error');
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