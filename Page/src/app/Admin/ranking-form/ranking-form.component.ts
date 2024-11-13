import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { RankingService } from '../../services/ranking.service';
import { RankingModel } from '../../models/ranking-model';
import { EquipoModel } from '../../models/equipo-model';
import { RouterModule } from '@angular/router';
import { AlertComponent } from '../../components/global/alert/alert.component';


@Component({
  selector: 'app-ranking-form',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule, AlertComponent],
  templateUrl: './ranking-form.component.html',
  styleUrl: './ranking-form.component.css'
})
export class RankingFormComponent implements OnInit {
  rankingForm: FormGroup;
  alertMessage!: string;
  alertType!: 'success' | 'error';

  constructor(private fb: FormBuilder, private rankingService: RankingService) {
    this.rankingForm = this.fb.group({
      equipo: ['', Validators.required],
      ranking: ['', Validators.required],
      fechaInicio: ['', Validators.required],
      fechaFin: ['', Validators.required],
      puntos: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.rankingForm.valid) {
      const nuevoRanking: RankingModel = this.createRankingModel(this.rankingForm.value);
      this.rankingService.addRanking(nuevoRanking).subscribe(
        response => {
          this.showAlert('Ranking guardado', 'success');
        },
        error => {
          this.showAlert('Error al guardar el ranking', 'error');
        }
      );
    }
  }

  private createRankingModel(formValue: any): RankingModel {
    const equipo = new EquipoModel(formValue.equipo, 0, 0, '', '', '');
    return new RankingModel(0, equipo, formValue.ranking, new Date(formValue.fechaInicio), new Date(formValue.fechaFin), formValue.puntos);
  }

  private showAlert(message: string, type: 'success' | 'error'): void {
    this.alertMessage = message;
    this.alertType = type;
    setTimeout(() => {
      this.alertMessage = '';
    }, 5000);
  }
}
