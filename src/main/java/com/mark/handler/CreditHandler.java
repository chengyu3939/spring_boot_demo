package com.mark.handler;

import com.mark.service.OrderService;
import com.mark.service.UserService;
import com.mark.vo.CreditBasseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CreditHandler {

    Logger logger= LoggerFactory.getLogger(CreditHandler.class);


    private UserService userService;
    private OrderService orderService;


    public CreditHandler(UserService userService,OrderService orderService) {
        this.userService=userService;
        this.orderService=orderService;
    }

    public void handler(CreditBasseVO vo1,CreditBasseVO vo2,CreditBasseVO vo3) {
        preCreditCallBack(vo1);
        creditCreditOrder();
        uploadInfoCallBack(vo2);
        doCredit();
        afterCreditCallBack(vo3);
        ResultHandler();
    }


    public void handler_zmxu(){



    }
    protected abstract void afterCreditCallBack(CreditBasseVO vo3);

    private void ResultHandler() {
        userService.selectUserInfo();
        logger.info("我要把结果放到数据库");
    }

    private void doCredit() {
        logger.info("我去授信了！");
    }

    protected abstract void uploadInfoCallBack(CreditBasseVO userInfoVO);

    private void creditCreditOrder() {
        orderService.createOrderService();
        logger.info("系统生成了授信单号");
    }

    protected abstract void preCreditCallBack(CreditBasseVO vo1);


}
