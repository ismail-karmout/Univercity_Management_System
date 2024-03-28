package com.umi.recherche.ecoledoctorale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoleDoctoraleApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcoleDoctoraleApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner initData(EcoleDoctoraleService ecoleDoctoraleService) {
        return args -> {
            // Create and save an example department when the application starts
            EcoleDoctoraleDTO ecoleDoctoraleDTO = new EcoleDoctoraleDTO();
            ecoleDoctoraleDTO.setName("Example 1");
            ecoleDoctoraleDTO.setDescription("This is an example Ecole Doctorale 1.");
            ecoleDoctoraleDTO.setSlug("example-EcoleDoctorale");

            ecoleDoctoraleService.createEcoleDoctorale(ecoleDoctoraleDTO);
        };
    }*/
}
