import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NoticiaMainComponent } from './noticia-main/noticia-main.component';
import { NoticiaContainerComponent } from './noticia-container/noticia-container.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NoticiaMainComponent,NoticiaContainerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Page';
}
