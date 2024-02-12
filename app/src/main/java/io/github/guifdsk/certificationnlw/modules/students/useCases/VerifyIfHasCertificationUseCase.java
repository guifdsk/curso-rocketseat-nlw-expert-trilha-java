package io.github.guifdsk.certificationnlw.modules.students.useCases;

import io.github.guifdsk.certificationnlw.modules.students.dto.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyHasCertificationDTO dto){
        if(dto.getEmail().equals("guifdsk@outlook.com") && dto.getTechnology().equals("Java")) {
          return true;
        }
        return false;
    }
}
