import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RecentActivityComponent } from '../../foros/recent-activity/recent-activity.component';
import { RankingService } from '../../../services/ranking.service';


@Component({
  selector: 'app-ranking',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule],
  templateUrl: './ranking.component.html',
  styleUrl: './ranking.component.css'
})
export class RankingComponent implements OnInit {
  constructor(private rankingService: RankingService){}
  ngOnInit(): void{
    console.log(new Date());
    console.log(this.rankingService.getRankingToday())
  }
}
