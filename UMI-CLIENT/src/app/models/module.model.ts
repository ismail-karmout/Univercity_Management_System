import { ModuleElement } from "./moduleElement.model"
import { Professor } from "./professor.model"
import { Semestre } from "./semestre.module"

export interface Module {
    id: number
    name: string
    slug: string
    professorId: number
    professor?: any
    semestreId: number
    semestre?: any
    moduleElements?: any[]
  }