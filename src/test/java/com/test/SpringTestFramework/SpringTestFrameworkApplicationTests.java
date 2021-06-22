package com.test.SpringTestFramework;

import com.test.SpringTestFramework.Pages.GoogleHomePage;
import com.test.SpringTestFramework.Pages.GoogleSearchResultPage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringTestFrameworkApplication.class)
@Profile("qa")
@TestPropertySource(locations = {"classpath:application-qa.properties"})
class SpringTestFrameworkApplicationTests {


	@Autowired
	private GoogleHomePage homePage;

	@Autowired
	private GoogleSearchResultPage resultsPage;

	@Value("${app.url}")
	private String appUrl;

	@Value("chrome,firefox,edge")
	private List<String> browsers;

	@Value("testing")
	private String environment;

	@Test
	void GoogleSearch() throws InterruptedException {
		System.out.println(appUrl);
		homePage.Navigate(appUrl);
		homePage.Search("Selenium");
		resultsPage.IsResultsFoundContaining();
	}

	@Test
	@Profile("!qa")
	void contextLoads() {
		System.out.println(appUrl);

	}

}
