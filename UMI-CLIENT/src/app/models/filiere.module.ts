 

export interface Filiere{
  id?: number;
  name: string;
  nbAnnees: number;
  nbSemestres: number; 
  responsable: string;
  anneeDiplomante: string;
  anneesNonDiplomantes:string;
  slug:string;
  department_id :number;
  createdAt?: string;
  updatedAt?: string; 
  
}
