import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NavbarComponent } from '../../navbar/navbar.component';
import { NoticiaService } from '../../../services/noticia-service.service';
import { NoticiaModel } from '../../../models/noticia-model';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-noticia-individual',
  standalone: true,
  imports: [NavbarComponent, CommonModule],
  templateUrl: './noticia-individual.component.html',
  styleUrl: './noticia-individual.component.css'
})
export class NoticiaIndividualComponent {
  id?: number;
  noticia?: NoticiaModel;
  constructor(private route: ActivatedRoute, private noticiaService: NoticiaService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      console.log(this.id);
    });
    if (this.id !== undefined) {
      this.noticiaService.getNoticias(this.id).subscribe(
        data => {
          this.noticia = data;
          console.log(this.noticia);
        },
        error => console.error(error),
      );
    } else {
      console.error('ID is undefined');
    }
  }
}
