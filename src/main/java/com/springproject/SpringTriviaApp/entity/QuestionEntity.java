package com.springproject.SpringTriviaApp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "category")
    private String category;
    @Column(name = "type")
    private String type;
    @Column(name = "difficulty")
    private String difficulty;
    @Column(name = "question")
    private String question;
    @Column(name = "correct_answer")
    private String correct_answer;

    @ElementCollection
    @CollectionTable(name="incorrect_answers")
    private List<String> incorrect_answers;

    public QuestionEntity() {
    }

    public QuestionEntity(int id, String category, String type, String difficulty, String question, String correct_answer,
                          List<String> incorrect_answers) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", correct_answer='" + correct_answer + '\'' +
                ", incorrect_answers=" + incorrect_answers +
                '}';
    }
}
