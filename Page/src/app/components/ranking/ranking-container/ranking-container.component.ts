import { Component, Input } from '@angular/core';
import { EquipoModel } from '../../../models/equipo-model';
import { EquipoService } from '../../../services/equipo.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-ranking-container',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './ranking-container.component.html',
  styleUrl: './ranking-container.component.css'
})
export class RankingContainerComponent {
  @Input()id?: number;
  equipo?: EquipoModel;
  constructor(private equipoService: EquipoService) { }

  ngOnInit() { 
    if (this.id !== undefined) {
      this.equipoService.getEquipos(this.id).subscribe((data) => {
        this.equipo = data;
      });
    }
  }
}
