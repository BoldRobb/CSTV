import { Routes } from '@angular/router';
import { NoticiaIndividualComponent } from './components/noticias/noticia-individual/noticia-individual.component';
import { NoticiaHomeComponent } from './components/noticias/noticia-home/noticia-home.component';
import { LayoutNoticiaComponent } from './components/noticias/layout-noticia/layout-noticia.component';
import { ScoreboardComponent } from './components/live/scoreboard/scoreboard.component';
import { ForumsComponent } from './components/foros/forums/forums.component';
import { ForumTopicsComponent } from './components/foros/forum-topics/forum-topics.component';

export const routes: Routes = [
    //Noticias
    {path: 'news', redirectTo:'',},
    {path: 'news/:id', component: NoticiaIndividualComponent },
    //Ranking
    {path: 'ranking', component: ScoreboardComponent},

    //Foro
    {path: 'forum', component: ForumsComponent},
    {path: 'forum/:id', component: ForumTopicsComponent},

    //Home
    {path: '', component: LayoutNoticiaComponent},
    {path: '**', redirectTo: '' }
];
