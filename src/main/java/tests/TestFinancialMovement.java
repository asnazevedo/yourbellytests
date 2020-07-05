package tests;


import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.FinancialMovementPage;
import pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFinancialMovement extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private FinancialMovementPage movementPage = new FinancialMovementPage();
		
	@Test
	public void test1AddPaidMovement() {
			menuPage.triggerMenuCreateFinancialMovement();
			movementPage.movement("Receita",movementPage.getCurrentDateTime(),movementPage.getXDaysFromCurrentDate(0), "Salario", "Antonio Sergio","3000","Conta 1A", "Pago");
			movementPage.verifyMovementRegisterSucessMsg("Movimentação adicionada com sucesso!");
	}
	
	@Test
	public void test2AddPengindMovement() {
			menuPage.triggerMenuCreateFinancialMovement();
			movementPage.movement("Receita",movementPage.getCurrentDateTime(),movementPage.getXDaysFromCurrentDate(30), "Conta de Luz", "Antonio Sergio","500","Conta 1A", "Pendente");
			movementPage.verifyMovementRegisterSucessMsg("Movimentação adicionada com sucesso!");
	}
	
	@Test
	public void test3AddMovementBloquedByObrigatoryFields() {
			menuPage.triggerMenuCreateFinancialMovement();
			movementPage.triggerSave();
			movementPage.verifyMovimentRegisterValidationErrosMsgs(Arrays.asList(
					"Data da Movimentação é obrigatório",
					"Data do pagamento é obrigatório",
					"Descrição é obrigatório",
					"Interessado é obrigatório",
					"Valor é obrigatório",
					"Valor deve ser um número"),6);
	}
	
	@Test
	public void test4AddMovementBloquedByUseOfFutureMovementDate() {
			menuPage.triggerMenuCreateFinancialMovement();
			movementPage.movement("Receita",movementPage.getXDaysFromCurrentDate(1),movementPage.getXDaysFromCurrentDate(30), "Salario", "Antonio Sergio","3000","Conta 1A", "Pago");
			movementPage.triggerSave();
			movementPage.verifyMovimentRegisterValidationErrosMsgs(Arrays.asList(
					"Data da Movimentação deve ser menor ou igual à data atual"),1);
	}
	

	

}
