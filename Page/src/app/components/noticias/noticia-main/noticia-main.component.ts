import { Component, OnInit } from '@angular/core';
import { NoticiaService } from '../../../services/noticia-service.service';
import { NoticiaModel } from '../../../models/noticia-model';
@Component({
  selector: 'app-noticia-main',
  standalone: true,
  imports: [],
  templateUrl: './noticia-main.component.html',
  styleUrl: './noticia-main.component.css'
})

export class NoticiaMainComponent implements OnInit {
  noticia!: NoticiaModel;

  constructor(private noticiaService: NoticiaService) { }

  ngOnInit(): void {
    this.noticiaService.getNoticiaMain().subscribe(
      data => this.noticia = data,
      error => console.error(error)
    );
    console.log(this.noticia);
  }
}
