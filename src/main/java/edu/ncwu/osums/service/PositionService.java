package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.exception.ServiceException;

public interface PositionService {
    public abstract List<Position> findAll();

    public abstract Position findByPositionName(String positionName) throws ServiceException;
}
