package com.example.jpacrud;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//可以在@WebAppConfiguration下加上@Transactional註解,當每次執行完測試會再將數據roll back
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JpacrudApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	MockMvc mvc;

	@Before
	public void setup(){
		//post需要的值
		/*memberaccount = new Memberaccount();
		memberaccount.setCellphone("02135121");
		memberaccount.setEmail("qewq@qwe.asd.s");
		memberaccount.setPassword("qweqqq");*/
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void contextLoads() throws Exception {
		String uri = "/jpacrud/readid/1";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		//post的用法
		//MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).content(objectMapper.writeValueAsString(memberaccount)).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		System.out.println(status);
		Assert.assertEquals("錯誤",200,status);
	}
	/*
	throws Exception :如果加上try catch錯誤訊息就會消失了,發生例外做throws例外
	uri : 我設定一個字串去存取我要測試的REST入口方法,這邊以Get方法做測試
	perform(request):此方法為要做一個請求的建立,這是一個模擬請求的方式
	get(url) : 要去request(請求)的連結
	accept: 接受何種格式回傳 我用MediaType.APPLICATION_JSON 接受以JSON格式回傳
	andReturn方法 :將結果轉換成MockMvc的型態
	status : 回傳狀態的變數
	MvcResult getResponse().getStatus() : 取回回傳狀態
	Assert(斷言測試)
	assertEquals("string",200(statusCode),status)
		第一個參數:當發生錯誤時要產生的提示文字
		第二個參數: 當返回值非第二個參數的數值時觸發
		第三個參數: 返回參數
	*/
}
