package Models;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;

public class Registro {
		
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;

	
	
	
	public Registro(String nombre, String apellido, String email, String contrasenia, boolean tieneTarjeta,
			int idTipodeusuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public Registro() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingresar nombre: ");
		this.nombre = sc.nextLine();
		System.out.println("Ingresar apellido: ");
		this.apellido = sc.nextLine();
		System.out.println("Ingresar mail: ");
		this.email = sc.nextLine();
		System.out.println("Ingresar contraseña: ");
		this.contrasenia = sc.nextLine();

	}

	public  void validaDatos() throws SQLException {

		if (this.nombre != "" && this.apellido != "" 
			&& this.email != "" && this.contrasenia != "") {
			
			String sql = "insert into usuario values(null,"+"'"+this.nombre+"',"+
					"'"+this.apellido+"',"+"'"+this.email+"',"+"'"+this.contrasenia	+"',"+"false,1);";

			Conexion conexion =new Conexion();
			conexion.agregarConsulta(sql);
			
			System.out.println("Usuario registrado exitosamente");
			

				
		}else {
			System.out.println("Error al ingresar los datos");
		}

	}
}
