package pkgConexion;

import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.io.FileInputStream;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar() {
		
		Properties prop = new Properties();
		InputStream input = null;
		Connection con = null;
		String dbgestor,server,port,database,user,password;
		
		try {
			//cargamos el archivo de configuracion
			input = new FileInputStream("src/main/java/config.properties");
			prop.load(input);
			
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
