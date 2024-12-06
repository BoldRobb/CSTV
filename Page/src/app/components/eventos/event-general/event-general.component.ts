import { Component, Input } from '@angular/core';
import { TorneoModel } from '../../../models/torneo-model';
import { TorneoService } from '../../../services/torneo.service';
import { TorneoEquiposModel } from '../../../models/torneo-equipos-model';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { NoticiaService } from '../../../services/noticia-service.service';
import { NoticiaModel } from '../../../models/noticia-model';

@Component({
  selector: 'app-event-general',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './event-general.component.html',
  styleUrl: './event-general.component.css'
})
export class EventGeneralComponent {
  @Input() torneo: TorneoModel | undefined;
  @Input() equipos: TorneoEquiposModel[] = [];
  noticias: NoticiaModel[] = [];
  isLoading = false;
  constructor(private torneoService: TorneoService, private router: Router, private noticiaService: NoticiaService) { }
  ngOnInit(): void {
    this.getEquipos();
  }

  getEquipos(): void {
    if (this.torneo != null) {

      this.noticiaService.getNoticiasForTorneo(this.torneo.id).subscribe(
        (data) => {
          this.noticias = data;
          
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
  formatPosition(position: number): string {
    const suffixes = ["th", "st", "nd", "rd"];
    const value = position % 100;
    return position + (suffixes[(value - 20) % 10] || suffixes[value] || suffixes[0]) + " place";
  }

  formatCurrency(value: number | null | undefined): string {
    if (value == null) return '';
    return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(value);
  }

  getEquiposSortedByRanking(): TorneoEquiposModel[] {
    return [...this.equipos].sort((a, b) => {
      if (a?.idEquipo?.rankingActual == 0 && b?.idEquipo?.rankingActual == 0) {
        return a?.idEquipo?.nombre?.localeCompare(b?.idEquipo?.nombre || '') || 0;
      }
      if ( a.idEquipo.rankingActual === 0) return 1;
      if ( b.idEquipo.rankingActual === 0) return -1;
      return a.idEquipo.rankingActual - b.idEquipo.rankingActual;
    });
  }
  navigateToNoticia(id: number): void {
    this.router.navigate(['/news', id]);
  }
}
