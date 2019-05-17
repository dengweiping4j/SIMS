package com.wq.service;

import com.wq.entity.Score;

public interface ScoreService {

    int updateScore(Score score);

    int addScore(Score score);

    int deleteScore(String[] pkids);

}
