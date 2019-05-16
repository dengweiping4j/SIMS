package com.wq.mapper;

import com.wq.entity.Score;
import org.springframework.stereotype.Repository;

@Repository("scoreMapper")
public interface ScoreMapper {

    int insert(Score record);

    int insertSelective(Score record);
}