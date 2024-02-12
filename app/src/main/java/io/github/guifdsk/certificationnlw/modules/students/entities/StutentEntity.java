package io.github.guifdsk.certificationnlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StutentEntity {

    private UUID id;
    private String email;
    private List<CertificationStudentEntity> certificationStudentEntity;
}
