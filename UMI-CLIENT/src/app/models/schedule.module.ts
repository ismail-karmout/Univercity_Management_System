import {Section} from "./section.module";

export interface Schedule {
  id?: number;
  name: string;
  schedule: string;
  created_at?: string;
  updated_at?: string;
  section:Section;
}
