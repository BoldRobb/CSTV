import {Component, OnInit} from '@angular/core';
import { NavigationStart, Router, RouterModule } from '@angular/router';
import {LoginFormComponent} from '../../log/login-form/login-form.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, LoginFormComponent, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  showLoginForm = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.showLoginForm = false;
      }
    });
  }

  openLoginForm(): void {
    this.showLoginForm = true;
  }

  closeLoginForm(event: Event): void {
    this.showLoginForm = false;
  }
}