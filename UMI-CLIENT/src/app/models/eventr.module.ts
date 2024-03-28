import { FileHandle } from "./file-handel.model";
export interface Eventr {
    id?: number;
    responsableId?: number;
    intitule: string;
    justificatif: string;
    date: string;
    type : string;
    lieu: string;
    description: string;
    eventrImages: FileHandle[];
    image?: string;
    created_at?: string;
    updated_at?: string;
    lab_id?:string;
  }
  