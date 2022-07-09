package controlador;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Models.InicioUsuario;
import Models.Login;
import Models.Producto;
import Models.Registro;
import Models.Usuario;
import conexion.Conexion;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Supermark 1000 programadores UNSa----");
		System.out.println("Elija una opción \r\n"+ 
				"1.- Login\r\n" + 
				"2.- Registrarse");

		int respuesta = sc.nextInt();
		sc.nextLine();
		
		
		if(respuesta == 1) {
			System.out.println("- Ingrese su email o nombre de usuario...");
			String email =sc.next();
			System.out.println("- Ingrese su contraseña...");
			String pass=sc.next();
			Login logiarse = new Login(email, pass);
			Usuario usuario = logiarse.ingresar();
			if(usuario != null) {
					if(usuario.getTipodeusuario()==1) {
						InicioUsuario inicioUsu = new InicioUsuario();
						inicioUsu.menu(usuario);
						
						
					}else {
					}
			}else{
				System.out.println("***Datos incorrectos***");
			}
		}else {
			Registro registro= new Registro();
			registro.validaDatos();
		}

		
	}

}