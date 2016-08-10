package com.hisuntech.ArchOnlineSchoolBack.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hisuntech.ArchOnlineSchoolBack.service.ChatService;
import com.hisuntech.ArchOnlineSchoolBack.service.SlaveService;
import com.hisuntech.ArchOnlineSchoolBack.vo.ChatVo;

/**
 * @Description：DataSourceRoutingAspectTest
 * @author：Wangzhixuan 
 * @date：2015年8月19日 下午5:23:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:springmvc-servlet.xml",
        "classpath:applicationContext.xml"
})
public class DataSourceRoutingAspectTest {

    @Autowired
    private ChatService chatService;

    @Test
    public void testFindAllShop() {
    	//最开始没有null，报错后自己添加的
    	List<ChatVo> list = chatService.getAllChatList(null);
    	
    	for (ChatVo chatVo : list){
    		System.out.println(chatVo.getName());
    	}
        
    }
}

