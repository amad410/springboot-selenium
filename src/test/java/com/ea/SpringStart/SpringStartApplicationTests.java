package com.ea.SpringStart;

import com.ea.SpringStart.pages.GoogleHomePage;
import com.ea.SpringStart.pages.GoogleResultsPage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringStartApplication.class)
@Profile("qa")
class SpringStartApplicationTests {

	@Autowired
	private GoogleHomePage googlHomePage;

	@Autowired
	private GoogleResultsPage googleResultsPage;

	@Value("${app.url}")
	private String appUrl;

	@Value("chrome,firefox,edge")
	private List<String> browsers;

	@Value("testing")
	private String environment;

	@Test
	void GoogleSearch() throws InterruptedException {
		System.out.println(appUrl);
		googlHomePage.Navigate(appUrl);
		googlHomePage.Search("Selenium");
		googleResultsPage.IsResultsFoundContaining();
	}

	@Test
	@Profile("!qa")
	void contextLoads() {
		System.out.println(appUrl);

	}

}
