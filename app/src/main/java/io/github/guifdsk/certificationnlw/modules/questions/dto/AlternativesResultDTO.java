package io.github.guifdsk.certificationnlw.modules.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlternativesResultDTO {
    private UUID id;
    private String description;
}
