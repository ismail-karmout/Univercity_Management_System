import { FileHandle } from "./file-handel.model";

export interface News {
    id?: number;
    title: string;
    date?: string;
    description: string;
    type: string;
    newsImages: FileHandle[];
     
    photo?: string;
    created_at?: string;
    updated_at?: string;
    department_id:{id: number}; // Make it optional
  }
  