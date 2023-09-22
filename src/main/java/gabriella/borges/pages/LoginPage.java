package gabriella.borges.pages;
import static gabriella.borges.core.DriverFactory.getDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gabriella.borges.core.BasePage;

public class LoginPage extends BasePage {

	public void setEmail(String email) {
		escrever("email", email);
	};
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	};
	
	public void enviarForm() {
	    clicarBotao("submit");
	};
	
	
	public String verificaTextoAlert() {
		return verificaTextoWebElement("alert-danger");
	}
}
