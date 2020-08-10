package pkgInterfaces;

import java.sql.ResultSet;
import pkgModel.MdlAlumno;

public interface ITFAlumno {
	
	public ResultSet daoListarAlumno();
	
	public void daoRegistrarAlumno(MdlAlumno paramObjalumno);
	
	public void daoEditarAlumno(MdlAlumno paramObjalumno);
	
	public ResultSet daoBuscarAlumnoId(int codigo);
	
	public void daoEliminarAlumnoId(int codigo);	
}
