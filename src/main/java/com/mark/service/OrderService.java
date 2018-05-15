package com.mark.service;

import com.mark.handler.CreditHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    Logger logger= LoggerFactory.getLogger(CreditHandler.class);

    public void createOrderService(){

        logger.info("创建订单");
    }

}
