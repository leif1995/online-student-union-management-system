package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.FeedbackDao;
import edu.ncwu.osums.entity.Feedback;
import edu.ncwu.osums.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public int create(Feedback feedback) {
        return feedbackDao.insert(feedback);
    }

    @Override
    public int removeById(int id) {
        return feedbackDao.deleteById(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackDao.selectAll();
    }

    @Override
    public int findCount() {
        return feedbackDao.selectCount();
    }

    @Override
    public int findCountByType(String type) {
        return feedbackDao.selectCountByType(type);
    }
}
