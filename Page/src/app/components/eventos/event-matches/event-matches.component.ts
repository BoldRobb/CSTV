import { Component, Input } from '@angular/core';
import { TorneoModel } from '../../../models/torneo-model';

@Component({
  selector: 'app-event-matches',
  standalone: true,
  imports: [],
  templateUrl: './event-matches.component.html',
  styleUrl: './event-matches.component.css'
})
export class EventMatchesComponent {
  @Input() torneo: TorneoModel | undefined;
  constructor() { }
  ngOnInit(): void {
  }
}
