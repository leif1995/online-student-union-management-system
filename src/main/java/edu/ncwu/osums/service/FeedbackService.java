package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Feedback;

public interface FeedbackService {
    public abstract int create(Feedback feedback);

    public abstract int removeById(int id);

    public abstract List<Feedback> findAll();

    public abstract int findCount();

    public abstract int findCountByType(String type);
}
