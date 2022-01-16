package com.example.chapter3.study;

import com.example.chapter3.domain.Study;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class StudyRepositoryTest {

    @Autowired
    StudyRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @DisplayName("Repository 테스트")
    @Test
    void save() {
        Study study = new Study(10, "Java");
        repository.save(study);
        List<Study> all = repository.findAll();
        assertEquals(1, all.size());
    }

}