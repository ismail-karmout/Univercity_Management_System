import {Section} from "./section.module";

export interface Groupe {
  id?: number;
  name: string;
  description: string;
  slug: string;
  created_at?: string;
  updated_at?: string;
  deleted_at?: string;
  section:Section;
}
