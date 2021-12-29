package com.springproject.SpringTriviaApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproject.SpringTriviaApp.entity.CategoryEntity;
import com.springproject.SpringTriviaApp.entity.QuestionEntity;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TriviaApiConnectionService {

    @Autowired
    RestTemplate restTemplate;

    private final String GET_CATEGORIES_URI = "https://opentdb.com/api_category.php";
    private final String GET_QUESTIONS_URI = "https://opentdb.com/api.php";

    public List<CategoryEntity> getAllCategories() throws JsonProcessingException {
        JSONObject response = restTemplate.getForObject(GET_CATEGORIES_URI, JSONObject.class);

        ObjectMapper mapper = new ObjectMapper();
        List<CategoryEntity> category_lst = mapper.convertValue(response.get("trivia_categories"), new TypeReference<List<CategoryEntity>>(){});

        return category_lst;
    }

    public List<QuestionEntity> getFullQuestionList(int category_id, int player_num) throws JsonProcessingException {

        List<QuestionEntity> easyQuestions = getQuestionList(category_id, "easy", "multiple", 3*player_num);
        List<QuestionEntity> mediumQuestions = getQuestionList(category_id, "medium", "multiple", 1*player_num);
        List<QuestionEntity> hardQuestions = getQuestionList(category_id, "hard", "multiple", 1*player_num);

        List<QuestionEntity> allQuestions = Stream.of(easyQuestions, mediumQuestions, hardQuestions)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        return allQuestions;
    }

    private List<QuestionEntity> getQuestionList(int category_id, String difficulty, String type, int amount){
        URI targetUrl= UriComponentsBuilder.fromUriString(GET_QUESTIONS_URI)  // Build the base link
                .queryParam("category", category_id)
                .queryParam("difficulty", difficulty)
                .queryParam("type", type)
                .queryParam("amount", amount)
                .build()
                .encode()
                .toUri();

        JSONObject response = restTemplate.getForObject(targetUrl, JSONObject.class);

        ObjectMapper mapper = new ObjectMapper();
        List<QuestionEntity> question_lst = mapper.convertValue(response.get("results"), new TypeReference<List<QuestionEntity>>(){});

        return question_lst;
    }
}
