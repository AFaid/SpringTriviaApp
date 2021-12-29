package com.springproject.SpringTriviaApp.repository;

import com.springproject.SpringTriviaApp.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    @Query("SELECT r.id FROM CategoryEntity r where r.name = :name")
    List<Integer> findIdByName(@Param("name") String name);

}
