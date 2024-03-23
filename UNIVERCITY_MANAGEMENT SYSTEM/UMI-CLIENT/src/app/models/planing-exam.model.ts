import { Exam } from "./exam.model"
import { Semestre } from "./semestre.module"

export interface PlaningExam {
    id: number
    avis: string
    planing: string
    semestreId: number
    semestre: Semestre
    exam: Exam[]
}