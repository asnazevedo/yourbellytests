package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class MonthlySummaryPage extends BasePage {
	
	
	public void selectMonthToList(String id, String monthToSelect) {
		selectCombo(id, monthToSelect);
	}
	
	public void selectYearToList(String id, String yearToSelect) {
		selectCombo(id, yearToSelect);
	}
	
	public void triggerSearch(By by) {
		clickButton(by);
	}
	
	public void triggerRemoveMovement(String value) {
		By byBuscar  = By.xpath("//input[@value='Buscar']");
		selectMonthToList("mes", "Julho");
		selectYearToList("ano", "2020");
		triggerSearch(byBuscar);
		clickTableCellButton("Descrição",value, "Ações", "tabelaExtrato","//*[@id='tabelaExtrato']/tbody/tr[contains(.,'"+value+"')]/td[6]/a");
	}


	public void verifyMovementRegisterSucessMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-success']")));	
	}
	
	public void verifyMovementRegisterErrorMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-error']")));	
	}
	
}
