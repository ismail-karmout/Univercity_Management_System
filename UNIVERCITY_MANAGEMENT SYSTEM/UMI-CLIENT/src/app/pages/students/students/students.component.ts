import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../../../models/student.model';
import { StudentService } from '../../../services/student.service';
import Swal from 'sweetalert2';
import * as XLSX from 'xlsx';
import { saveAs } from 'file-saver';



@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent {
  students!: Student[];
  selectedFile!: File;

  constructor(
    private studentService: StudentService,
    private router: Router
  ){}

  ngOnInit(): void{
    this.getAllStudents();
  }

  getAllStudents(): void{
    this.studentService.getAllStudents().subscribe(
      data => this.students = data
    );
  }

  handleDeleteStudent(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this module!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.studentService.deleteStudent(id).subscribe({
          next: (data) => {
            Swal.fire(
              'Deleted!',
              'Your module has been deleted.',
              'success'
            );
            // Refresh the modules list after deletion
                    this.ngOnInit();

          },
          error: (err) => {
            Swal.fire(
              'Error!',
              'An error occurred while deleting the module.',
              'error'
            );
          }
        });
      }
    });

  }

  handleEditStudent(student: Student){
    this.router.navigateByUrl("/students/edit/"+student.id);
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0]; // Get the selected file
    const reader = new FileReader();
    reader.onload = (e) => {
      const data = e.target?.result;
      const workbook = XLSX.read(data, { type: 'binary' });
      const sheetName = workbook.SheetNames[0];
      const sheet = workbook.Sheets[sheetName];
      const excelData = XLSX.utils.sheet_to_json(sheet, { header: 1 });
      // Assuming excelData is an array of arrays where each inner array represents a student's data
      console.log(excelData);
      // You can now process this data and send it to your backend
    };
    reader.readAsBinaryString(this.selectedFile);
  }

  uploadStudents() {

    if (!this.selectedFile) {
      Swal.fire('Error!', 'Please select a file to upload.', 'error');
      return;
    }

    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.studentService.uploadStudents(formData).subscribe({
      next: (data) => {
        Swal.fire(
          'Uploaded!',
          'Students uploaded successfully.',
          'success'
        );
        this.getAllStudents(); // Refresh the list of students
      },
      error: (err) => {
        Swal.fire(
          'Error!',
          'An error occurred while uploading students.',
          'error'
        );
      }
    });
  }

  exportToExcelStudents() {
    this.studentService.exportToExcelStudents().subscribe(
      (data) => {
        const blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
        saveAs(blob, 'Students Information' + '.xlsx');
      },
      error => {
        console.error('Error exporting to Excel:', error);
      }
    );
  }
  


}
