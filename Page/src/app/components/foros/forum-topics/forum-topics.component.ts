import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RecentActivityComponent } from '../recent-activity/recent-activity.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-forum-topics',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule, RouterModule],
  templateUrl: './forum-topics.component.html',
  styleUrl: './forum-topics.component.css'
})
export class ForumTopicsComponent {

}
