package com.springproject.SpringTriviaApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springproject.SpringTriviaApp.entity.QuestionEntity;
import com.springproject.SpringTriviaApp.repository.QuestionRepository;
import com.springproject.SpringTriviaApp.service.TriviaApiConnectionService;
import com.springproject.SpringTriviaApp.entity.CategoryEntity;
import com.springproject.SpringTriviaApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    TriviaApiConnectionService apiConnection;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomepage(ModelMap model) throws JsonProcessingException {

        clearQuestionData();

        List<CategoryEntity> category_lst = apiConnection.getAllCategories();
        categoryRepository.saveAll(category_lst);

        model.put("category_lst", category_lst);
        return "homepage";
    }

    private void clearQuestionData() {
        questionRepository.deleteAll();
    }

    @RequestMapping(value = "/", params = {"player_num", "category1", "category2", "category3"}, method = RequestMethod.POST)
    public String newGameSetup(ModelMap model, @RequestParam int player_num, @RequestParam String category1,
                               @RequestParam String category2, @RequestParam String category3) throws JsonProcessingException {

        int[] category_ids = {categoryRepository.findIdByName(category1).get(0), categoryRepository.findIdByName(category2).get(0),
                categoryRepository.findIdByName(category3).get(0)};

        for(int category_id:category_ids) {
            List<QuestionEntity> question_lst = apiConnection.getFullQuestionList(category_id, player_num);
            questionRepository.saveAll(question_lst);
        }

        model.put("player_num", player_num);
        return "playerCreation";
    }

}
