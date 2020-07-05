package tests;

import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;

public class TestHome extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	
	private String xpathHomeTitle = "//a[text()='Home']";
	private String homeTitle = "Home";
	
	@Test
	public void testVerifyTitle() {
		menuPage.triggerHome();
		menuPage.verifyTitle(xpathHomeTitle, homeTitle);
	}
	
	

}
