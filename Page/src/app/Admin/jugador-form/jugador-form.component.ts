import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
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
  imports: [CommonModule, ReactiveFormsModule, AlertComponent, FormsModule],
  templateUrl: './jugador-form.component.html',
  styleUrl: './jugador-form.component.css'
})
export class JugadorFormComponent implements OnInit {
  jugadorForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';
  countries = COUNTRIES;
  showForm: boolean = false;
  isEditing: boolean = false;
  searchQuery: string = '';
  searchResults: JugadorModel[] = [];
  equiposFiltrados: EquipoModel[] = [];
  currentPlayer?: JugadorModel;
  constructor(private fb: FormBuilder, private jugadorService: JugadorService, private equipoService: EquipoService) {
    this.jugadorForm = this.fb.group({
      nombreReal: ['', Validators.required],
      mote: ['', Validators.required],
      estatus: ['', Validators.required],
      foto: ['', Validators.required],
      equipoActual: ['', Validators.required],
      country: ['', Validators.required]
    });
  }

  ngOnInit(): void {}


  showAddForm(): void {
    this.isEditing = false;
    this.showForm = true;
    this.jugadorForm.reset();
  }

  showEditForm(): void {
    this.isEditing = true;
    this.showForm = false;
  }

  searchJugadores(): void {
    if (this.searchQuery.length > 2) {
      this.jugadorService.getPlayerByNombre(this.searchQuery).subscribe((results) => {
        this.searchResults = results;
      });
    } else {
      this.searchResults = [];
    }
  }

  selectJugador(jugador: JugadorModel): void {
    this.jugadorForm.patchValue(jugador);
    this.showForm = true;
    this.currentPlayer = jugador;
  }

  onEquipoInput(): void {
    const query = this.jugadorForm.get('equipoActual')?.value;
    if (query.length > 2) {
      this.equipoService.getEquiposNombre(query).subscribe((results) => {
        this.equiposFiltrados = results;
      });
    } else {
      this.equiposFiltrados = [];
    }
  }
  async getEquipoIdByName(nombre: string): Promise<number> {
    let equipoId = 0;
    const results = await this.equipoService.getEquiposNombre(nombre).toPromise();
    if (results && results.length > 0) {
      equipoId = results[0].id;
    }
    return equipoId;
  }


  async onSubmit(): Promise<void> {
    if (this.jugadorForm.valid) {
      const jugador: JugadorModel = this.jugadorForm.value;
      const equipoId = await this.getEquipoIdByName(this.jugadorForm.get('equipoActual')?.value);
      
      const jugadorDTO: jugadorDTO = {
      
        nombreReal: jugador.nombreReal,
        mote: jugador.mote,
        estatus: jugador.estatus,
        foto: jugador.foto,
        idEquipoActual: equipoId,
        pais: jugador.pais

      }
    
      if (this.isEditing) {
        // Lógica para actualizar el jugador
        if(this.currentPlayer){
          (jugadorDTO);
          (jugador);
        this.jugadorService.updatePlayer(this.currentPlayer.id, jugadorDTO).subscribe(
          (response) => {
            this.alertMessage = 'Jugador actualizado con éxito';
            this.alertType = 'success';
          },
          (error) => {
            this.alertMessage = 'Error al actualizar el jugador';
            this.alertType = 'error';
          }
        );}
      } else {
        // Lógica para agregar un nuevo jugador
        this.jugadorService.createPlayer(jugadorDTO).subscribe(
          (response) => {
            this.alertMessage = 'Jugador agregado con éxito';
            this.alertType = 'success';
          },
          (error) => {
            this.alertMessage = 'Error al agregar el jugador';
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