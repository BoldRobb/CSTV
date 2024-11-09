import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RecentActivityComponent } from '../recent-activity/recent-activity.component';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ForoModel } from '../../../models/foro-model';
import { TopicoModel } from '../../../models/topico-model';
import { ForoServiceService } from '../../../services/foro-service.service';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-forum-topics',
  standalone: true,
  imports: [RecentActivityComponent, CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './forum-topics.component.html',
  styleUrl: './forum-topics.component.css'
})
export class ForumTopicsComponent {
newTopicForm!: FormGroup<any>;
id?: number;
foro?: ForoModel;
topicos?: TopicoModel[];
constructor(private route: ActivatedRoute, private foroService: ForoServiceService, private fb: FormBuilder) { }

ngOnInit(): void {
  this.route.params.subscribe(params => {
    this.id = +params['id'];
  });
  this.getForo();
  this.getTopics();
  this.newTopicForm = this.fb.group({
    title: ['', Validators.required],
    description: ['', Validators.required]
  });
}

  getForo(): void {
    if (this.id !== undefined) {
      this.foroService.getForo(this.id).subscribe(
        data => {
          this.foro = data;
          console.log(this.foro);
        },
        error => {
          console.error(error);
        },
      );
    } else {
      console.error('ID is undefined');
    }
  }
  getTopics(): void {
    if (this.id !== undefined) {
      this.foroService.getTopicosForo(this.id).subscribe(
        data => {
          this.topicos = data.map(topic => {
            return topic;
          });
          console.log(this.topicos);
        },
        error => {
          console.error(error);
        },
      );
    } else {
      console.error('ID is undefined');
    }
  }

  formatDate(date: any): string {
    const validDate = new Date(date);
    const day = String(validDate.getDate()).padStart(2, '0');
    const month = String(validDate.getMonth() + 1).padStart(2, '0');
    const year = validDate.getFullYear();
    return `${day}-${month}-${year}`;
  }
  
  createTopic() {
    throw new Error('Method not implemented.');
    }

}
