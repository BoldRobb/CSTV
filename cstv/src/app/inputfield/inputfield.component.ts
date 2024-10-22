import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { validation_messages } from './validation-messages';
import { ReactiveFormsModule, FormControl } from '@angular/forms';

@Component({
  selector: 'app-inputfield',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './inputfield.component.html',
  styleUrl: './inputfield.component.scss'
})
export class InputFieldComponent {

  @Input() label: string = '';
  @Input() for: string = '';
  @Input() type: string = '';
  @Input() name: string = '';
  @Input() id: string = '';
  @Input() placeholder: string = '';
  @Input() required: boolean = false;
  @Input() control = new FormControl();
  @Input() css: 'input-primary' | 'input-danger' = 'input-primary';

  errorMessages: any = validation_messages;

  getCssClasses(): string {
    if (this.control.invalid && this.control.dirty && this.control.touched) {
      return 'input-danger';
    }
    return 'input-primary';
  }

  getErrorMessage(): string {
    const controlErrors = this.control.errors;
    if (controlErrors) {
      for (const key in controlErrors) {
        if (controlErrors.hasOwnProperty(key)) {
          const error = this.errorMessages[this.name]?.find((err: any) => err.type === key);
          if (error) {
            return error.message;
          }
        }
      }
    }
    return '';
  }
}

