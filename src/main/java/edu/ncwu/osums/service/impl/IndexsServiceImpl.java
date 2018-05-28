package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.IndexsDao;
import edu.ncwu.osums.entity.Indexs;
import edu.ncwu.osums.service.IndexsService;

@Service
public class IndexsServiceImpl implements IndexsService {
    @Autowired
    private IndexsDao indexsDao;

    @Override
    public int create(Indexs indexs) {
        return indexsDao.insert(indexs);
    }

    @Override
    public int removeById(int id) {
        return indexsDao.deleteById(id);
    }

    @Override
    public int changeStatusForPassById(int id, String updatedTime, String updatedBy) {
        return indexsDao.updateStatusForPassById(id, updatedTime, updatedBy);
    }

    @Override
    public int changeAttachmentById(int id, String attachment, String suffix) {
        return indexsDao.updateAttachmentById(id, attachment, suffix);
    }

    @Override
    public Indexs findLastId() {
        return indexsDao.selectLastId();
    }

    @Override
    public Indexs findById(int id) {
        return indexsDao.selectById(id);
    }

    @Override
    public List<Indexs> findNewsCenterTopThree() {
        return indexsDao.selectNewsCenterTopThree();
    }

    @Override
    public List<Indexs> findNewsCenter(String newsCenterSearch) {
        return indexsDao.selectNewsCenter(newsCenterSearch);
    }

    @Override
    public List<Indexs> findOrganizationStructure(String organizationStructureSearch) {
        return indexsDao.selectOrganizationStructure(organizationStructureSearch);
    }

    @Override
    public List<Indexs> findNoticeBoard(String noticeBoardSearch) {
        return indexsDao.selectNoticeBoard(noticeBoardSearch);
    }

    @Override
    public List<Indexs> findAll(String search, int currentPage) {
        return indexsDao.selectAll(search, currentPage);
    }

    @Override
    public int findAllCount(String search) {
        return indexsDao.selectAllCount(search);
    }
}
