import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormControl } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from '../inputfield/inputfield.component'; // Asegúrate de importar tu componente de campo de entrada

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, InputFieldComponent],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor() { }
  ngOnInit(): void { }

  formGroup = new FormGroup({
    username: new FormControl("", [Validators.required, Validators.minLength(7)]),
    password: new FormControl("", [Validators.required, Validators.minLength(7)]),
  })

  onSubmit() {
    if (this.formGroup.invalid) {
      this.markAllAsTouched();
      return;
    }
  }
  private markAllAsTouched() {
    Object.keys(this.formGroup.controls).forEach(key => {
      const control = this.formGroup.get(key);
      control?.markAsTouched();
      control?.markAsDirty();
    });
  }
}
  

