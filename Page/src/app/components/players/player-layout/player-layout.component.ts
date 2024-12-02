import { Component } from '@angular/core';
import { RecentActivityComponent } from '../../foros/recent-activity/recent-activity.component';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { JugadorModel } from '../../../models/jugador-model';
import { JugadorService } from '../../../services/jugador.service';

@Component({
  selector: 'app-player-layout',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule, RouterModule],
  templateUrl: './player-layout.component.html',
  styleUrl: './player-layout.component.css'
})
export class PlayerLayoutComponent {
  isLoading = true;
  pageNotFound = false;
  id?: number;
  player?: JugadorModel;
  constructor(private route: ActivatedRoute, 
    private jugadorService: JugadorService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      if (isNaN(this.id)) {
        this.pageNotFound = true;
      } else {
        this.getPlayer();
        
      }
    });
  }

  getPlayer(): void {
  
    if (this.id != null) {
      this.jugadorService.getPlayer(this.id).subscribe(
        (data) => {
          this.player = data;
          this.isLoading = false;
        },
        (error) => {
          this.pageNotFound = true;
          this.isLoading = false;
        });       
      }
  }
}
