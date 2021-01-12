package com.hcl.controller;

import com.hcl.model.Feedback;
import com.hcl.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/main")
public class Main {
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/add-feedback")
    public ModelAndView createFeedback() {
        Feedback feedback = new Feedback();
        return new ModelAndView("addFeedback", "newFeedback", feedback);
    }

    @PostMapping("/add-feedback")
    public ModelAndView addFeedback(@RequestParam("item") String item, @RequestParam("description") String description, @RequestParam("user") String user) {
        Feedback feedback = new Feedback();
        feedback.setItem(item);
        feedback.setDescription(description);
        feedback.setUser(user);

        if (feedbackService.addFeedback(feedback)) {
            return new ModelAndView("allFeedback", "feedbackList", feedbackService.getAllFeedback());
        } else {
            return new ModelAndView("error", "errorMessage","Error: feedback not added.");
        }
    }

    @GetMapping("/list-feedback")
    public ModelAndView listFeedback() {
        return new ModelAndView("allFeedback", "feedbackList", feedbackService.getAllFeedback());
    }

    @GetMapping("/edit-feedback/{id}")
    public ModelAndView editFeedback(@PathVariable("id") int id) {
        Feedback feedback = feedbackService.getFeedback(id);
        if(feedback!=null) return new ModelAndView("editFeedback","feedback",feedback);
        return new ModelAndView("error","errorMessage","Error: feedback could not be found.");
    }

    @PostMapping("/edit-feedback/{id}")
    public ModelAndView editFeedback(@PathVariable("id")int id, @RequestParam("item") String item, @RequestParam("description") String description, @RequestParam("user") String user) {
        if(feedbackService.updateFeedback(id,item,description,user)){
            return new ModelAndView("allFeedback","feedbackList",feedbackService.getAllFeedback());
        }
        return new ModelAndView("error","errorMessage","Error: feedback not edited.");
    }

    @GetMapping("/delete-feedback/{id}")
    public ModelAndView deleteFeedback(@PathVariable("id") int id) {
        feedbackService.deleteFeedback(id);
        return new ModelAndView("allFeedback","feedbackList",feedbackService.getAllFeedback());
    }

}
