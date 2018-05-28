package edu.ncwu.osums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.NoticeDao;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public int changeContent(Notice notice) {
        noticeDao.insert(notice);
        return noticeDao.updateContent(notice);
    }

    @Override
    public Notice findContent() {
        return noticeDao.selectContent();
    }
}
