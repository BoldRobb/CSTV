import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { provideAnimations } from '@angular/platform-browser/animations';
import { NoticiasHomeComponent } from "./components/noticias/noticias-home/noticias-home.component";
import { RecentActivityComponent } from './components/foros/recent-activity/recent-activity.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, NoticiasHomeComponent, RecentActivityComponent],
  providers: [provideAnimations()],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Page';
}
