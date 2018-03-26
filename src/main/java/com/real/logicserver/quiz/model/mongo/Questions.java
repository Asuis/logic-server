package com.real.logicserver.quiz.model.mongo;

import org.bson.BSON;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * @author asuis
 */
public class Questions {
    @Id
    private BSON _id;
    private List<Question> questions;
    private Date date;
}
