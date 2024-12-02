import { Component, Input } from '@angular/core';
import { TorneoModel } from '../../../models/torneo-model';

@Component({
  selector: 'app-event-results',
  standalone: true,
  imports: [],
  templateUrl: './event-results.component.html',
  styleUrl: './event-results.component.css'
})
export class EventResultsComponent {
  @Input() torneo: TorneoModel | undefined;
  constructor() { }
  ngOnInit(): void {
  }
}
