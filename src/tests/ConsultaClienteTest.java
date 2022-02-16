package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultaClienteTest {

	@Test
	public void test() {

		// definir o local onde esta o driver do googlrchrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// abrir o googlechrome
		WebDriver driver = new ChromeDriver();

		// maximizar a janela do navegador
		driver.manage().window().maximize();

		// acessar a pagina de consulta de clientes do sistema
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio04");

		// preencher o CPF do cliente
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys("456.789.123-00");

		// clicar no botao de confimacao
		driver.findElement(By.xpath("//*[@id=\"btnPesquisa\"]")).click();

		// ler toadas as informacoes exibidas na pagina
		String nome = driver.findElement(By.xpath("//*[@id=\"nome\"]")).getText();
		String dataNascimento = driver.findElement(By.xpath("//*[@id=\"datanascimento\"]")).getText();
		String email = driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();

		// verificar o valor de cada variavel
		assertEquals(nome, "Pedro Carlos");
		assertEquals(dataNascimento, "12/06/1985");
		assertEquals(email, "pedrocarlos@gmail.com");

		// gerando a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("c:\\evidencas\\consultarcliente.png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

}
