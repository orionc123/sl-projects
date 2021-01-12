package com.hcl.service;

import com.hcl.dao.FeedbackDao;
import com.hcl.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackDao feedbackDao;

    public List<Feedback> getAllFeedback(){
        return (List<Feedback>) feedbackDao.findAll();
    }

    public boolean addFeedback(Feedback feedback){
        try{
            feedbackDao.save(feedback);
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public boolean updateFeedback(int id,String item,String description,String user){
        try{
            feedbackDao.deleteById(id);
            Feedback feedback = new Feedback(id,item,description,user);
            feedbackDao.save(feedback);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    public Feedback getFeedback(int id){
        if(feedbackDao.findById(id).isPresent()) return feedbackDao.findById(id).get();
        return null;
    }

    public void deleteFeedback(int id){
        feedbackDao.deleteById(id);
    }
}
