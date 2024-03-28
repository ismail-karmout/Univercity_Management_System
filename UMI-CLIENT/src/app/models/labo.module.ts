import { RechercheAxe } from "./recherche-axe.module";

export interface Labo {
  id?: number;
  acroname: string;
  title: string;
  slug: string;
  created_at?: string;
  updated_at?: string;
  deleted_at?: string;
  department_id?: number;
  labo?: { id: number };
  rechercheAxes?: RechercheAxe[];
  ecole_doctorale_id?: number;
}