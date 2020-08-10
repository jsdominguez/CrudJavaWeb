package pkgOperciones;

import pkgModel.MdlAlumno;
import pkgConexion.Conexion;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Opalumno {
	
	public static void OpMostrarMenu() {
		System.out.println("\n*********** MENU **********");
		System.out.println("*                         *");
		System.out.println("*  1- REGISTRAR ALUMNO    *");
		System.out.println("*  2- LISTAR ALUMNO       *");
		System.out.println("*  3- ACTUALIZAR ALUMNO   *");
		System.out.println("*  4- ELIMINAR ALUMNO     *");
		System.out.println("*  5- BUSCAR ALUMNO       *");
		System.out.println("*  6- GENERAR EXCEL       *");
		System.out.println("*  7- GENERAR PDF         *");
		System.out.println("*  0- SALIR               *");
		System.out.println("*                         *");
		System.out.println("***************************");
	}
	
	public static int opSeleccionarOpcion() {
		int retornarOpcion = 0;
		try {
			Scanner tecldo = new Scanner(System.in);
			System.out.print("[->] INGRESE OPCION : ");
			retornarOpcion = tecldo.nextInt();
		}catch(Exception e) {
			retornarOpcion = 99;
		}
		return retornarOpcion;
	}
	
	public static MdlAlumno opSolicitarDatos(int codigoUpdate) {
		Scanner tecldo = new Scanner(System.in);
		MdlAlumno objaAlumno = new MdlAlumno();
		
		if(codigoUpdate !=0) {
			objaAlumno.setIdAlumno(codigoUpdate);
		}else {
			System.out.print("[->] Ingrese ID : ");
			objaAlumno.setIdAlumno(tecldo.nextInt());
		}
		System.out.print("[->] Ingrese Nombre : ");
		objaAlumno.setNombre(tecldo.next());
		System.out.print("[->] Ingrese Apellido : ");
		objaAlumno.setApellido(tecldo.next());
		System.out.print("[->] Ingrese Edad : ");
		objaAlumno.setEdad(tecldo.nextInt());
		return objaAlumno;
	}
	
	public static int opSolicitarIdAlumno() {
		int codigo;
		Scanner tecldo = new Scanner(System.in);
		System.out.print("[->] Ingrese ID : ");
		codigo = tecldo.nextInt();
		return codigo;
	}
	
	public static boolean opListarAlumno(ResultSet resultadoDatos) {
		boolean registrosEncontrados = true;
		try {
			
			//verifica si la fila siguiente hay datos , se posiciona desde la cabezera para poder leer la siguiente fila
			if(resultadoDatos.next()) {
				//si next encuentra dato avanza una fila, por eso lo regresamos a la cabezera xq ya encontro datos y se ha movido
				resultadoDatos.beforeFirst();
				while(resultadoDatos.next()) {
					System.out.println("\n*******************************************");
					System.out.println("id : " + resultadoDatos.getString("id"));
					System.out.println("Nombre : " + resultadoDatos.getString("nombre"));
					System.out.println("apellido : " + resultadoDatos.getString("apellido"));
					System.out.println("edad : " + resultadoDatos.getString("edad"));
				}
			}else {
				System.out.println("\n[X] REGISTRO VACIO [X]");
				registrosEncontrados = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return registrosEncontrados;
	}
	
	public static void opGenerarReporteExcel(ResultSet resultadoDatos) {
		
		try {
			
			//HSSFWorkbook = crea archivos excel antiguos (xls)
			//XSSFWorkbook = crea archivos excel 2007 en adelante (xlsx)
			XSSFWorkbook book = new XSSFWorkbook();
			XSSFSheet hoja1 = book.createSheet("Hoja1");
			XSSFSheet hoja2 = book.createSheet("Hoja2");
			
			//crea el archivo
			File excel = new File("src/main/resources/Alumno/Reportes/Excel/Demo.xlsx");
			excel.createNewFile();
			//establece el vinculo para poder escribir
			FileOutputStream vinculo = new FileOutputStream(excel);
			
			ArrayList<String> headers = new ArrayList<String>();
			headers.add("ID");
			headers.add("NOMBRE");
			headers.add("ALUMNO");
			headers.add("APELLIDO");
			
			int posicionFila = 0;
			int posicionCelda = 0;
			
			XSSFRow fila;
			XSSFCell celda;
			
			fila = hoja1.createRow(posicionFila);//posicion de filas
			for(String cabezera : headers) {
				celda = fila.createCell(posicionCelda); //creacion de celdas
				celda.setCellValue(cabezera); //setea celda
				++posicionCelda;
			}
			
			
			if(resultadoDatos.next()) {
				resultadoDatos.beforeFirst();
				while(resultadoDatos.next()) {
					
					posicionCelda = 0;
					fila = hoja1.createRow(++posicionFila);//posicion de filas
					
					//crea celda 0
					celda = fila.createCell(posicionCelda); //setea celda
					celda.setCellValue(resultadoDatos.getString("id"));
					
					//crea celda 1
					celda = fila.createCell(++posicionCelda); 
					celda.setCellValue(resultadoDatos.getString("nombre")); //setea celda
					
					//crea celda 2
					celda = fila.createCell(++posicionCelda);
					celda.setCellValue(resultadoDatos.getString("apellido")); //setea celda
					
					//crea celda 3
					celda = fila.createCell(++posicionCelda);
					celda.setCellValue(resultadoDatos.getString("edad")); //setea celda
				}
			}
			
			//escribe los datos
			book.write(vinculo);
			book.close();
			vinculo.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void opGenerarReportePDF() {
		
		try{
			String ruta = "src/main/resources/Alumno/Reportes/PDF/Alumno.jasper";
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jprint = JasperFillManager.fillReport(report, null,Conexion.conectar());
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            System.out.println("\n [-] REPORTE GENERADO [-]");
        }catch(JRException ex){
            ex.printStackTrace();
        }
	}
	
}
