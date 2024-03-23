export interface Publication{
    id?: number;
    type: string;
    titre: string;
    auteurId: number;
    anneeUniversitaireId: number;
    equipeId: number;
    laboId: number;
    etat: string;
    justificatif: string;
    createdAt?: string;
    updatedAt?: string;
     
  }