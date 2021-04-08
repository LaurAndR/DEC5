package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CapturaPantalla;
import common.CrearDocEvidencia;
import common.Log;

public class PageDec5 {
	private WebDriver driver;
	Log log = new Log();
	CrearDocEvidencia crearDocEvidencia = new CrearDocEvidencia();
	CapturaPantalla capturaPantalla = new CapturaPantalla();
	public PageDec5(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickRuedaConfiguracion(String caso) throws InterruptedException, IOException, InvalidFormatException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/nav/div/ul/li[2]/div/button")).click();
		String texto="Click a Configuraciones";
		log.modificarArchivoLog(caso, texto);
		crearDocEvidencia.modificarArchivoEvidencia(caso, texto);
		texto=texto.replace(" ", "_");
		capturaPantalla.takeScreenShotTest(driver, texto, caso);
		Thread.sleep(2000);
	}
	
	public void EditarCuenta(String caso) throws InterruptedException, IOException, InvalidFormatException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/nav/div/ul/li[2]/div/ul/li[1]/a")).click();
		String texto="Click a Editar Cuentas";
		log.modificarArchivoLog(caso, texto);
		crearDocEvidencia.modificarArchivoEvidencia(caso, texto);
		texto=texto.replace(" ", "_");
		capturaPantalla.takeScreenShotTest(driver, texto, caso);
		Thread.sleep(2000);
	}
	
	public void RegistroCertificadoHSM(String caso) throws InterruptedException, IOException, InvalidFormatException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/form/table/tbody/tr[7]/th/span/button")).click();
		String texto="Click a Registro Certificado HSM";
		log.modificarArchivoLog(caso, texto);
		crearDocEvidencia.modificarArchivoEvidencia(caso, texto);
		texto=texto.replace(" ", "_");
		capturaPantalla.takeScreenShotTest(driver, texto, caso);
		Thread.sleep(2000);
	}
	
	public String MensajeCertificadoHSM() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String mensaje = driver.findElement(By.cssSelector("#modal > div > div > div.modal-body > div > div > p > strong")).getText();
		return mensaje;
	}
	
	public void OpcionInstituciones(String caso) throws IOException, InvalidFormatException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/nav/div/ul/li[2]/div/ul/li[2]/a")).click();
		String texto ="Click a Instituciones";
		log.modificarArchivoLog(caso,texto);
		crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
		texto=texto.replace(" ","_");
		capturaPantalla.takeScreenShotTest(driver,texto, caso);
	}
	
	public void ClickIngresarLogin(String caso) {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("id-login")).click();
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println();
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar al login");
					i=1;
				}
			}
		}while(i==0);
	}
}
