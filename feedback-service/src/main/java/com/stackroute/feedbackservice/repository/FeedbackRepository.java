package com.stackroute.feedbackservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.feedbackservice.entity.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback,String>{

}
