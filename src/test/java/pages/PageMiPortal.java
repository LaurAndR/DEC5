package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CapturaPantalla;
import common.CrearDocEvidencia;
import common.Log;

public class PageMiPortal {
	private WebDriver driver;
	Log log = new Log();
	CrearDocEvidencia crearDocEvidencia = new CrearDocEvidencia();
	CapturaPantalla capturaPantalla = new CapturaPantalla();
	public PageMiPortal(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickPendientes (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("dashboard-pendientes")).click();
				String texto ="Click PENDIENTES";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar clic en PENDIENTES");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
}