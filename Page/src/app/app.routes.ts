import { Routes } from '@angular/router';
import { NoticiaIndividualComponent } from './components/noticias/noticia-individual/noticia-individual.component';
import { LayoutNoticiaComponent } from './components/noticias/layout-noticia/layout-noticia.component';
import { ForumsComponent } from './components/foros/forums/forums.component';
import { ForumTopicsComponent } from './components/foros/forum-topics/forum-topics.component';
import { RankingComponent } from './components/ranking/ranking/ranking.component';
import { EventsMainComponent } from './components/eventos/events-main/events-main.component';
import { PanelComponent } from './Admin/panel/panel.component';
import { EquipoFormComponent } from './Admin/equipo-form/equipo-form.component';
import { RankingFormComponent } from './Admin/ranking-form/ranking-form.component';


export const routes: Routes = [
    //Noticias
    {path: 'news', redirectTo:'',},
    {path: 'news/:id', component: NoticiaIndividualComponent },
    //Ranking
    {path: 'ranking', component: RankingComponent},

    //Foro
    {path: 'forum', component: ForumsComponent},
    {path: 'forum/:id', component: ForumTopicsComponent},

    //Admin
    {path: 'admin', component: PanelComponent, children: [
        {path: 'teamsForm', component: EquipoFormComponent},
        {path: 'topicsForm', component: PanelComponent},
        {path: 'rankingForm', component: RankingFormComponent},
        {path: 'eventsForm', component: PanelComponent},
        
        {path: 'Topic', component: PanelComponent},

    ]},
    //Eventos
    {path: 'events', component: EventsMainComponent},
    //Home
    {path: '', component: LayoutNoticiaComponent},
    {path: '**', redirectTo: '' },
    
];
