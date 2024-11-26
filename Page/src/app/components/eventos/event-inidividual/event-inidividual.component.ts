import { Component } from '@angular/core';
import { RecentActivityComponent } from '../../foros/recent-activity/recent-activity.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-event-inidividual',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule, RouterModule],
  templateUrl: './event-inidividual.component.html',
  styleUrl: './event-inidividual.component.css'
})
export class EventInidividualComponent {

  isLoading=true;
  pageNotFound=false;

  constructor() { }
}
