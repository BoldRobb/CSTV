import { Component, Input } from '@angular/core';
import { TorneoModel } from '../../../models/torneo-model';

@Component({
  selector: 'app-event-statistics',
  standalone: true,
  imports: [],
  templateUrl: './event-statistics.component.html',
  styleUrl: './event-statistics.component.css'
})
export class EventStatisticsComponent {
  @Input() torneo: TorneoModel | undefined;
  constructor() { }
  ngOnInit(): void {
  }
}
