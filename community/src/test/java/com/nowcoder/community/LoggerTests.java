package com.nowcoder.community;


import com.nowcoder.community.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {

   //实例化记录日志的组件
    private static final Logger logger  = LoggerFactory.getLogger(LoggerTests.class);



     @Test
    public  void TestLogger(){
         System.out.println(logger.getName());
         logger.debug("debug log");
         logger.info("info log");
         logger.warn("warn log");
         logger.error("error log");
     }





}
