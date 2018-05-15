package com.mark.service;

import com.alibaba.fastjson.JSON;
import com.mark.data.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger logger= LoggerFactory.getLogger(TestService.class);

    @Autowired
    Mapper mapper;

    public void selectUserInfo(){
        System.out.println(JSON.toJSON(mapper.selectAll()));
    }
}
