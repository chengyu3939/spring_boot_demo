package com.mark.service;

import com.alibaba.fastjson.JSON;
import com.mark.handler.CreditHandler;
import com.mark.vo.CreditBasseVO;
import com.mark.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mark on 2017/9/13.
 */
@Service
public class TestService {


    Logger logger= LoggerFactory.getLogger(TestService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;


    public void exeService() {

        UserInfoVO userInfoVO=new UserInfoVO();

        userInfoVO.setName("张三");

       new CreditHandler(userService,orderService) {
            @Override
            protected void afterCreditCallBack(CreditBasseVO vo3) {


                logger.info("我在授信后 等待了10秒！");
            }

            @Override
            protected void uploadInfoCallBack(CreditBasseVO vo3) {

                UserInfoVO userInfoVO1= (UserInfoVO) vo3;
                logger.info("vo3 Content :{}", JSON.toJSONString(vo3));
                logger.info("我上传了授信所需要的信息");
            }

            @Override
            protected void preCreditCallBack(CreditBasseVO vo1) {

                logger.info("我授信前检查了授信的条件！");
            }
        }.handler(userInfoVO,userInfoVO,userInfoVO);



    }


}
