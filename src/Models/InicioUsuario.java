package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;

public class InicioUsuario {
	private Conexion conexion;
	

	public InicioUsuario() {
		conexion = new Conexion();
	}
	
	public void menu (Usuario usuario) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Bienvenido " + usuario.getNombre() + " " +
		usuario.getApellido());
		
		int condicion=0; //esta es del do while
		
		
		do {
		System.out.println("ingrese una opción:");
		System.out.println(
				"1- Elegir categoría\r\n" + 
						"2- Carrito\r\n"
						+ "3- Realizar compra");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			
			System.out.println("Categorías");
			String sql= "Select * from categoria";
			ResultSet rs =conexion.traerConsulta(sql); 
			
			while(rs.next()) {
				int id= rs.getInt("ID");
				String nombre= rs.getString("NOMBRE");
				System.out.println("Código : "+id +" " + nombre );
				
			}
			
			System.out.println("Ingrese el código de la categoría");
				int opcionCategoria =sc.nextInt();
				String sql2= "Select ID,NOMBRE,PRECIO,FECHA_VENCIMIENTO "
						+ "from productos where ID_CATEGORIA = " + "'" + opcionCategoria + "';";
				ResultSet rs2 = conexion.traerConsulta(sql2);
				
				
				while(rs2.next()) {
					int id = rs2.getInt("id");
					String nombre =rs2.getString("nombre");
					rs2.getString("fecha_vencimiento");
					double precio= rs2.getDouble("precio");
					
					System.out.println(id +" "+  nombre +" "+ precio);
					
				}
				
				System.out.println("Ingresar código del producto :");
				int codigoProducto =sc.nextInt();
				System.out.println("ingresar la cantidad");
				int cantidadProducto = sc.nextInt();
				
				String sql3 = "Select * from productos where id="+"'"+codigoProducto+"';";
				ResultSet rs3 =conexion.traerConsulta(sql3);
				
				
				if(rs3.next()) {
					int id = rs3.getInt("ID");
					String nombre = rs3.getString("NOMBRE");
					int stock = rs3.getInt("STOCK");
					String fecha = rs3.getString("FECHA_VENCIMIENTO");
					double precio = rs3.getDouble("PRECIO");
					
					if(stock > cantidadProducto) {
						Producto producto =new Producto(id, nombre, cantidadProducto, fecha, precio);
						usuario.agregaCarritoU(producto);
						System.out.println("Producto agregado");
						
					}
					
				}else {
					System.out.println("Sin stock");
				}
				
				
			break;
		case 2:
			System.out.println("Productos en el carrito de compras");
			Carrito carrito2 = usuario.getCarritoCompraU();
			carrito2.recorrerCarrito();
			break;
		case 3:
			System.out.println("Pagar");
			Carrito carrito3 = usuario.getCarritoCompraU();
			carrito3.autorizarCompra(usuario);
			break;

		default:System.out.println("Opción incorrecta");
			break;
		
		
			}
			
			
			
		System.out.println("¿Regregar al inicio?");
		System.out.println("si =1 o no= 0 ");
		condicion = sc.nextInt();

		
		}while(condicion !=0); 
			
		System.out.println("Pago Efectuado");
	
		
		
	}
	
}
