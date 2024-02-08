package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase VerifyIfHasCertificationUseCase;
    
    //verifica se o estudante já tem o certificado daquele curso
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO VerifyHasCertificationDTO){
        System.out.println(VerifyHasCertificationDTO);

        var result = this.VerifyIfHasCertificationUseCase.execute(VerifyHasCertificationDTO);

        if (result) {
            return "usuario nao pode fazer";
        }
        return "usuario pode fazer";
    };

}
