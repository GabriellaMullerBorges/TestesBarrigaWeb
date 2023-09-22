package gabriella.borges.core;
import static gabriella.borges.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/********* Escrita por Id ************/
	
	public void escreve(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escreve(By.id(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	};
	
/********* Botao ************/
	
	public void clicarBotao(String type) {
		String cssSelector = "[type='" + type + "']";
		getDriver().findElement(By.cssSelector(cssSelector)).click();
	}
	
/********* Textos ************/
	
	public String obtemTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String className) {
		return obtemTexto(By.className(className));
	}
	
	public String obterValorCampoClasse(String class_campo) {
		return getDriver().findElement(By.className(class_campo)).getText();
	};
	
	
/********* WebElement ************/

public String verificaTextoWebElement (String className) {
	WebElement element = getDriver().findElement(By.className(className));
	String TextoElement = element.getText();
	return TextoElement;
}

}
