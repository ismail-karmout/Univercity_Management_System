import { Labo } from "./labo.module";
import { RechercheAxe } from "./recherche-axe.module";

export interface Team {
  id?: number;
  title: string;
  slug: string;
  created_at?: string;
  updated_at?: string;
  deleted_at?: string;
  department_id?: number;
  labo: Labo;
  rechercheAxes?: RechercheAxe[];
}