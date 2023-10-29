package com.stackroute.feedbackservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.feedbackservice.entity.Feedback;
import com.stackroute.feedbackservice.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> allFeedback = feedbackService.getAllFeedback();
        return new ResponseEntity<>(allFeedback, HttpStatus.OK);
    }

    @GetMapping("/get/{emailId}")
    public ResponseEntity<Feedback> getFeedbackByEmail(@PathVariable String emailId) {
        Optional<Feedback> feedback = feedbackService.getFeedbackByEmail(emailId);
        return feedback.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
