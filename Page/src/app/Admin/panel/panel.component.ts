import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-panel',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './panel.component.html',
  styleUrl: './panel.component.css'
})
export class PanelComponent implements OnInit {
  routes = [
    { path: '/admin/teamsForm', label: 'Teams' },
    { path: '/admin/usersForm', label: 'Users' },
    { path: '/admin/playersForm', label: 'Players' },
    { path: '/admin/eventsForm', label: 'Events' },
    { path: '/admin/topicsForm', label: 'Topics' },
    { path: '/admin/mapsForm', label: 'Maps' },
    { path: '/admin/newsForm', label: 'News' },
    { path: '/admin/matchForm', label: 'Match' },
    { path: '/admin/rankingForm', label: 'Ranking' },
    { path: '/admin/rankingForm', label: 'Ranking' },
  ];

  visibleRoutes: { path: string; label: string; }[] = [];
  collapsedRoutes: { path: string; label: string; }[] = [];
  dropdownOpen = false;

  ngOnInit(): void {
    this.updateRoutes();
  }

  updateRoutes(): void {
    if (this.routes.length > 15) {
      this.visibleRoutes = this.routes.slice(0, 15);
      this.collapsedRoutes = this.routes.slice(15);
    } else {
      this.visibleRoutes = this.routes;
      this.collapsedRoutes = [];
    }
  }

  toggleDropdown(): void {
    this.dropdownOpen = !this.dropdownOpen;
  }
}