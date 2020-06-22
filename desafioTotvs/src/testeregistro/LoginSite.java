package testeregistro;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import entity.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginSite extends Usuario {
	WebDriver driver;
	String URLRegistro="https://olx.com.br/";
	String URLLogado="https://conta.olx.com.br/anuncios/publicados";
	String URLBusca="https://www.olx.com.br/brasil";
	String URLRJ="https://rj.olx.com.br/";
	String URLProduto="https://rj.olx.com.br/?q=PS4";


@Before
	public void inicio() {
		setEmail("contatestedesafio@gmail.com");
		setSenha("$Totvs2020");
				
	}

@Test
public void TestSiteOLX() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marco\\Desktop\\Curso Coti\\Programas\\chromedriver.exe");
	this.driver = new ChromeDriver();
	this.driver.get(URLRegistro);
	this.driver.manage().window().maximize();
	Thread.sleep(500);
	//realizar o login
	this.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/header/div[3]/a[4]/span")).click();
	Thread.sleep(500);
	this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/form/div[1]/div[2]/input")).sendKeys(getEmail());
	Thread.sleep(500);
	this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/form/div[2]/div[2]/div/div/input")).sendKeys(getSenha());
	Thread.sleep(500);
	this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/form/button")).click();
	Thread.sleep(500);
	this.driver.get(URLLogado);
	
	//validar que o login foi realizado pelo assert do texto "Meus anuncios"
	WebElement elementoUm = this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/h1"));
	assertEquals("Meus anúncios", elementoUm.getText().toString());
	
	//clicar para buscar
	this.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/header/a")).click();
	this.driver.get(URLBusca);
	
	//validar que foi redirecionado para busca pelo assert do texto "Agora escolha seu estado"
	WebElement elementoDois = this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[1]/div[1]/ul/li[2]"));
	assertEquals("Agora escolha seu estado", elementoDois.getText().toString());
	
	//clicar no estado RJ
	this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[1]/div[2]/div/ul[3]/li[5]/a")).click();
	this.driver.get(URLRJ);
	Thread.sleep(500);
	//validar que foi redirecionado para busca pelo assert do texto "RJ"
	WebElement elementoTres = this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[1]/div[1]/ul/li[3]/h2"));
	assertEquals("RJ", elementoTres.getText().toString());

	this.driver.findElement(By.cssSelector("[name='q']")).click();
	this.driver.findElement(By.cssSelector("[name='q']")).sendKeys("PS4",Keys.ENTER);
	
	//passar o mouse no menu 
	Actions actions = new Actions(driver);
	WebElement menuOption = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/header/div[3]/div[1]/a/span/div/span"));
	actions.moveToElement(menuOption).perform();
		
	//selecionar o submenu sair
	WebElement subMenuOption = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/header/div[3]/div[1]/nav/ul/li[10]/a")); 
	subMenuOption.click();
	
	}

}
