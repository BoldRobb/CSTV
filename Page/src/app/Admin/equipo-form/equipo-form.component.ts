import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, NgModel, ReactiveFormsModule, Validators } from '@angular/forms';
import { EquipoModel } from '../../models/equipo-model';
import { EquipoService } from '../../services/equipo.service';
import { AlertComponent } from '../../components/global/alert/alert.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-equipo-form',
  standalone: true,
  templateUrl: './equipo-form.component.html',
  styleUrls: ['./equipo-form.component.css'],
  imports: [ReactiveFormsModule, AlertComponent, CommonModule, FormsModule],

})
export class EquipoFormComponent implements OnInit {
  equipoForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  teamId!: number;
  showForm: boolean = false;
  isEditing: boolean = false;
  searchQuery: string = '';
  searchResults: EquipoModel[] = [];
  currentEquipo?: EquipoModel;
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

  showAddForm(): void {
    this.isEditing = false;
    this.showForm = true;
    this.equipoForm.reset();
  }

  showEditForm(): void {
    this.isEditing = true;
    this.showForm = false;
  }

  searchEquipos(): void {
    if (this.searchQuery.length > 2) {
      this.equipoService.getEquiposNombre(this.searchQuery).subscribe((results) => {
        this.searchResults = results;
      });
    } else {
      this.searchResults = [];
    }
  }

  selectEquipo(equipo: EquipoModel): void {
    this.currentEquipo = equipo;
    this.equipoForm.patchValue(equipo);
    this.showForm = true;
  }

  onSubmit(): void {
    if (this.equipoForm.valid) {
      const equipo: EquipoModel = this.equipoForm.value;
      if (this.isEditing) {
        if(this.currentEquipo){
        // Lógica para actualizar el equipo
        this.equipoService.updateEquipo(this.currentEquipo.id, equipo).subscribe(
          () => {
            this.alertMessage = 'Equipo actualizado con éxito';
            this.alertType = 'success';
          },
          () => {
            this.alertMessage = 'Error al actualizar el equipo';
            this.alertType = 'error';
          }
        );}
      } else {
        // Lógica para agregar un nuevo equipo
        this.equipoService.addEquipo(equipo).subscribe(
          (response) => {
            this.alertMessage = 'Equipo agregado con éxito';
            this.alertType = 'success';
          },
          (error) => {
            this.alertMessage = 'Error al agregar el equipo';
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