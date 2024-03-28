import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PlaningExamService } from '../../../services/planing-exam.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Semestre } from '../../../models/semestre.module';
import { SemestresService } from '../../../services/semestres.service';
import { Exam } from '../../../models/exam.model';
import { ExamService } from '../../../services/exam.service';

@Component({
  selector: 'app-create-planing-exams',
  templateUrl: './create-planing-exams.component.html',
  styleUrl: './create-planing-exams.component.css'
})
export class CreatePlaningExamsComponent {
  planingExamFormGroup!: FormGroup;
  semestres!: Semestre[];
  selectedFile!: File;
  exams!: Exam[];

  constructor(
    private planingExamService: PlaningExamService,
    private semestreService: SemestresService,
    private examService: ExamService,
    private router: Router,
    private fb: FormBuilder
  ){}

  ngOnInit(): void {
    this.planingExamFormGroup = this.fb.group({
      avis: this.fb.control(null, [Validators.required]),
      semestreId: this.fb.control(null, [Validators.required]),
      // exam: this.fb.control(null, [Validators.required]),
      // planing: this.fb.control(null, [Validators.required]),
    });

    this.semestreService.getAllSemestres().subscribe(
      data => {
        this.semestres = data;
      }
    );

    this.examService.getAllExams().subscribe(
      data => {
        this.exams = data;
      }
    );
  }

  // handleCreatePlaningExam(){
  //   this.uploadPlaningExam();
  //   let planingExam = this.planingExamFormGroup.value;
  //   this.planingExamService.savePlaningExam(planingExam).subscribe({
  //     next : data => {
  //       Swal.fire({
  //         position: 'center',
  //         icon: 'success',
  //         title: 'Your work has been saved',
  //         showConfirmButton: false,
  //         timer: 1500
  //       })
  //       this.planingExamFormGroup.reset()
  //     },
  //     error : err => {
  //       console.log(err);
  //     }
  //   })
  // }

  handleCreatePlaningExam(){
    if (!this.selectedFile) {
      Swal.fire('Error!', 'Please select a file to upload.', 'error');
      return;
    }

    const formData = new FormData();

    let planingExam = this.planingExamFormGroup.value;

    formData.append('planingExam', JSON.stringify(planingExam));
    formData.append('file',  this.selectedFile);

    this.planingExamService.savePlaningExam(formData).subscribe({
      next : data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.planingExamFormGroup.reset()
      },
      error : err => {
        console.log(err);
      }
    })
  }



  handleCancel(){
    this.router.navigate(['/planingExams']);
  }


  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadPlaningExam() {

    if (!this.selectedFile) {
      Swal.fire('Error!', 'Please select a file to upload.', 'error');
      return;
    }

    this.planingExamService.uploadFile(this.selectedFile).subscribe({
      next: (data) => {
        Swal.fire(
          'Uploaded!',
          'Planing uploaded successfully.',
          'success'
        );
      },
      error: (err) => {
        Swal.fire(
          'Error!',
          'An error occurred while uploading Planing.',
          'error'
        );
      }
    });
  }

}
