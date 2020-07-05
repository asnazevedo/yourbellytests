package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.BasePage;

public class ListAccountsPage extends BasePage {

	public void verifyAccountRegisterSucessMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-success']")));
	}
	
	public void verifyAccountRegisterErrorMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-danger']")));
	}
	
	
	public void verifyAccountOnList(String msg, String searchedColumn, String buttonColumn, String idTable) {
		Assert.assertEquals(msg,getTableCell(searchedColumn, msg, buttonColumn, idTable).getText());
	}
	
	public void triggerAlterAccount(String conta) {
		clickTableCellButton("Conta",conta,"Ações","tabelaContas",".//span[@class='glyphicon glyphicon-edit']");
	}
}
