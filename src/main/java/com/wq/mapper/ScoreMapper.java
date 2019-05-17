package com.wq.mapper;

import com.wq.entity.Score;
import com.wq.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository("scoreMapper")
public interface ScoreMapper {

    int insert(Score score);

    int insertSelective(Score score);

    int updateScore(Score score);

    int deleteByPrimaryKey(String[] pkids);
}