package com.game.royal.service;

import com.game.royal.mapper.EduXlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private EduXlMapper eduXlMapper;

    public String test() {
        return eduXlMapper.selectList(null).get(0).getBh();
    }
}
