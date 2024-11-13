import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RecentActivityComponent } from './components/foros/recent-activity/recent-activity.component';
import { ScoreboardComponent } from './components/live/scoreboard/scoreboard.component';
import { EquipoFormComponent } from './Admin/equipo-form/equipo-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, RecentActivityComponent,ScoreboardComponent, EquipoFormComponent],
  providers: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Page';
}
