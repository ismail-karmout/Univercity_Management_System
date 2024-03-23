
export interface Section {
  id?: number;
  name: string;
  description: string;
  slug: string;
  created_at?: string;
  updated_at?: string;
  deleted_at?: string;
  groups?:string;
  id_semestre?:number;
}
