package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import common.CapturaPantalla;
import common.CrearDocEvidencia;
import common.FechaActual;
import common.Log;

public class PageProcesoFirma {
	private WebDriver driver;
	Log log = new Log();
	CrearDocEvidencia crearDocEvidencia = new CrearDocEvidencia();
	CapturaPantalla capturaPantalla = new CapturaPantalla();
	public PageProcesoFirma(WebDriver driver) {
		this.driver=driver;
	}
	
	public void IngresoEtiqueta (String caso, String etiqueta) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.name("searchTerm")).sendKeys(etiqueta);
				String texto ="Ingreso Etiqueta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Ingresar Etiqueta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void BuscarEtiqueta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div/button")).click();
				String texto ="Buscar Etiqueta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Buscar Etiqueta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void AgregarCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/h3/span/a")).click();
				Thread.sleep(1000);
				String texto ="click Agregar Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Agregar Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnCrearCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("id-add-folder")).click();
				Thread.sleep(1000);
				String texto ="click Boton Crear Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Boton Crear Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void CrearCarpeta (String caso, String nombre) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.name("folder")).sendKeys(nombre);
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[3]/button[2]")).click();
				Thread.sleep(1000);
				String texto ="Crear Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Crear Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void ClickCarpetas (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[1]/div/button")).click();
				Thread.sleep(3000);
				String texto ="click Carpetas";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Carpetas");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void CrearNuevaCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/h1/div/a[2]")).click();
				Thread.sleep(1000);
				String texto ="Agregar Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar para agregar carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void AgregarCarpetaYaExistente (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				String nombreCarpeta = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/div/button")).getText();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/h1/div/a[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.name("folder")).sendKeys(nombreCarpeta);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[3]/button[2]")).click();
				Thread.sleep(1000);
				String texto ="Carpeta Existente";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void BtnCancelar (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[3]/button[1]")).click();
				Thread.sleep(1000);
				String texto ="click Boton Cancelar";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Boton Cancelar");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnFiltrarCarpetas (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/button")).click();
				Thread.sleep(1000);         
				String texto ="Boton Filtrar";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Boton Filtrar");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public int CantidadCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		int cantidad=0;
		do {
			try {
				cantidad = driver.findElements(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div/form/div/descendant::input")).size();
				Thread.sleep(1000);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible contar Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
		return cantidad;
	}
	
	public void SeleccionarCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/descendant::button[1]")).click();
				Thread.sleep(1000);
				String texto ="Carpeta Seleccionada";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Seleccionar Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void LinkEliminarCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div/h1/div/a[1]")).click();
				Thread.sleep(1000);
				String texto ="click Link Eliminar Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Link Eliminar Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void EliminarCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("eliminarFolder")).click();
				Thread.sleep(1000);
				String texto ="Eliminar Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Eliminar Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void ClickFiltrosAvanzados (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/button")).click();
				Thread.sleep(3000);
				String texto ="click Filtros Avanzados";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Filtros Avanzados");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void BtnFiltrar (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"filteredForm\"]/div[1]/div/div/div/div[3]/div[3]/div[2]/button")).click();
				Thread.sleep(3000);
				String texto ="click Filtrar";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Filtrar");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void CambiarEstadoFiltro (String caso, String estadoFiltro) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				Select estado = new Select (driver.findElement(By.id("status")));
				switch (estadoFiltro){
					case "PENDIENTE":
						estado.selectByValue("0");
						break;
					case "EN PROCESO DE FIRMA":
						estado.selectByValue("1");
						break;
					case "FIRMADO POR TODOS":
						estado.selectByValue("2");
						break;
					case "RECHAZADO":
						estado.selectByValue("3");
						break;
					case "TODOS":
						estado.selectByValue("10");
						break;
					default:
						System.out.println("Estado inv�lido");
						break;
				}
				Thread.sleep(3000);
				String texto ="Seleccion Estado Filtros Avanzados";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible seleccionar Estado en Filtros Avanzados");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(3000);
	}
	
	public void FechaDesde (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				FechaActual fechaActual = new FechaActual();
				String fecha = fechaActual.FechaDesde();
				driver.findElement(By.name("from")).sendKeys(fecha);
				Thread.sleep(1000);
				String texto ="Ingreso Fecha Desde";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar Fecha Desde");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void FechaHasta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				FechaActual fechaActual = new FechaActual();
				String fecha = fechaActual.FechaHoy();
				driver.findElement(By.name("to")).sendKeys(fecha);
				Thread.sleep(1000);
				String texto ="Ingreso Fecha Hasta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar Fecha Hasta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void TipoDocumento (String caso, String tipoDoc) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("tipoDctoSel")).sendKeys(tipoDoc);
				Thread.sleep(1000);
				String texto ="Tipo Documento";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar Tipo Documento");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public String MensajeSinResultados (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		String mensaje = "";
		do {
			try {
				mensaje = driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/descendant::td[1]")).getAttribute("class");
				Thread.sleep(1000);
				String texto ="Mensaje Sin Resultados";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible obtener mensaje");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
		return mensaje;
	}
	
	public void BtnMostrarOcultos (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[3]/div/button")).click();
				Thread.sleep(1000);
				String texto ="Boton Mostrar Ocultos";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en bot�n Mostrar Ocultos");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(10000);
	}
	
	public void ClickPrimerRegistro (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"table-documentos\"]/descendant::input[1]")).click();
				Thread.sleep(1000);
				String texto ="Seleccion Primer Registro";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en primer registro");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(5000);
	}
	
	public void MoverA (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div/form/div/descendant::input[1]")).click();
//				System.out.println(driver.findElement(By.xpath("//*[@id=\"checkMover_580\"]")).getText());
				Thread.sleep(1000);
				String texto ="Seleccion Carpeta Destino";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en carpeta destino");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnMover (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("move-folder")).click();
				Thread.sleep(1000);
				String texto ="click Boton Mover";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en boton Mover");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void CrearNuevaCarpeta (String caso, String nombre) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.name("new_folder")).sendKeys(nombre);
				driver.findElement(By.id("move-folder-create")).click();
				Thread.sleep(1000);
				String texto ="Crear Nueva Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Crear Nueva Carpeta");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void CerrarMoverCrearCarpeta (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				String texto ="Cerrar Crear Mover Carpeta";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Cerrar Ventana");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void AgregarEtiquetas (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[2]/div/div[2]/a")).click();
				Thread.sleep(1000);
				String texto ="Agregar Etiquetas";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Agregar Etiquetas");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void CerrarAgregarEtiquetas (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				String texto ="Cerrar Agregar Etiquetas";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/form/div[1]/button")).click();
				Thread.sleep(2000);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible Cerrar Ventana");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void DesvincularDocumento (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
//				System.out.println(driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[6]/div/table/tbody/tr/td[4]/a")).getText());
//				System.out.println(driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[6]/div/table/tbody/tr/td[4]/a")).getTagName());
//				System.out.println(driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[6]/div/table/tbody/tr/td[4]/a")).getAttribute("href"));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[6]/div/table/tbody/tr[1]/td[4]/a")).click();
				Thread.sleep(1000);
				String texto ="Desvincular Documento";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Desvincular Documento");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnSiDesvincularDocumento (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/button[1]")).click();
				Thread.sleep(1000);
				String texto ="SI Desvincular Documento";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Si Desvincular Documento");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnNoDesvincularDocumento (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/button[2]")).click();
				Thread.sleep(1000);
				String texto ="NO Desvincular Documento";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en No Desvincular Documento");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnCerrarDesvincularDocumento (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[3]/button")).click();
				Thread.sleep(1000);
				String texto ="Cerrar Desvincular Documento";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Cerrar Desvincular Documento");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnCrearComentario (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.xpath("//*[@id=\"details-doc\"]/div/div[8]/div/div[2]/div/button")).click();;
				Thread.sleep(1000);
				String texto ="click Crear comentario";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Crear Comentario");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void IngresarComentario (String caso, String comentario) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("comment-text")).sendKeys(comentario);;
				Thread.sleep(1000);
				String texto ="Ingreso de comentario";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible ingresar Comentario");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
	public void BtnComentar (String caso) throws InterruptedException {
		int i=0;
		int j=0;
		do {
			try {
				driver.findElement(By.id("comment-submit")).click();;
				Thread.sleep(1000);
				String texto ="click Comentar";
				log.modificarArchivoLog(caso,texto);
				crearDocEvidencia.modificarArchivoEvidencia(caso,texto);
				texto=texto.replace(" ","_");
				capturaPantalla.takeScreenShotTest(driver,texto, caso);
				i=1;
			}catch (Exception e) {
				// TODO: handle exception
				j++;
				if(j==3) {
					System.out.println("No fue posible dar click en Comentar");
					i=1;
				}
			}
		}while(i==0);
		Thread.sleep(2000);
	}
	
}
