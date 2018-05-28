package edu.ncwu.osums.service;

import edu.ncwu.osums.entity.Notice;

public interface NoticeService {
    public abstract int changeContent(Notice notice);

    public abstract Notice findContent();
}
