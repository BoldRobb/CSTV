import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { provideAnimations } from '@angular/platform-browser/animations';
import { NoticiasHomeComponent } from "./noticias-home/noticias-home.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, NoticiasHomeComponent],
  providers: [provideAnimations()],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Page';
}
