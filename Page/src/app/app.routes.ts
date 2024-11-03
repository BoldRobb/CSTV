import { Routes } from '@angular/router';
import { NoticiaIndividualComponent } from './components/noticias/noticia-individual/noticia-individual.component';
import { NoticiaHomeComponent } from './components/noticias/noticia-home/noticia-home.component';

export const routes: Routes = [
    {path: 'news/:id', component: NoticiaIndividualComponent},
    {path: '', component: NoticiaHomeComponent}
    ];
