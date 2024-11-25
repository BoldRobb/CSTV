import {Component, OnInit} from '@angular/core';
import { NavigationStart, Router, RouterModule } from '@angular/router';
import {LoginFormComponent} from '../../log/login-form/login-form.component';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, LoginFormComponent, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  showLoginForm = false;
  isLoggedIn = false;
  username: string | null = null;
  constructor(private router: Router, private authService: AuthService ) {}

  ngOnInit(): void {
    this.authService.isLoggedIn().subscribe(isLoggedIn => {
      this.isLoggedIn = isLoggedIn;
    });

    this.authService.getUsernameObservable().subscribe(username => {
      this.username = username;
    });
    this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.showLoginForm = false;
      }
    });
  }

  openLoginForm(): void {
    console.log(this.showLoginForm);
    this.showLoginForm = true;
    
  }
  closeLoginForm(event: Event): void {
    this.showLoginForm = false;
  }
}