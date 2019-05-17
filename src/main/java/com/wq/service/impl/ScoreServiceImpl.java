package com.wq.service.impl;

import com.wq.entity.Score;
import com.wq.mapper.ScoreMapper;
import com.wq.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by dengweiping on 2019/5/17.
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public int updateScore(Score score) {
        return scoreMapper.updateScore(score);
    }

    @Override
    public int addScore(Score score) {
        score.setPkid(UUID.randomUUID().toString());
        return scoreMapper.insert(score);
    }

    @Override
    public int deleteScore(String[] pkids) {
        return scoreMapper.deleteByPrimaryKey(pkids);
    }
}
