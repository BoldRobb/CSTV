import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { EquipoService } from '../../../services/equipo.service';
import { EquipoModel } from '../../../models/equipo-model';
import { JugadorModel } from '../../../models/jugador-model';
import { CommonModule } from '@angular/common';
import { RecentActivityComponent } from '../../foros/recent-activity/recent-activity.component';

@Component({
  selector: 'app-team-layout',
  standalone: true,
  imports: [CommonModule, RecentActivityComponent, RouterModule],
  templateUrl: './team-layout.component.html',
  styleUrl: './team-layout.component.css'
})
export class TeamLayoutComponent implements OnInit{

  isLoading=true;
  pageNotFound = false;
  id? : number;
  equipo?:EquipoModel;
  jugadores: JugadorModel[] = [];
  
  defaultPlayers: JugadorModel[] = Array(5).fill({ foto: 'icons/defaultPlayer.png', mote: '? ?', pais: 'MX' });
  constructor(private route: ActivatedRoute, private equipoService: EquipoService) {
    
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      if (isNaN(this.id)) {
        this.pageNotFound = true;
      } else {
        this.getTeam();
        
      }
    });
  }

  getTeam():void{
    if(this.id!=null){
      this.equipoService.getEquipos(this.id).subscribe(data =>{
        this.equipo=data;
        this.isLoading=false;
      },
    error=>{
      this.pageNotFound=true;
      this.isLoading=false;
    });
    this.equipoService.getJugadoresEquipo(this.id).subscribe(data=>{
      this.jugadores=data;
      console.log(this.jugadores);
    })
    }
  }


  
}



