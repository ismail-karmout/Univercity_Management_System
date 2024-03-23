import { RouterModule, Routes } from '@angular/router';
// import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { EtablissementsComponent } from './pages/etablissements/etablissements/etablissements.component';
import { CreateEtablissementComponent } from './pages/etablissements/create-etablissement/create-etablissement.component';
import { EditEtablissementComponent } from './pages/etablissements/edit-etablissement/edit-etablissement.component';
import { DepartmentsComponent } from './pages/departments/departments/departments.component';
import { CreateDepartmentComponent } from './pages/departments/create-department/create-department.component';
import { EditDepartmentComponent } from './pages/departments/edit-department/edit-department.component';
import { RechercheAxesComponent } from './pages/recherche-axes/recherceh-axes/recherche-axes.component';
import { CreateRechercheAxeComponent } from './pages/recherche-axes/create-recherche-axe/create-recherche-axe.component';
import { EditRechercheAxeComponent } from './pages/recherche-axes/edit-recherche-axe/edit-recherche-axe.component';
import { TeamsComponent } from './pages/teams/teams/teams.component';
import { CreateTeamComponent } from './pages/teams/create-team/create-team.component';
import { EditTeamComponent } from './pages/teams/edit-team/edit-team.component';
import { LabosComponent } from './pages/labos/labos/labos.component';
import { CreateLaboComponent } from './pages/labos/create-labo/create-labo.component';
import { EditLaboComponent } from './pages/labos/edit-labo/edit-labo.component';
import { EcoleDoctoraleComponent } from './pages/ecole-doctorale/ecole-doctorale/ecole-doctorale.component';
import { CreateEcoleDoctoraleComponent } from './pages/ecole-doctorale/create-ecole-doctorale/create-ecole-doctorale.component';
import { EditEcoleDoctoraleComponent } from './pages/ecole-doctorale/edit-ecole-doctorale/edit-ecole-doctorale.component';
import { EditFormationComponent } from './pages/formations/edit-formation/edit-formation.component';
import { CreateFormationComponent } from './pages/formations/create-formation/create-formation.component';
import { FormationComponent } from './pages/formations/formation/formation.component';
import { EditSemestreComponent } from './pages/semestres/edit-semestre/edit-semestre.component';
import { CreateSemestreComponent } from './pages/semestres/create-semestre/create-semestre.component';
import { SemestreComponent } from './pages/semestres/semestre/semestre.component';
import { EditAnneeUniversitaireComponent } from './pages/anneesUniversitaires/edit-annee-universitaire/edit-annee-universitaire.component';
import { CreateAnneeUniversitaireComponent } from './pages/anneesUniversitaires/create-annee-universitaire/create-annee-universitaire.component';
import { AnneeUniversitaireComponent } from './pages/anneesUniversitaires/annee-universitaire/annee-universitaire.component';
import { UpdateEventrComponent } from './pages/eventr/update-eventr/update-eventr.component';
import { CreateEventrComponent } from './pages/eventr/create-eventr/create-eventr.component';
import { GetAllEventrComponent } from './pages/eventr/get-all-eventr/get-all-eventr.component';
import { UpdateNewsComponent } from './pages/news/update-news/update-news.component';
import { CreateNewsComponent } from './pages/news/create-news/create-news.component';
import { GetAllNewsComponent } from './pages/news/get-all-news/get-all-news.component';
import { EditPlaningExamComponent } from './pages/planing-exams/edit-planing-exam/edit-planing-exam.component';
import { CreatePlaningExamsComponent } from './pages/planing-exams/create-planing-exams/create-planing-exams.component';
import { PlaningExamsComponent } from './pages/planing-exams/planing-exams/planing-exams.component';
import { EditPostDocComponent } from './pages/postDoc/edit-post-doc/edit-post-doc.component';
import { CreatePostDocComponent } from './pages/postDoc/create-post-doc/create-post-doc.component';
import { PostDocsComponent } from './pages/postDoc/post-docs/post-docs.component';
import { EditPhdStudentComponent } from './pages/phdStudents/edit-phd-student/edit-phd-student.component';
import { CreatePhdStudentComponent } from './pages/phdStudents/create-phd-student/create-phd-student.component';
import { PhdStudentsComponent } from './pages/phdStudents/phd-students/phd-students.component';
import { EditProfessorComponent } from './pages/professor/edit-professor/edit-professor.component';
import { CreateProfessorComponent } from './pages/professor/create-professor/create-professor.component';
import { ProfessorsComponent } from './pages/professor/professors/professors.component';
import { AsignModuleElementComponent } from './pages/module-elements/asign-module-element/asign-module-element.component';
import { EditStudentComponent } from './pages/students/edit-student/edit-student.component';
import { createStudentComponent } from './pages/students/create-student/create-student.component';
import { StudentsComponent } from './pages/students/students/students.component';
import { EditModuleComponent } from './pages/modules/edit-module/edit-module.component';
import { CreateModuleComponent } from './pages/modules/create-module/create-module.component';
import { ModulesComponent } from './pages/modules/modules/modules.component';
import { FiliereComponent } from './pages/filieres/filiere/filiere.component';
import { CreateFiliereComponent } from './pages/filieres/create-filiere/create-filiere.component';
import { EditFiliereComponent } from './pages/filieres/edit-filiere/edit-filiere.component';
import { RecherchePublicationComponent } from './pages/publications/recherche-publication/recherche-publication.component';
import { EditPublicationComponent } from './pages/publications/edit-publication/edit-publication.component';
import { CreatePublicationComponent } from './pages/publications/create-publication/create-publication.component';
import { PublicationComponent } from './pages/publications/publication/publication.component';
import { EditGroupeComponent } from './pages/groupes/edit-groupe/edit-groupe.component';
import { CreateGroupeComponent } from './pages/groupes/create-groupe/create-groupe.component';
import { GroupesComponent } from './pages/groupes/groupes/groupes.component';
import { EditScheduleComponent } from './pages/schedules/edit-schedule/edit-schedule.component';
import { CreateScheduleComponent } from './pages/schedules/create-schedule/create-schedule.component';
import { SchedulesComponent } from './pages/schedules/schedules/schedules.component';
import { EditSectionComponent } from './pages/sections/edit-section/edit-section.component';
import { CreateSectionComponent } from './pages/sections/create-section/create-section.component';
import { SectionsComponent } from './pages/sections/sections/sections.component';
import { PdfViewComponent } from './pages/pdf-view/pdf-view.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


export const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'etablissements',
    component: EtablissementsComponent
  },
  {
    path: 'etablissements/create',
    component: CreateEtablissementComponent
  },
  {
    path: 'etablissements/edit/:id', // Corrected the placeholder syntax
    component: EditEtablissementComponent
  },

  {
    path: 'departments',
    component: DepartmentsComponent
  },
  {
    path: 'departments/create',
    component: CreateDepartmentComponent
  },
  {
    path: 'departments/edit/:id', // Corrected the placeholder syntax
    component: EditDepartmentComponent
  },
  {
    path: 'labos',
    component: LabosComponent
  },
  {
    path: 'labos/create',
    component: CreateLaboComponent
  },
  {
    path: 'labos/edit/:id', // Corrected the placeholder syntax
    component: EditLaboComponent
  },

  {
    path: 'teams',
    component: TeamsComponent
  },
  {
    path: 'teams/create',
    component: CreateTeamComponent
  },
  {
    path: 'teams/edit/:id', // Corrected the placeholder syntax
    component: EditTeamComponent
  },

  {
    path: 'recherche-axes',
    component: RechercheAxesComponent
  },
  {
    path: 'recherche-axes/create',
    component: CreateRechercheAxeComponent
  },
  {
    path: 'recherche-axes/edit/:id', // Corrected the placeholder syntax
    component: EditRechercheAxeComponent
  },

  {
    path: 'ecole-doctorales',
    component: EcoleDoctoraleComponent
  },
  {
    path: 'ecole-doctorales/create',
    component: CreateEcoleDoctoraleComponent
  },
  {
    path: 'ecole-doctorales/edit/:id', // Corrected the placeholder syntax
    component: EditEcoleDoctoraleComponent
  },
  {
    path: 'annee-universitaire',
    component: AnneeUniversitaireComponent
  },
  {
    path: 'annee-universitaire/create',
    component: CreateAnneeUniversitaireComponent
  },
  {
    path: 'annee-universitaire/edit/:id',
    component: EditAnneeUniversitaireComponent
  },
  {
    path: 'semestre',
    component: SemestreComponent
  },
  {
    path: 'semestre/create',
    component: CreateSemestreComponent
  },
  {
    path: 'semestre/edit/:id',
    component: EditSemestreComponent
  },
  {
    path: 'formation',
    component: FormationComponent
  },
  {
    path: 'formation/create',
    component: CreateFormationComponent
  },
  {
    path: 'formation/edit/:id',
    component: EditFormationComponent
  },
  {
    path: 'news/get', // Corrected the placeholder syntax
    component: GetAllNewsComponent
  },
  {
    path: 'news/create', // Corrected the placeholder syntax
    component: CreateNewsComponent
  },

  {
    path: 'news/edit/:id', // Corrected the placeholder syntax
    component: UpdateNewsComponent
  },

  {
    path: 'eventr/get', // Corrected the placeholder syntax
    component: GetAllEventrComponent
  },
  {
    path: 'eventr/create', // Corrected the placeholder syntax
    component: CreateEventrComponent
  },
  {
    path: 'eventr/edit/:id', // Corrected the placeholder syntax
    component: UpdateEventrComponent
  },
  { path: 'modules', component: ModulesComponent },
  { path: 'modules/create', component: CreateModuleComponent },
  { path: 'modules/edit/:id', component: EditModuleComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'students/create', component: createStudentComponent },
  { path: 'students/edit/:id', component: EditStudentComponent },
  { path: 'moduleElement/add/:id', component: AsignModuleElementComponent },
  { path: 'professors', component: ProfessorsComponent },
  { path: 'professors/create', component: CreateProfessorComponent },
  { path: 'professors/edit/:id', component: EditProfessorComponent },
  { path: 'phdStudents', component: PhdStudentsComponent },
  { path: 'phdStudents/create', component: CreatePhdStudentComponent },
  { path: 'phdStudents/edit/:id', component: EditPhdStudentComponent },
  { path: 'postDocs', component: PostDocsComponent },
  { path: 'postDocs/create', component: CreatePostDocComponent },
  { path: 'postDocs/edit/:id', component: EditPostDocComponent },
  { path: 'planingExams', component: PlaningExamsComponent },
  { path: 'planingExams/create', component: CreatePlaningExamsComponent },
  { path: 'planingExams/edit/:id', component: EditPlaningExamComponent },
  { path: 'filiere', component: FiliereComponent },
  { path: 'filiere/create', component: CreateFiliereComponent },
  { path: 'filiere/edit/:id', component: EditFiliereComponent },
  { path: 'publication', component: PublicationComponent },
  { path: 'publication/create', component: CreatePublicationComponent },
  { path: 'publication/edit/:id', component: EditPublicationComponent },
  { path: 'publication/recherche/:id', component: RecherchePublicationComponent },
  {
    path: 'sections',
    component: SectionsComponent
  },
  {
    path: 'sections/create',
    component: CreateSectionComponent
  },
  {
    path: 'sections/edit/:id',
    component: EditSectionComponent
  },
  {
    path: 'schedules',
    component: SchedulesComponent
  },
  {
    path: 'schedules/create',
    component: CreateScheduleComponent
  },
  {
    path: 'schedules/edit/:id',
    component: EditScheduleComponent
  },

  {
    path: 'publications',
    component: PublicationComponent
  },
  {
    path: 'publications/create',
    component: CreatePublicationComponent
  },
  {
    path: 'publications/edit/:id',
    component: EditPublicationComponent
  },
  {
    path: 'publications/recherche/:id',
    component: RecherchePublicationComponent
  },
  {
    path: 'groups',
    component: GroupesComponent
  },
  {
    path: 'groups/create',
    component: CreateGroupeComponent
  },
  {
    path: 'groups/edit/:id',
    component: EditGroupeComponent
  },
  {
    path: 'pdfView',
    component: PdfViewComponent
  }
];