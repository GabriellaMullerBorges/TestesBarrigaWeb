package gabriella.borges.tests;

import static gabriella.borges.core.DriverFactory.getDriver;
import static gabriella.borges.core.DriverFactory.killDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gabriella.borges.pages.LoginPage;

public class LoginTest extends LoginPage {

    @Before
    public void inicializa() {
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }


    private void realizarLogin(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        enviarForm();
    }

    private void aguardarURL(String urlDesejada) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(urlDesejada));
    }

    private void verificarURL(String urlDesejada) {
        String urlAtual = getDriver().getCurrentUrl();
        Assert.assertEquals(urlDesejada, urlAtual);
    }

    private void verificarTextoAlert(String expectedText) {
        String alertText = verificaTextoAlert();
        Assert.assertEquals(expectedText, alertText);
    }

    @Test
    public void testeLoginSucesso() {
        String urlDesejada = "https://seubarriga.wcaquino.me/logar";

        realizarLogin("massadeteste@gmail.com", "massadeteste123");

        verificarURL(urlDesejada);
    }

    @Test
    public void testeLoginEmailIncorreto() {
        String urlDesejada = "https://seubarriga.wcaquino.me/logar";
        String expectedAlertText = "Problemas com o login do usuário";

        realizarLogin("massadeteste@mail.com", "massadeteste123");

        verificarURL(urlDesejada);
        verificarTextoAlert(expectedAlertText);
    }

    @Test
    public void testeLoginSenhaIncorreta() {
        String urlDesejada = "https://seubarriga.wcaquino.me/logar";
        String expectedAlertText = "Problemas com o login do usuário";

        realizarLogin("massadeteste@mail.com", "123");

        verificarURL(urlDesejada);
        verificarTextoAlert(expectedAlertText);
    }

    @Test
    public void testeLoginEmailVazio() {
        String urlDesejada = "https://seubarriga.wcaquino.me/logar";
        String expectedAlertText = "Email é um campo obrigatório";

        realizarLogin("", "123");

        verificarURL(urlDesejada);
        verificarTextoAlert(expectedAlertText);
    }

    @Test
    public void testeLoginSenhaVazia() {
        String urlDesejada = "https://seubarriga.wcaquino.me/logar";
        String expectedAlertText = "Senha é um campo obrigatório";

        realizarLogin("massadeteste@mail.com", "");

        verificarURL(urlDesejada);
        verificarTextoAlert(expectedAlertText);
    }
}
