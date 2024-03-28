package com.umi.researcherservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@DiscriminatorValue("phd_student")
//@Table(name = "phd_student")
public class PhdStudent extends Researcher{
}
