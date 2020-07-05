package pages;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessInitialScreen() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		write("email",email);
	}
	
	public void setPassword(String senha) {
		write("senha",senha);
	}

	public void enter() {
		clickButton(By.xpath("//button[.='Entrar']")); 
	}
	
	public void Login(String email, String senha) {
		setEmail(email);
		setPassword(senha);
		enter();
	}
}
