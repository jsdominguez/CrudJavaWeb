package pkgOperciones;
import pkgModel.MdlAlumno;
import java.util.Scanner;

public class Opalumno {
	
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
