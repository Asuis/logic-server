package com.real.logicserver.quiz.repository.mongo;

import com.real.logicserver.quiz.model.mongo.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author asuis
 */
@Repository
public interface QuestionsRepository extends MongoRepository<Questions,String> {

}
