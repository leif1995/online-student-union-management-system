package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Indexs;

public interface IndexsService {
    public abstract int create(Indexs indexs);

    public abstract int removeById(int id);

    public abstract int changeStatusForPassById(int id, String updatedTime, String updatedBy);

    public abstract int changeAttachmentById(int id, String attachment, String suffix);

    public abstract Indexs findLastId();

    public abstract Indexs findById(int id);

    public abstract List<Indexs> findNewsCenterTopThree();

    public abstract List<Indexs> findNewsCenter(String newsCenterSearch);

    public abstract List<Indexs> findOrganizationStructure(String organizationStructureSearch);

    public abstract List<Indexs> findNoticeBoard(String noticeBoardSearch);

    public abstract List<Indexs> findAll(String search, int currentPage);

    public abstract int findAllCount(String search);
}
