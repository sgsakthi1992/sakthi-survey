package com.springboot.practice.controller;

import com.springboot.practice.model.Question;
import com.springboot.practice.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<List<Question>> retrieveQuestions(@PathVariable String surveyId) {
        List<Question> questions = surveyService.retrieveQuestions(surveyId);
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Question> retrieveQuestion(@PathVariable String surveyId,
                                                     @PathVariable String questionId) {
        Question question = surveyService.retrieveQuestion(surveyId, questionId);
        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity addQuestion(@PathVariable String surveyId,
                                      @RequestBody Question question){
        Question addedQuestion = surveyService.addQuestion(surveyId, question);
        return ResponseEntity.status(HttpStatus.OK).body(addedQuestion);
    }
}
