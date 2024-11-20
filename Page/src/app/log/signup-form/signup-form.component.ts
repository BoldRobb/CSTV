import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors, ReactiveFormsModule } from '@angular/forms';
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
      username: ['', [Validators.required, this.usernameValidator]],
      password: ['', [Validators.required, this.passwordValidator]],
      confirmPassword: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      confirmEmail: ['', [Validators.required, Validators.email]],
      country: ['', Validators.required]
    }, { validator: [this.emailMatchValidator, this.passwordMatchValidator] });
  }

  ngOnInit(): void {}

  usernameValidator(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    const usernamePattern = /^[a-zA-Z0-9_]{6,}$/;
    if (!usernamePattern.test(value)) {
      return { invalidUsername: true };
    }
    return null;
  }

  passwordValidator(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    const passwordPattern = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordPattern.test(value)) {
      return { invalidPassword: true };
    }
    return null;
  }

  emailMatchValidator(group: FormGroup): ValidationErrors | null {
    const email = group.get('email')?.value;
    const confirmEmail = group.get('confirmEmail')?.value;
    if (email !== confirmEmail) {
      return { emailMismatch: true };
    }
    return null;
  }

  passwordMatchValidator(group: FormGroup): ValidationErrors | null {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      return { passwordMismatch: true };
    }
    return null;
  }

  onSubmit(): void {
    if (this.signupForm.valid) {
      const nuevoUsuario: UsuarioModel = this.createUsuarioModel(this.signupForm.value);
      // Lógica para enviar el formulario
    }
  }

  private createUsuarioModel(formValue: any): UsuarioModel {
    return new UsuarioModel(
      0,
      formValue.username,
      formValue.password,
      formValue.email,
      'User',
      formValue.country
    );
  }
}