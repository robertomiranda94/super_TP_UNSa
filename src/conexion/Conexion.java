package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	Connection conn = null;
	Statement stmt = null;

	public Conexion() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		// org.postgresql.Driver
		final String DB_URL = "jdbc:mysql://localhost:3306/super";

		final String USER = "root";
		final String PASS = "";
		
		

		try {
			
			Class.forName(JDBC_DRIVER);

		
			System.out.println("conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (Exception e) {
			System.out.println(e + "error al conectar");
		}

	}


	public ResultSet traerConsulta(String sql) throws SQLException {
	
		System.out.println("***Cargando*****");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public void agregarConsulta(String sql) throws SQLException {
	
		System.out.println("***Cargando*****");
		stmt =conn.createStatement();
		stmt.executeUpdate(sql);
			
		
	};

}
