import { Component } from '@angular/core';
import { NoticiaContainerComponent } from '../noticia-container/noticia-container.component';
import { NoticiaMainComponent } from '../noticia-main/noticia-main.component';
@Component({
  selector: 'app-noticias-home',
  standalone: true,
  imports: [NoticiaContainerComponent, NoticiaMainComponent],
  templateUrl: './noticias-home.component.html',
  styleUrl: './noticias-home.component.css'
})
export class NoticiasHomeComponent {

}
