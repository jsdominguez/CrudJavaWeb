package pkgOperciones;
import pkgModel.MdlAlumno;
import java.util.Scanner;

public class Opalumno {
	
	public static void OpMostrarMenu() {
		System.out.println("\n*********** MENU **********");
		System.out.println("*                         *");
		System.out.println("*  1- REGISTRAR ALUMNO    *");
		System.out.println("*  2- LISTAR ALUMNO       *");
		System.out.println("*  3- ACTUALIZAR ALUMNO   *");
		System.out.println("*  4- ELIMINAR ALUMNO     *");
		System.out.println("*  5- BUSCAR ALUMNO       *");
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
			opSeleccionarOpcion();
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
}
