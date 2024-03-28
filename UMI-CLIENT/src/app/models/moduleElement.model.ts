import { Module } from "./module.model";
import { Professor } from "./professor.model";

export interface ModuleElement{
    id: number,
    name: string,
    slug: string,
    professor: Professor,
    module: Module
}

