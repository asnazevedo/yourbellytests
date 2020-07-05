package pages;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MenuPage extends BasePage {
	
	
	public void triggerMenuAccounts() {
		clickLink("Contas");
	}
	
	
	public void triggerAddAccount() {
		triggerMenuAccounts();
		clickLink("Adicionar");
		
	}
	
	public void triggerMenuListAccount() {
		triggerMenuAccounts();
		clickLink("Listar");
	}
	
	public void triggerMenuCreateFinancialMovement() {
		clickLink("Criar Movimentação");
	}
	
	public void triggerHome() {
		clickLink("Home");
	}
	
	public void  triggerMonthlySummary() {
		clickLink("Resumo Mensal");
	}
	
	public void trigguerExit() {
		clickLink("Sair");
	}
	
	public void verifyTitle(String xpath,String text) {
		assertEquals(text,getDriver().findElement(By.xpath(xpath)).getText());
	}


	public void verifyAccountBalance() {
		WebElement saldo = getTableCell("Conta", "Conta 1A", "Saldo", "tabelaSaldo");
		assertEquals("3000.00",saldo.getText());
		System.out.println("saldo = "+saldo.getText());
		
	}
	
	

}
