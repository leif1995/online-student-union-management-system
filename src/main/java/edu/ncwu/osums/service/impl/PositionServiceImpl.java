package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.PositionDao;
import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.exception.ServiceException;
import edu.ncwu.osums.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> findAll() {
        return positionDao.selectAll();
    }

    @Override
    public Position findByPositionName(String positionName) throws ServiceException {
        Position position = positionDao.selectByPositionName(positionName);

        if (position == null) {
            throw new ServiceException("数据库职务名出错！");
        }

        return position;
    }
}
