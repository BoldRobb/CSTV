
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { TorneoService } from '../../services/torneo.service';
import { TorneoModel } from '../../models/torneo-model';
import { CommonModule } from '@angular/common';
import { AlertComponent } from '../../components/global/alert/alert.component';
import { COUNTRIES } from '../../../global/countries';
import { TorneoEquiposModel } from '../../models/torneo-equipos-model';

@Component({
  selector: 'app-torneo-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, AlertComponent, FormsModule],
  templateUrl: './torneo-form.component.html',
  styleUrl: './torneo-form.component.css'
})
export class TorneoFormComponent implements OnInit {
  torneoForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  countries = COUNTRIES;
  showForm: boolean = false;
  isEditing: boolean = false;
  searchQuery: string = '';
  searchResults: TorneoModel[] = [];
  equipos: TorneoEquiposModel[] = [];
  currentTorneo: TorneoModel | undefined;

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

  showAddForm(): void {
    this.isEditing = false;
    this.showForm = true;
    this.torneoForm.reset();
  }

  showEditForm(): void {
    this.isEditing = true;
    this.showForm = false;
  }

  searchTorneos(): void {
    if (this.searchQuery.length > 2) {
      this.torneoService.getTorneosByNombre(this.searchQuery).subscribe((results) => {
        this.searchResults = results;
      });
    } else {
      this.searchResults = [];
    }
  }

  selectTorneo(torneo: TorneoModel): void {
    this.currentTorneo = torneo;
    this.torneoForm.patchValue(torneo);
    this.showForm = true;
  }

  onSubmit(): void {
    if (this.torneoForm.valid) {
      const torneo: TorneoModel = this.torneoForm.value;
      if (this.isEditing) {
        // Lógica para actualizar el torneo
        if (this.currentTorneo) {
          this.torneoService.updateTorneo(this.currentTorneo.id, torneo).subscribe(
            (response) => {
              this.alertMessage = 'Torneo actualizado con éxito';
              this.alertType = 'success';
            },
            (error) => {
              this.alertMessage = 'Error al actualizar el torneo';
              this.alertType = 'error';
            }
          );
        }
      } else {
        // Lógica para agregar un nuevo torneo
        this.torneoService.addTorneo(torneo).subscribe(
          (response) => {
            this.alertMessage = 'Torneo agregado con éxito';
            this.alertType = 'success';
          },
          (error) => {
            this.alertMessage = 'Error al agregar el torneo';
            this.alertType = 'error';
          }
        );
      }
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