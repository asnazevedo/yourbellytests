package pages;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.BasePage;

public class FinancialMovementPage extends BasePage {
	
	MonthlySummaryPage monthlySummaryPage = new MonthlySummaryPage();
		
	public void movement(
			String type,
			String movementDate ,
			String paymentDate,
			String description ,
			String intersted ,
			String value,
			String account,
			String status) {
		selectMovementType(type);
		setFinacialMovementDate(movementDate);
		setPaymentDate(paymentDate);
		setDescription(description);
		seIntersted(intersted);
		setValue(value);
		selectAccount(account);
		checkPaymentState(status);
		triggerSave();
	}
	
	public void selectMovementType(String type) 
	{
		switch (type)
			{
				case "Receita":
					selectCombo("tipo","Receita");
				case "Despesa":
					selectCombo("tipo","Despesa");
				default: 
					selectCombo("tipo","Receita");
			}
	}
	
	public void setFinacialMovementDate(String movementDate) {
		write("data_transacao",movementDate);
	}
	
	public void setPaymentDate(String paymentDate) {
		write("data_pagamento", paymentDate);
	}
	
	public void setDescription(String description) {
		write("descricao",description);
	}
	
	public void seIntersted(String intersted) {
		write("interessado",intersted);
	}
	
	public void setValue(String value) {
		write("valor",value); 
	}
	
	public void selectAccount(String account) {
		selectCombo("conta",account);
	}
	
	public void checkPaymentState(String status) {
		
			if (status == "Pendente"){ 
				clickRadio("status_pendente");
			}else 
				if( status == "Pago") {
					clickRadio("status_pago");
			}
		
	}
	
	public void triggerSave() {
		clickButton(By.xpath("//button[.='Salvar']"));
	}

	public void verifyMovementRegisterSucessMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-success']")));	
	}
	
	public void verifyMovementRegisterErrorMsg(String msg) {
		Assert.assertEquals(msg, getMessage(By.xpath("//div[@class='alert alert-error']")));	
	}
	
	
	public void verifyMovimentRegisterValidationErrosMsgs(List<String> errorList , int numberReponse) {
		
		List<String> errors = getItens("//div[@class='alert alert-danger']//li");
		//	Assert.assertEquals("Data da Movimentação é obrigatória", errors.get(0));
		//Assert.assertTrue(errors.contains("Data da Movimentação é obrigatória"));
		Assert.assertTrue(errors.containsAll(errorList));
		Assert.assertEquals(numberReponse, errors.size());
	}
	

}


