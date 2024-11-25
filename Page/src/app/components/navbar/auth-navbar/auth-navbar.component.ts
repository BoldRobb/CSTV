import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-auth-navbar',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './auth-navbar.component.html',
  styleUrl: './auth-navbar.component.css'
})
export class AuthNavbarComponent implements OnInit {
  username: string | null = null;
  id: number | null = null;
  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getUsernameObservable().subscribe(username => {
      this.username = username;
      
    });
    this.authService.getUserIdObservable().subscribe(id => {
      this.id = id;
    });
  }

}