package pkgDao;

import pkgConexion.Conexion;
import pkgModel.MdlAlumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAlumno {
	
	Connection con = null;
	String sql;
	PreparedStatement prepareConsulta;
	ResultSet resultadoDatos;
	int parametroPostgres = ResultSet.TYPE_SCROLL_SENSITIVE;
	int parametroPostgres2 = ResultSet.CONCUR_UPDATABLE;
	
	public ResultSet daoListarAlumno() {
				
		try {
			
			this.con = Conexion.conectar(); 
			this.sql = "select id,nombre,apellido,edad from alumno order by id";
			prepareConsulta = con.prepareStatement(this.sql,parametroPostgres,parametroPostgres2);
			resultadoDatos = prepareConsulta.executeQuery();
			
		}catch(SQLException sql){
			
			System.out.println("[X] ERROR : DaoAlumno -> daoListarAlumno [X]");
			System.out.println(prepareConsulta);
			sql.printStackTrace();
		}
		
		this.prepareConsulta = null;
		return resultadoDatos;
	}
	
	public void daoRegistrarAlumno(MdlAlumno paramObjalumno) {
		
		try {
			
			this.con = Conexion.conectar(); 
			this.sql = "insert into alumno(id,nombre,apellido,edad) values(?,?,?,?);";
			prepareConsulta = con.prepareStatement(this.sql);
			prepareConsulta.setInt(1,paramObjalumno.getIdAlumno());
			prepareConsulta.setString(2,paramObjalumno.getNombre());
			prepareConsulta.setString(3,paramObjalumno.getApellido());
			prepareConsulta.setInt(4,paramObjalumno.getEdad());
			
			//execute = devuelve boolea
			//ExecuteUpdate = insert, update o delete (devuelve filas afectadas)
			//ExecuteQuery = select (devuelve conjunto de datos) 
			
			int filasAfectadas = prepareConsulta.executeUpdate();
			System.out.println("\n[-] Se realizo " + filasAfectadas + " registro [-]");
						
		}catch(SQLException sql){
			System.out.println("[X] ERROR : DaoAlumno -> registrarAlumno [X]");
			System.out.println(this.prepareConsulta);
		}finally{
			this.prepareConsulta = null;
		}
	}
	
	public void daoEditarAlumno(MdlAlumno paramObjalumno) {
		try {
			
			this.con = Conexion.conectar(); 
			this.sql = "update alumno set nombre=?,apellido=?,edad=? where id = ?";
			prepareConsulta = con.prepareStatement(this.sql);
			prepareConsulta.setString(1,paramObjalumno.getNombre());
			prepareConsulta.setString(2,paramObjalumno.getApellido());
			prepareConsulta.setInt(3,paramObjalumno.getEdad());
			prepareConsulta.setInt(4,paramObjalumno.getIdAlumno());
			
			//execute = devuelve boolea
			//ExecuteUpdate = insert, update o delete (devuelve filas afectadas)
			//ExecuteQuery = select (devuelve conjunto de datos) 
			
			int filasAfectadas = prepareConsulta.executeUpdate();
			System.out.println("\n[-] Se actualizo " + filasAfectadas + " registro [-]");
						
		}catch(SQLException sql){
			System.out.println("[X] ERROR : DaoAlumno -> daoEditarAlumno [X]");
			System.out.println(this.prepareConsulta);
		}finally{
			this.prepareConsulta = null;
		}
	}
	
	public ResultSet daoBuscarAlumnoId(int codigo) {
		
		try {
			
			this.con = Conexion.conectar(); 
			this.sql = "select id,nombre,apellido,edad from alumno where id = ?";
			prepareConsulta = con.prepareStatement(this.sql,parametroPostgres,parametroPostgres2);
			prepareConsulta.setInt(1,codigo);
			resultadoDatos = prepareConsulta.executeQuery();
			
		}catch(SQLException sql){
			System.out.println("[X] ERROR : DaoAlumno -> daoBuscarAlumnoId [X]");
			System.out.println(prepareConsulta);
		}finally{
			this.prepareConsulta = null;
		}
		return resultadoDatos;
	}
	
	public void daoEliminarAlumnoId(int codigo) {
		
		try {
			
			this.con = Conexion.conectar(); 
			this.sql = "delete from alumno where id = ?";
			prepareConsulta = con.prepareStatement(this.sql);
			prepareConsulta.setInt(1,codigo);
			int filasAfectadas = prepareConsulta.executeUpdate();
			if(filasAfectadas == 0) {
				System.out.println("[-] ID NO ENCONTRADO [-]");
			}else {
				System.out.println("[-] ID ELIMINADO [-]");
			}
			//System.out.println("\n[-] Se realizo " + filasAfectadas + " registro [-]")
			
		}catch(SQLException sql){
			System.out.println("[X] ERROR : DaoAlumno -> daoEliminarAlumnoId [X]");
			System.out.println(prepareConsulta);
		}finally{
			this.prepareConsulta = null;
		}
	}
	
}
