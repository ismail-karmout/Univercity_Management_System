import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { NgModule } from "@angular/core";
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { CreateEtablissementComponent } from './pages/etablissements/create-etablissement/create-etablissement.component';
import { EtablissementsComponent } from './pages/etablissements/etablissements/etablissements.component';
import { RouterModule } from "@angular/router";
import { routes } from "./app.routes";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { EditEtablissementComponent } from "./pages/etablissements/edit-etablissement/edit-etablissement.component";
import { DepartmentsComponent } from "./pages/departments/departments/departments.component";
import { EditDepartmentComponent } from "./pages/departments/edit-department/edit-department.component";
import { CreateDepartmentComponent } from "./pages/departments/create-department/create-department.component";
import { RechercheAxesComponent } from "./pages/recherche-axes/recherceh-axes/recherche-axes.component";
import { EditRechercheAxeComponent } from "./pages/recherche-axes/edit-recherche-axe/edit-recherche-axe.component";
import { CreateRechercheAxeComponent } from "./pages/recherche-axes/create-recherche-axe/create-recherche-axe.component";
import { CreateTeamComponent } from "./pages/teams/create-team/create-team.component";
import { EditTeamComponent } from "./pages/teams/edit-team/edit-team.component";
import { TeamsComponent } from "./pages/teams/teams/teams.component";
import { LabosComponent } from "./pages/labos/labos/labos.component";
import { CreateLaboComponent } from "./pages/labos/create-labo/create-labo.component";
import { EditLaboComponent } from "./pages/labos/edit-labo/edit-labo.component";
import { EcoleDoctoraleComponent } from "./pages/ecole-doctorale/ecole-doctorale/ecole-doctorale.component";
import { EditEcoleDoctoraleComponent } from "./pages/ecole-doctorale/edit-ecole-doctorale/edit-ecole-doctorale.component";
import { CreateEcoleDoctoraleComponent } from "./pages/ecole-doctorale/create-ecole-doctorale/create-ecole-doctorale.component";
import { SemestreComponent } from "./pages/semestres/semestre/semestre.component";
import { CreateSemestreComponent } from "./pages/semestres/create-semestre/create-semestre.component";
import { EditSemestreComponent } from "./pages/semestres/edit-semestre/edit-semestre.component";
import { FormationComponent } from "./pages/formations/formation/formation.component";
import { EditFormationComponent } from "./pages/formations/edit-formation/edit-formation.component";
import { CreateFormationComponent } from "./pages/formations/create-formation/create-formation.component";
import { CreateAnneeUniversitaireComponent } from "./pages/anneesUniversitaires/create-annee-universitaire/create-annee-universitaire.component";
import { EditAnneeUniversitaireComponent } from "./pages/anneesUniversitaires/edit-annee-universitaire/edit-annee-universitaire.component";
import { AnneeUniversitaireComponent } from "./pages/anneesUniversitaires/annee-universitaire/annee-universitaire.component";
import { CreateEventrComponent } from "./pages/eventr/create-eventr/create-eventr.component";
import { GetAllEventrComponent } from "./pages/eventr/get-all-eventr/get-all-eventr.component";
import { UpdateEventrComponent } from "./pages/eventr/update-eventr/update-eventr.component";
import { CreateNewsComponent } from "./pages/news/create-news/create-news.component";
import { UpdateNewsComponent } from "./pages/news/update-news/update-news.component";
import { GetAllNewsComponent } from "./pages/news/get-all-news/get-all-news.component";
import { MatGridListModule } from '@angular/material/grid-list';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { EditPlaningExamComponent } from "./pages/planing-exams/edit-planing-exam/edit-planing-exam.component";
import { PlaningExamsComponent } from "./pages/planing-exams/planing-exams/planing-exams.component";
import { EditPostDocComponent } from "./pages/postDoc/edit-post-doc/edit-post-doc.component";
import { CreatePostDocComponent } from "./pages/postDoc/create-post-doc/create-post-doc.component";
import { PostDocsComponent } from "./pages/postDoc/post-docs/post-docs.component";
import { EditPhdStudentComponent } from "./pages/phdStudents/edit-phd-student/edit-phd-student.component";
import { CreatePhdStudentComponent } from "./pages/phdStudents/create-phd-student/create-phd-student.component";
import { PhdStudentsComponent } from "./pages/phdStudents/phd-students/phd-students.component";
import { EditProfessorComponent } from "./pages/professor/edit-professor/edit-professor.component";
import { CreateProfessorComponent } from "./pages/professor/create-professor/create-professor.component";
import { ProfessorsComponent } from "./pages/professor/professors/professors.component";
import { AsignModuleElementComponent } from "./pages/module-elements/asign-module-element/asign-module-element.component";
import { createStudentComponent } from "./pages/students/create-student/create-student.component";
import { EditStudentComponent } from "./pages/students/edit-student/edit-student.component";
import { StudentsComponent } from "./pages/students/students/students.component";
import { EditModuleComponent } from "./pages/modules/edit-module/edit-module.component";
import { ModulesComponent } from "./pages/modules/modules/modules.component";
import { CreateModuleComponent } from "./pages/modules/create-module/create-module.component";
import { CreatePlaningExamsComponent } from "./pages/planing-exams/create-planing-exams/create-planing-exams.component";
import { FiliereComponent } from "./pages/filieres/filiere/filiere.component";
import { CreateFiliereComponent } from "./pages/filieres/create-filiere/create-filiere.component";
import { EditFiliereComponent } from "./pages/filieres/edit-filiere/edit-filiere.component";
import { IncludesComponent } from './includes/includes/includes.component';
import { PublicationComponent } from "./pages/publications/publication/publication.component";
import { CreatePublicationComponent } from "./pages/publications/create-publication/create-publication.component";
import { EditPublicationComponent } from "./pages/publications/edit-publication/edit-publication.component";
import { SectionService } from "./services/section.service";
import { SectionsComponent } from "./pages/sections/sections/sections.component";
import { CreateSectionComponent } from "./pages/sections/create-section/create-section.component";
import { GroupesComponent } from "./pages/groupes/groupes/groupes.component";
import { EditGroupeComponent } from "./pages/groupes/edit-groupe/edit-groupe.component";
import { CreateGroupeComponent } from "./pages/groupes/create-groupe/create-groupe.component";
import { SchedulesComponent } from "./pages/schedules/schedules/schedules.component";
import { EditScheduleComponent } from "./pages/schedules/edit-schedule/edit-schedule.component";
import { CreateScheduleComponent } from "./pages/schedules/create-schedule/create-schedule.component";
import { EditSectionComponent } from "./pages/sections/edit-section/edit-section.component";
import { PdfViewComponent } from "./pages/pdf-view/pdf-view.component";
import { DashboardComponent } from "./pages/dashboard/dashboard.component";

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        SidebarComponent,
        FooterComponent,
        CreateEtablissementComponent,
        EtablissementsComponent,
        EditEtablissementComponent,
        DepartmentsComponent,
        EditDepartmentComponent,
        CreateDepartmentComponent,
        RechercheAxesComponent,
        EditRechercheAxeComponent,
        CreateRechercheAxeComponent,
        CreateTeamComponent,
        EditTeamComponent,
        TeamsComponent,
        LabosComponent,
        CreateLaboComponent,
        EditLaboComponent,
        EcoleDoctoraleComponent,
        EditEcoleDoctoraleComponent,
        CreateEcoleDoctoraleComponent,
        SemestreComponent,
        CreateSemestreComponent,
        EditSemestreComponent,
        FormationComponent,
        EditFormationComponent,
        CreateFormationComponent,
        CreateAnneeUniversitaireComponent,
        EditAnneeUniversitaireComponent,
        AnneeUniversitaireComponent,
        CreateEventrComponent,
        GetAllEventrComponent,
        UpdateEventrComponent,
        CreateNewsComponent,
        UpdateNewsComponent,
        GetAllNewsComponent,
        ModulesComponent,
        EditModuleComponent,
        CreateModuleComponent,
        StudentsComponent,
        EditStudentComponent,
        createStudentComponent,
        AsignModuleElementComponent,
        ProfessorsComponent,
        CreateProfessorComponent,
        EditProfessorComponent,
        PhdStudentsComponent,
        CreatePhdStudentComponent,
        EditPhdStudentComponent,
        PostDocsComponent,
        CreatePostDocComponent,
        EditPostDocComponent,
        PlaningExamsComponent,
        CreatePlaningExamsComponent,
        EditPlaningExamComponent,
        CreateProfessorComponent,
        FiliereComponent,
        CreateFiliereComponent,
        EditFiliereComponent,
        IncludesComponent,
        PublicationComponent,
        CreatePublicationComponent,
        EditPublicationComponent,
        SectionsComponent,
        CreateSectionComponent,
        EditSectionComponent,
        GroupesComponent,
        EditGroupeComponent,
        CreateGroupeComponent,
        SchedulesComponent,
        EditScheduleComponent,
        CreateScheduleComponent,
        PdfViewComponent,
        DashboardComponent
    ],
    
    imports: [
        RouterModule.forRoot(routes),
        BrowserModule,
        HttpClientModule,
        FormsModule,
        MatGridListModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatInputModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        ReactiveFormsModule
    ],
    providers: [

    ],
    bootstrap: [
        AppComponent
    ]

})

export class AppModule { }