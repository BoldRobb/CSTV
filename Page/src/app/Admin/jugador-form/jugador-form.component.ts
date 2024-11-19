import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { JugadorService } from '../../services/jugador.service';
import { EquipoService } from '../../services/equipo.service';
import { JugadorModel } from '../../models/jugador-model';
import { EquipoModel } from '../../models/equipo-model';
import { CommonModule } from '@angular/common';
import { AlertComponent } from '../../components/global/alert/alert.component';
import { COUNTRIES } from '../../../global/countries';
import { jugadorDTO } from '../../models/DTO/jugadorDTO';

@Component({
  selector: 'app-jugador-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, AlertComponent],
  templateUrl: './jugador-form.component.html',
  styleUrl: './jugador-form.component.css'
})
export class JugadorFormComponent implements OnInit {
  jugadorForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  equiposFiltrados: EquipoModel[] = [];

  countries = COUNTRIES;

  constructor(private fb: FormBuilder, private jugadorService: JugadorService, private equipoService: EquipoService) {
    this.jugadorForm = this.fb.group({
      nombreReal: ['', Validators.required],
      mote: ['', Validators.required],
      estatus: ['', Validators.required],
      foto: ['', Validators.required],
      equipoActual: ['', Validators.required],
      localizacion: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onEquipoInput(): void {
    const equipoInput = this.jugadorForm.get('equipoActual')?.value;
    if (equipoInput) {
      this.equipoService.getEquiposNombre(equipoInput).subscribe(
        (equipos: EquipoModel[]) => {
          this.equiposFiltrados = equipos;
        },
        error => {
          console.error('Error al buscar equipos', error);
        }
      );
    } else {
      this.equiposFiltrados = [];
    }
  }

  onSubmit(): void {
    if (this.jugadorForm.valid) {
      const formValue = this.jugadorForm.value;
      const equipo = this.equiposFiltrados.find(e => e.nombre === formValue.equipoActual);
      if (!equipo) {
        this.showAlert('Equipo no encontrado', 'error');
        return;
      }
      const nuevoJugador = new jugadorDTO(
        formValue.nombreReal,
        formValue.mote,
        formValue.estatus,
        formValue.foto,
        equipo.id,
        formValue.localizacion,
      );
      this.jugadorService.createPlayer(nuevoJugador).subscribe(
        response => {
          this.showAlert('Jugador guardado', 'success');
        },
        error => {
          this.showAlert('Error al guardar el jugador', 'error');
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