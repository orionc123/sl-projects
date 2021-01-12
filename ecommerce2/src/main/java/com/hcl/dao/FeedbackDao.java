package com.hcl.dao;

import com.hcl.model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao extends CrudRepository<Feedback,Integer> {
}
