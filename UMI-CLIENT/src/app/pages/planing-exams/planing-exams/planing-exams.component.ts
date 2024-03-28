import { Component } from '@angular/core';
import { PlaningExam } from '../../../models/planing-exam.model';
import { PlaningExamService } from '../../../services/planing-exam.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-planing-exams',
  templateUrl: './planing-exams.component.html',
  styleUrl: './planing-exams.component.css'
})
export class PlaningExamsComponent {
  planingExams!: PlaningExam[];


  constructor(
    private planingExamService: PlaningExamService,
    private router: Router,
    private http: HttpClient
  ){}

  ngOnInit(): void{
    this.getAllPlaningExams();
  }

  getAllPlaningExams(): void {
    this.planingExamService.getAllPlaningExams().subscribe(
      data => {
        this.planingExams = data;
      }
    );
  }

  
downloadFile(fileName: string) {
  this.http.get(`http://localhost:9999/EXAM-SERVICE/api/planing-exams/downloadFile/${fileName}`, { responseType: 'blob' })
    .subscribe(blob => {
      const url = window.URL.createObjectURL(blob);
      console.log(url)
      const a = document.createElement('a');
      document.body.appendChild(a);
      a.style.display = 'none';
      a.href = url;
      a.download = fileName;
      a.click();
      window.URL.revokeObjectURL(url);
    });
}

  handleDeletePlaningExam(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this PlaningExam!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.planingExamService.deletePlaningExam(id).subscribe({
          next: (data) => {
            Swal.fire(
              'Deleted!',
              'Your PlaningExam has been deleted.',
              'success'
            );
            // Refresh the PlaningExams list after deletion
                    this.ngOnInit();

          },
          error: (err) => {
            Swal.fire(
              'Error!',
              'An error occurred while deleting the PlaningExam.',
              'error'
            );
          }
        });
      }
    });
  }

  handleEditPlaningExam(planingExam: PlaningExam){
    this.router.navigateByUrl("PlaningExams/edit/"+planingExam.id);
  }

}
