package pkgModel;

public class MdlAlumno {
	
	private int idAlumno;
	private String nombre;
	private String apellido;
	private int edad;
	
	public MdlAlumno() {}
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	 public String toString(){
		return this.idAlumno+" - " + this.nombre + " - " + this.apellido + " - " + this.edad;
	}
}
