package io.github.guifdsk.certificationnlw.modules.questions.controllers;

import io.github.guifdsk.certificationnlw.modules.questions.dto.AlternativesResultDTO;
import io.github.guifdsk.certificationnlw.modules.questions.dto.QuestionResultDTO;
import io.github.guifdsk.certificationnlw.modules.questions.entities.AlternativesEntity;
import io.github.guifdsk.certificationnlw.modules.questions.entities.QuestionEntity;
import io.github.guifdsk.certificationnlw.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        System.out.println("TECH === " + technology);
        var result = questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity questions){
        var questionResultDTO = QuestionResultDTO.builder()
                .description(questions.getDescription())
                .id(questions.getId())
                .technology(questions.getTechnology())
                .build();

        List<AlternativesResultDTO> alternativesResultDTOS =
                questions.getAlternatives()
                        .stream().map(alternative -> mapAlternativeDTO(alternative))
                        .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOS);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO(AlternativesEntity alternativesEntities){
        return AlternativesResultDTO.builder()
                .description(alternativesEntities.getDescription())
                .id(alternativesEntities.getId())
                .build();
    }
}
