package com.springproject.SpringTriviaApp.game;

import com.springproject.SpringTriviaApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class QuestionHandler {

    @Autowired
    QuestionRepository questionRepository;

    private int current_question_id = 1;

    public String getQuestion(){
        return questionRepository.getById(this.current_question_id).getQuestion();
    }

    public String getQuestionCorrectAnswer(){
        return questionRepository.getById(this.current_question_id).getCorrect_answer();
    }

    public List<String> getQuestionAnswers(){
         List<String> choices = questionRepository.getById(current_question_id).getIncorrect_answers();
         choices.add(questionRepository.getById(current_question_id).getCorrect_answer());
         Collections.shuffle(choices);
         return choices;
    }

    public String getQuestionDifficulty(){
        return questionRepository.getById(current_question_id).getDifficulty();
    }

    public String getQuestionCategory(){
        return questionRepository.getById(current_question_id).getCategory();
    }

    public void nextQuestion(){
        this.current_question_id += 1;
    }

    public boolean isCorrectAnswer(String answer){
        return answer.equals(getQuestionCorrectAnswer());
    }
}
