import { Routes } from '@angular/router';
import { NoticiaIndividualComponent } from './components/noticias/noticia-individual/noticia-individual.component';
import { NoticiaHomeComponent } from './components/noticias/noticia-home/noticia-home.component';
import { LayoutNoticiaComponent } from './components/noticias/layout-noticia/layout-noticia.component';
import { ScoreboardComponent } from './components/live/scoreboard/scoreboard.component';

export const routes: Routes = [
    {path: 'news', redirectTo:'',},
    {path: 'ranking', component: ScoreboardComponent},
    { path: 'news/:id', component: NoticiaIndividualComponent },
    {path: '', component: LayoutNoticiaComponent},
    { path: '**', redirectTo: '' }
];
