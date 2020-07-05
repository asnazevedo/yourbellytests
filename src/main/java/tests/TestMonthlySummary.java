package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.MonthlySummaryPage;

public class TestMonthlySummary extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MonthlySummaryPage monthlySummaryPage  = new MonthlySummaryPage();
	

	String titleMonthlySummary ="Seu Barriga - Extrato";
	
	@Test
	public void checkMonthlySummaryPageTitle() {
		menuPage.triggerMonthlySummary();
		Assert.assertEquals(titleMonthlySummary,DriverFactory.getDriver().getTitle());
	}
	
	@Test
	public void removeMovement() {
		menuPage.triggerMonthlySummary();
		monthlySummaryPage.triggerRemoveMovement("Salario");
		monthlySummaryPage.verifyMovementRegisterSucessMsg("Movimentação removida com sucesso!");		
	}
	

}
