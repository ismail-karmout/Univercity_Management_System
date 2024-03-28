import { Etablissement } from "./etablissement.module";

export interface Department {
  id?: number;
  name: string;
  description: string;
  slug: string;
  etablissement: Etablissement; // Make it optional
  created_at?: string;
  updated_at?: string;
  deleted_at?: string;
}
