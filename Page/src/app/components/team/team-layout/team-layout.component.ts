import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EquipoService } from '../../../services/equipo.service';
import { EquipoModel } from '../../../models/equipo-model';
import { JugadorModel } from '../../../models/jugador-model';

@Component({
  selector: 'app-team-layout',
  standalone: true,
  imports: [],
  templateUrl: './team-layout.component.html',
  styleUrl: './team-layout.component.css'
})
export class TeamLayoutComponent implements OnInit{

  isLoading=false;
  pageNotFound = false;
  id? : number;
  equipo?:EquipoModel;
  jugadores?: JugadorModel[] = [];
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
    })
    }
  }


  
}



