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

public class CadastrarProdutoTest {

	@Test
	public void test() {

		// definir o local onde esta o driver do googlrchrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// abrir o googlechrome
		WebDriver driver = new ChromeDriver();

		// maximizar a janela do navegador
		driver.manage().window().maximize();

		// acessar a pagina do sisema
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio05");

		// preencher o nome do produto
		driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys("Notebook");

		// preencher preco do produto
		driver.findElement(By.xpath("//*[@id=\"preco\"]")).sendKeys("4000");

		// Preencher quantidade do produto
		driver.findElement(By.xpath("//*[@id=\"quantidade\"]")).sendKeys("10");

		// clicar no botao cadastrar produto
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// verificar se a mensagem esta correta
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Produto cadastrado com sucesso.");

		// gerando a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("c:\\evidencas\\cadastrarproduto.png"));
		} catch (Exception e) {

		}
		// fechar navegador
		driver.close();
		driver.quit();

	}

}
