package org.next;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import core.JunnieJobsBlogApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JunnieJobsBlogApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class JunitTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Test
	public void getHome() {
		
		RestTemplate rt = new TestRestTemplate();
		String result = rt.getForObject("http://localhost:" + port, String.class);
		System.out.println(result);
	}

}
