import { AnneeUniversitaire } from "./anneeUniversitaire.module";

export interface Semestre{
  id?: number;
  name: string;
  idAcademicYear: number;
  session: string; 
  typeSession: string;
  idFiliere: number;
  createdAt?: string;
  updatedAt?: string; 
}
