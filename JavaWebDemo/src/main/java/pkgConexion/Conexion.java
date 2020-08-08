package pkgConexion;

import java.util.Properties;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar() {
		
		Properties prop = new Properties();
		Connection con = null;
		String dbgestor,server,port,database,user,password;
		
		try {
			
			//fileReader = lee caracter por caracter un archivo que contiene texto
			//BufferedReader = le ayuda a obtener toda una linea de caracteres y potencia para ser mas rapida la lectura  
			FileReader fileConfigurcion =  new FileReader("src/main/java/config.properties");
			BufferedReader leerPropiedades = new BufferedReader(fileConfigurcion);
			prop.load(leerPropiedades);
			
			//obtenemos las propiedades del rchivo de configuracion
			dbgestor = prop.getProperty("dbgestor");
			server = prop.getProperty("server");
			port = prop.getProperty("port");
			database = prop.getProperty("database");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			// jdbc:mysql://localhost:3306/java,root,"");
			con = DriverManager.getConnection("jdbc:"+dbgestor+"://"+server+":"+port+"/"+database,user,password);
		
		}catch(Exception e){
			System.out.println("[X] CONEXION FALLIDA[X]");
			e.printStackTrace();
		}
		
		return con;
	}
}
