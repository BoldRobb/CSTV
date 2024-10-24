import { Component, OnInit } from '@angular/core';
import { NoticiaService } from '../noticia-service.service';
import { NoticiaModel } from '../noticia-model';
@Component({
  selector: 'app-noticia-main',
  standalone: true,
  imports: [],
  templateUrl: './noticia-main.component.html',
  styleUrl: './noticia-main.component.css'
})

export class NoticiaMainComponent implements OnInit {
  id: number = 1;
  noticia!: NoticiaModel;

  constructor(private noticiaService: NoticiaService) { }

  ngOnInit(): void {
    this.noticiaService.getNoticias(this.id).subscribe(
      data => this.noticia = data,
      error => console.error(error)
    );
    console.log(this.noticia);
  }
}
