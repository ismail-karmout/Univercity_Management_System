import { Component, OnInit } from '@angular/core';
import { Eventr } from '../../../models/eventr.module';
import { EventrService } from '../../../services/eventr.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FileHandle } from '../../../models/file-handel.model';
import { DomSanitizer } from '@angular/platform-browser';
import { Labo } from '../../../models/labo.module';
import { LaboService } from '../../../services/labo.service';

@Component({
  selector: 'app-create-eventr',
  templateUrl: './create-eventr.component.html',
  styleUrl: './create-eventr.component.css'
})
export class CreateEventrComponent implements OnInit{

  eventr: Eventr[] = [];
  labs: Labo[] = [];

  newEventr: Eventr = { intitule: '', justificatif: '',lieu: '', date: '', description: '', image: '', type: '' ,  eventrImages: []};

  newNewsArray: Eventr[] = [this.newEventr];

  constructor(
    private eventrService: EventrService,
    private labsService: LaboService,
    private router: Router,
    private sanitizer: DomSanitizer
) { }

  ngOnInit(): void {
    // this.loadDepartments();
    this.loadLabs();
    this.loadEventr();
}

loadLabs(): void {
  this.labsService.getAllLabos().subscribe(labss => {
      this.labs = labss;
  });
}

loadEventr(): void {
  this.eventrService.getAllEventr().subscribe(Eventr => {
      this.eventr = Eventr;
  });
}

createEventr(): void {

  const eventFormData = this.prepareFormData(this.newEventr);
  this.eventrService.createEventr(eventFormData).subscribe(() => {
      this.loadEventr();
      this.newEventr = { intitule: '', justificatif: '',lieu: '', date: '',type: '' , description: '', eventrImages: []};
      Swal.fire(
          'Create!',
          'Your Event-Recherche has been created successefully.',
          'success'
      );
      this.router.navigate(['/eventr/create']); // Adjust the route based on your actual route configuration
  });
}

prepareFormData(newEventr: Eventr): FormData {
  const formData = new FormData();

  formData.append(
    'eventDto' , new Blob([JSON.stringify(newEventr)] , {type: 'application/json'})
  );

  for(let i = 0; i < newEventr.eventrImages.length; i++){
    formData.append(
      'imageFile' , 
      newEventr.eventrImages[i].file,
      newEventr.eventrImages[i].file.name
    );
  }

  return formData;
}

onSelectFile(event: any): void {
  if(event.target.files){
    const file = event.target.files[0];
    const fileHand: FileHandle = {
      file: file,
      url: this.sanitizer.bypassSecurityTrustUrl(
         window.URL.createObjectURL(file)
      )
    };
    if(!this.newEventr.eventrImages){
      this.newEventr.eventrImages = []; // Initialiser newNews.newsImages s'il est null ou undefined
    }
    this.newEventr.eventrImages.push(fileHand);
  }
}

removeImage(i : number){
  this.newEventr.eventrImages.splice(i, 1);

}


}
