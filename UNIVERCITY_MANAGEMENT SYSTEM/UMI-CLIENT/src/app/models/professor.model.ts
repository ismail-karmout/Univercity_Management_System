import { Labo } from "./labo.module"
import { ProfessorRole } from "./professor-role.model"
import { Role } from "./role.model"
import { Team } from "./team.module"

export interface Professor {
    id: number
    firstname: string
    lastname: string
    email: string
    phone: string
    laboId: number;
    labo: Labo;
    teamId: number;
    team: Team;
    speciality: string
    professorRoles: ProfessorRole[]
}