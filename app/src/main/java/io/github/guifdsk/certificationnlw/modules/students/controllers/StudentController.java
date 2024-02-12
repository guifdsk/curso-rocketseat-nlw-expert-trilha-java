package io.github.guifdsk.certificationnlw.modules.students.controllers;

import io.github.guifdsk.certificationnlw.modules.students.dto.VerifyHasCertificationDTO;
import io.github.guifdsk.certificationnlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
//@RequiredArgsConstructor
public class StudentController {
    
/*  private final VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    utilização com notação @RequiredArgsConstructor do Lombok para injeção de dependência*/

/*  @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    Utilizando notação Spring @Autowired para injeção de dependência*/

    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    /*utilizando construtor para injeção de dependência*/
    public StudentController(VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase) {
        this.verifyIfHasCertificationUseCase = verifyIfHasCertificationUseCase;
    }

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {

        boolean result = verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if (result){
            return "Usuário já fez a prova";
        }
        return "Usuário pode fazer a prova";
    }
}
