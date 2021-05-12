package test;

import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Configuration;
import common.LeerExcel;
import evidence.CrearLogyDocumento;
import pages.PageAcepta;
import pages.PageDec5;
import pages.PageFechaCalendario;
import pages.PageLoginAdm;
import pages.PageMiPortal;
import pages.PageMisDocumentos;
import pages.PagePendientes;

public class Test_MisDocumentos {

	private WebDriver driver;
	String datapool = Configuration.ROOT_DIR+"DataPool.xlsx";
	LeerExcel leerExcel = new LeerExcel(); 
	
		
	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
//		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://5cap.dec.cl/portal");// Aqu� se ingresa la URL para hacer las pruebas.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Script_1062() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1062";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.BusquedaEtiquetas(cp, datos[3]);
		
		
		if(driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/tbody/tr/td[2]")).getText().contains(datos[3])) {
			String texto = "Busqueda OK"; 
			crearLogyDocumento.AgregarRegistroLog(cp, texto);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1063() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1063";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.BusquedaEtiquetas(cp, datos[3]);
		
		String msjNoResultados = driver.findElement(By.id("table-documentos")).getText();
		if(msjNoResultados.equals("No se encontraron resultados")) {
			System.out.println("OK");
			crearLogyDocumento.AgregarRegistroLog(cp, msjNoResultados );
			crearLogyDocumento.CasoOk(cp);
			}
		else {
			System.out.println("NOK");
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1067() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1067";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickCarpeta(cp);
		pageMisDocumentos.clickNuevaCarpeta(cp);
		pageMisDocumentos.AgregarCarpetaYaExistente(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[2]/div/div/div/span")).getText().equals("Carpeta ya existe")) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1068() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1068";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		
		pageDec5.CambiarEmpresa(cp);
		pageDec5.ClickMiPortal(cp);
		
		PageMiPortal pageMiPortal = new PageMiPortal(driver);
		pageMiPortal.ClickPendientes(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.clickCarpeta(cp);
		pageMisDocumentos.clickNuevaCarpeta(cp);
		pageMisDocumentos.BtnCancelar(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed());
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1070() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1070";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickCarpeta(cp);
		pageMisDocumentos.FiltrarCarpetaExistente(cp);
		
		crearLogyDocumento.CasoOk(cp);	
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1071() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1071";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickCarpeta(cp);
		pageMisDocumentos.EliminarCarpetaExistente(cp);
		
			String mensaje = driver.findElement(By.xpath("//*[@id=\"modalDeleteFolders\"]/div/div/div[1]/h1")).getText();
			if(mensaje.equals("�Est�s seguro de querer eliminar la siguente carpeta?")) {
				String texto1 = "Mensaje eliminar OK";
				crearLogyDocumento.AgregarRegistroLog(cp, texto1);
				System.out.println("Paso 2");
				String btn = driver.findElement(By.xpath("//*[@id=\"eliminarFolder\"]")).getText();
				if(btn.equals("Eliminar")) {
					String texto2 = "Bot�n eliminar OK";
					crearLogyDocumento.AgregarRegistroLog(cp, texto2);
					System.out.println("Paso 3");
					String carpeta = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/div[4]/button")).getText();
					if(driver.findElement(By.xpath("//*[@id=\"modalDeleteFolders\"]/div/div/div[2]")).getText().equals(carpeta)){
						String texto = "Carpeta a eliminar OK";
						crearLogyDocumento.AgregarRegistroLog(cp, texto);
						System.out.println("Paso 1");
					}
				}
			}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1072() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1072";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
				
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickCarpetas(cp);
		int cantidadAntes = pagePendientes.CantidadCarpeta(cp);
		pagePendientes.SeleccionarCarpeta(cp);
		pagePendientes.LinkEliminarCarpeta(cp);
		pagePendientes.EliminarCarpeta(cp);
		int cantidadDespues = pagePendientes.CantidadCarpeta(cp);
		
		System.out.println(cantidadAntes);
		System.out.println(cantidadDespues);
		
		if(cantidadDespues<cantidadAntes) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1075() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1075";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(8, estado.length());//Cuenta el largo de letras de la variable estado
		
		if("PENDIENTE".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1076() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1076";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "EN PROCESO DE FIRMA");
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(18, estado.length());//Cuenta el largo de letras de la variable estado
		
		if("EN PROCESO DE FIRMA".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1077() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1077";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "FIRMADO POR TODOS");
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(16, estado.length());//Cuenta el largo de letras de la variable estado
		
		if("FIRMADO POR TODOS".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1078() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1078";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "RECHAZADO");
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(8, estado.length());//Cuenta el largo de letras de la variable estado
		
		if("RECHAZADO".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1079() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1079";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "TODOS");
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(4, estado.length());//Cuenta el largo de letras de la variable estado
		
		if("TODOS".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	@Test
	public void Script_1080() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1080";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		PageFechaCalendario pageFechaCalendario = new PageFechaCalendario(driver);
		pageFechaCalendario.fechaDesde(cp);
		
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(8, estado.length());
		
		if("PENDIENTE".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1081() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1081";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		PageFechaCalendario pageFechaCalendario = new PageFechaCalendario(driver);
		pageFechaCalendario.fechaHasta(cp);
		
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		String estado = driver.findElement(By.id("__tag_status")).getText();//Bot�n azul estado
		estado=estado.substring(8, estado.length());
		
		if("PENDIENTE".contains(estado)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		Thread.sleep(5000);
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1082() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1082";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		PageFechaCalendario pageFechaCalendario = new PageFechaCalendario(driver);
		pageFechaCalendario.fechaDesde(cp);
		pageFechaCalendario.fechaHasta(cp);
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		crearLogyDocumento.CasoOk(cp);
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1084() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1084";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickFiltrosAvanzados(cp);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		pageMisDocumentos.BusquedaTipoDocumento(cp, datos[3]);
		pagePendientes.BtnFiltrarFiltrosAvanzados(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"__tag_tipodocto\"]/button")).isDisplayed());//m�todo comprueba si un elemento web est� visible
		
		if(driver.findElement(By.xpath("//*[@id=\"__tag_tipodocto\"]/button")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		Thread.sleep(5000);
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1086() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1086";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		pageMisDocumentos.clickMostrarOcultos(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/tbody/tr/td[2]")).isDisplayed());
		
		if(driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/tbody/tr/td[2]")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		Thread.sleep(5000);
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1087() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1087";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.CambiarEstadoFiltro(cp, "PENDIENTE");
		
		pageMisDocumentos.clickNoMostrarOcultos(cp);
		
		String msjNoResultados = driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/tbody/tr/td")).getText();
		if(msjNoResultados.equals("No se encontraron resultados")) {
			System.out.println("Mensaje OK");
			crearLogyDocumento.AgregarRegistroLog(cp, msjNoResultados );
			crearLogyDocumento.CasoOk(cp);
			}
		else {
			System.out.println("Mensaje NOK");
			crearLogyDocumento.CasoNok(cp);
		}
		
		Thread.sleep(2000);
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1090() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1090";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickDocumento(cp);
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/h3/span/a"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickAgregarCarpeta(cp);
		pageMisDocumentos.MoverA(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.BtnMover(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/div[1]/button/span[1]")).getText().length()>0) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1092() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1092";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Agregar a");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/h3/span/a"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickAgregarCarpeta(cp);
		pageMisDocumentos.crearCarpeta(cp, "CARPETA PRUEBA");
		pageMisDocumentos.btnCrear(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div/form/div")).getText().length()>0) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1093() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1093";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Agregar a");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/h3/span/a"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickAgregarCarpeta(cp);
		pageMisDocumentos.CerrarMoverA(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1095() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1095";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Etiquetar");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/div[2]/a"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickAgregarEtiqueta(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		String texto= driver.findElement(By.id("myModalLabel")).getText();
		if(texto.equals("Agregar Etiquetas")) {
			crearLogyDocumento.AgregarRegistroLog(cp, texto +" OK");
			System.out.println(texto);
			crearLogyDocumento.CasoOk(cp);
			String texto1= driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[2]/div[1]/div[1]/label")).getText();
				if(texto1.equals("Etiquetas")) {
					crearLogyDocumento.AgregarRegistroLog(cp, "OK");
					System.out.println(texto1);
					crearLogyDocumento.CasoOk(cp);
				}
		}
		else {
			crearLogyDocumento.CasoNok(cp);
			System.out.println("OK");
			
		}
		System.out.println(driver.findElement(By.name("add-tag")).isDisplayed()); //Bot�n Etiquetar verde popUp
		if(driver.findElement(By.name("add-tag")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1096() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1096";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Agregar a");
//		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/div[2]/a"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickAgregarEtiqueta(cp);
		pageMisDocumentos.cerrarAgregarEtiquetas(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1098() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1098";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Vincular");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[7]/div/div/div/button"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickVincularDocumento(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed());
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1099() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1099";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Vincular");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[7]/div/div/div/button"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickVincularDocumento(cp);
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		pageMisDocumentos.seleccionCheckVincular(cp);
		
		System.out.println(driver.findElement(By.id("relateDocSubmit")).isDisplayed());//id bot�n verde popUp vincular
		if(driver.findElement(By.id("relateDocSubmit")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1100() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1100";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
//		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Vincular");	
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[7]/div/div/div/button"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickVincularDocumento(cp);
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		pageMisDocumentos.seleccionCheckVincular(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed());
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		String mensaje = driver.findElement(By.xpath("//*[@id=\"table-adjuntar\"]/tbody/tr/td")).getText();
		System.out.println(mensaje);
		if("No se encontraron resultados".contains(mensaje)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1101() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1101";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
//		pagePendientes.BarraHerramientas(cp,"Vincular");
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[7]/div/div/div/button"));
		builder.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		pageMisDocumentos.clickVincularDocumento(cp);
		pagePendientes.CerrarVincularDocumento(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1107() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1107";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[8]/div/div[2]/div/button"));
		builder.moveToElement(element).perform();
		Thread.sleep(2000);
		
		pagePendientes.BtnCrearComentario(cp);
		pagePendientes.IngresarComentario(cp, "PRUEBA AUTOMATIZADA--QA");
		Thread.sleep(2000);
		pagePendientes.BtnComentar(cp);

		crearLogyDocumento.CasoOk(cp);
		
		System.out.println("FLUJO OK");
		
	}
	
	@Test
	public void Script_1108() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1108";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[8]/div/div[2]/div/button"));
		builder.moveToElement(element).perform();
		Thread.sleep(2000);
		
		pagePendientes.BtnCrearComentario(cp);
		pagePendientes.BtnCancelar(cp);

		crearLogyDocumento.CasoOk(cp);
		
		System.out.println("FLUJO OK");
		
	}
	
	@Test
	public void Script_1110() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1110";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Cancelar");	
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]")).isDisplayed());//xpath de la barra de herramientas
		if(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}

		System.out.println("FLUJO OK");
		
	}

	@Test
	public void Script_1112() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1112";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Vincular");	
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed());
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1113() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1113";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Vincular");	
						
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		pageMisDocumentos.seleccionCheckVincular(cp);
		
		System.out.println(driver.findElement(By.id("relateDocSubmit")).isDisplayed());//id bot�n verde popUp vincular
		if(driver.findElement(By.id("relateDocSubmit")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1114() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1114";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Vincular");	
						
		pageMisDocumentos.BusquedaPalabrasVincular(cp, datos[3]);
		pageMisDocumentos.seleccionCheckVincular(cp);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed());
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		String mensaje = driver.findElement(By.xpath("//*[@id=\"table-adjuntar\"]/tbody/tr/td")).getText();
		System.out.println(mensaje);
		if("No se encontraron resultados".contains(mensaje)) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1115() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1115";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Vincular");	
		pagePendientes.CerrarVincularDocumento(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1117() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1117";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Agregar a");	
		
		pageMisDocumentos.MoverA(cp);
		
		pagePendientes.BtnMover(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/div[1]/button/span[1]")).getText().length()>0) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1119() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1119";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Agregar a");	
		
		pageMisDocumentos.crearCarpeta(cp, "CARPETA PRUEBA AUTOMA");
		pageMisDocumentos.btnCrear(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div/form/div")).getText().length()>0) {
			crearLogyDocumento.CasoOk(cp); 
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1120() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1120";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.ClickPrimerRegistro(cp);
		pagePendientes.BarraHerramientas(cp,"Agregar a");	
		
		pageMisDocumentos.CerrarMoverA(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1122() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1122";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		
		pageMisDocumentos.clickDocumento(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.BarraHerramientas(cp,"Etiquetar");
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		String texto= driver.findElement(By.id("myModalLabel")).getText();
		if(texto.equals("Agregar Etiquetas")) {
			crearLogyDocumento.AgregarRegistroLog(cp, texto +" OK");
			System.out.println(texto);
			crearLogyDocumento.CasoOk(cp);
			String texto1= driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[2]/div[1]/div[1]/label")).getText();
				if(texto1.equals("Etiquetas")) {
					crearLogyDocumento.AgregarRegistroLog(cp, "OK");
					System.out.println(texto1);
					crearLogyDocumento.CasoOk(cp);
				}
		}
		else {
			crearLogyDocumento.CasoNok(cp);
			System.out.println("OK");
			
		}
		System.out.println(driver.findElement(By.name("add-tag")).isDisplayed()); //Bot�n Etiquetar verde popUp
		if(driver.findElement(By.name("add-tag")).isDisplayed()) {
			crearLogyDocumento.CasoOk(cp);
		}
		else {
			crearLogyDocumento.CasoNok(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@Test
	public void Script_1123() throws InterruptedException, IOException, InvalidFormatException {
		String cp = "DEC_1123";
		System.out.println(cp);
		
		PageDec5 pageDec5 = new PageDec5(driver);
		PageLoginAdm pageLoginAdm = new PageLoginAdm(driver);
		PageAcepta pageAcepta = new PageAcepta(driver);
		CrearLogyDocumento crearLogyDocumento = new CrearLogyDocumento(driver);
		crearLogyDocumento.CrearEvidencias(cp);
		
		String[] datos = leerExcel.ObtenerDatosCP(datapool,cp);
		
		pageDec5.ClickIngresarLogin(cp);
		pageLoginAdm.LoginIdentidadDigital(cp, datos[1], datos[2]);
		pageDec5.OpcionUserName(cp);
		pageAcepta.empresaAcepta(cp);
		
		PageMisDocumentos pageMisDocumentos = new PageMisDocumentos(driver);
		pageMisDocumentos.MisDocumentos(cp);
		pageMisDocumentos.clickDocumento(cp);
		
		PagePendientes pagePendientes = new PagePendientes(driver);
		pagePendientes.BarraHerramientas(cp,"Agregar a");
		
		pageMisDocumentos.cerrarAgregarEtiquetas(cp);
		
		if(driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div")).isDisplayed()) {
			crearLogyDocumento.CasoNok(cp);
		}
		else {
			crearLogyDocumento.CasoOk(cp);
		}
		
		System.out.println("FLUJO OK");
	}
	
	@AfterMethod
	public void FinEjecucion() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}


