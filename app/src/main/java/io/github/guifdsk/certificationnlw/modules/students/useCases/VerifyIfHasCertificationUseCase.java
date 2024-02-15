package io.github.guifdsk.certificationnlw.modules.students.useCases;

import io.github.guifdsk.certificationnlw.modules.students.dto.VerifyHasCertificationDTO;
import io.github.guifdsk.certificationnlw.modules.students.entities.CertificationStudentEntity;
import io.github.guifdsk.certificationnlw.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyHasCertificationDTO dto){

        var result = certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),
                dto.getTechnology());

        if(!result.isEmpty()) {
          return true;
        }
        return false;
    }
}
