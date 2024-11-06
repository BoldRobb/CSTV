import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { RecentActivityComponent } from '../../foros/recent-activity/recent-activity.component';
import { NoticiaPrincipalComponent } from '../noticia-principal/noticia-principal.component';

@Component({
  selector: 'app-layout-noticia',
  standalone: true,
  imports: [RouterModule, NoticiaPrincipalComponent, RecentActivityComponent],
  templateUrl: './layout-noticia.component.html',
  styleUrl: './layout-noticia.component.css'
})
export class LayoutNoticiaComponent {

}
