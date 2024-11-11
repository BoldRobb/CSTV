import { Component } from '@angular/core';
import { RecentActivityComponent } from '../foros/recent-activity/recent-activity.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-events-main',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule],
  templateUrl: './events-main.component.html',
  styleUrl: './events-main.component.css'
})
export class EventsMainComponent {

}
