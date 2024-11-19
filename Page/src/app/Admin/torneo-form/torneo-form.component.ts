
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TorneoService } from '../../services/torneo.service';
import { TorneoModel } from '../../models/torneo-model';
import { CommonModule } from '@angular/common';
import { AlertComponent } from '../../components/global/alert/alert.component';
import { COUNTRIES } from '../../../global/countries';

@Component({
  selector: 'app-torneo-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, AlertComponent],
  templateUrl: './torneo-form.component.html',
  styleUrl: './torneo-form.component.css'
})
export class TorneoFormComponent implements OnInit {
  torneoForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  countries = COUNTRIES;

  constructor(private fb: FormBuilder, private torneoService: TorneoService) {
    this.torneoForm = this.fb.group({
      nombre: ['', Validators.required],
      fechaInicial: ['', Validators.required],
      fechaFinal: ['', Validators.required],
      logo: ['', Validators.required],
      tipo_bracket: ['', Validators.required],
      prizepool: ['', Validators.required],
      equipos_cant: ['', Validators.required],
      localizacion: ['', Validators.required],
      tipo: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.torneoForm.valid) {
      const formValue = this.torneoForm.value;
      const nuevoTorneo = new TorneoModel(
        0, // ID, se puede ajustar según sea necesario
        formValue.nombre,
        new Date(formValue.fechaFinal),
        new Date(formValue.fechaInicial),
        formValue.logo,
        formValue.tipo_bracket,
        formValue.prizepool,
        formValue.equipos_cant,
        formValue.localizacion,
        formValue.tipo
      );
      this.torneoService.addTorneo(nuevoTorneo).subscribe(
        response => {
          this.showAlert('Torneo guardado', 'success');
        },
        error => {
          this.showAlert('Error al guardar el torneo', 'error');
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