import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { COUNTRIES } from '../../../global/countries';
import { CommonModule } from '@angular/common';
import { UsuarioModel } from '../../models/usuario-model';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css'],
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule]
})
export class SignupFormComponent implements OnInit {
  signupForm: FormGroup;
  countries = COUNTRIES;

  constructor(private fb: FormBuilder) {
    this.signupForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      confirmEmail: ['', [Validators.required, Validators.email]],
      country: ['', Validators.required]
    }, { validator: [this.emailMatchValidator, this.passwordMatchValidator] } );
  }

  ngOnInit(): void {}

  emailMatchValidator(group: FormGroup): any {
    const email = group.get('email')?.value;
    const confirmEmail = group.get('confirmEmail')?.value;
    return email === confirmEmail ? null : { notMatching: true };
  }
  passwordMatchValidator(group: FormGroup): any {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { notMatching: true };
  }

  onSubmit(): void {
    if (this.signupForm.valid) {
      /*const newUser = new UsuarioModel(
        0,
        this.signupForm.get('username').value,
        this.signupForm.get('password').value,
        this.signupForm.get('email').value,
        "user",
        this.signupForm.get('country').value,
      )*/
      console.log('Form Submitted', this.signupForm.value);
    }
  }
}