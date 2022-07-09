package Models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import conexion.Conexion;

public class Carrito {
	
	private ArrayList<Producto> arrayProducto;

	public Carrito() {
		
		this.arrayProducto = new ArrayList<Producto>();
	}
	
	public void agragarProducto(Producto p) {
		this.arrayProducto.add(p);
	}
	
public void recorrerCarrito() {
		
		for (int i=0;i<this.arrayProducto.size();i++) {
			
		System.out.println(arrayProducto.get(i).toString());
			
		}
		
	}
		
	
	
public String detalle() {
	
	String cadena = "";
	for (int i=0;i<this.arrayProducto.size();i++) {
		
	    cadena = cadena+arrayProducto.get(i).toString()+"\n";
		
	}
	
	return cadena;
	
}
	
	
	
	public void autorizarCompra(Usuario usuario) throws SQLException {
		String sql;
		double total=0;
		Calendar fecha = new GregorianCalendar();
		
		int anio = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    String fechaActual=anio+"-"+mes+"-"+dia;
	    
	    for (int i=0; i<this.arrayProducto.size(); i++) {
	    	total +=(arrayProducto.get(i)).getPrecio()*arrayProducto.get(i).getCantidad();
	    }
	    
	    String detalle = detalle();
	 
			
		sql = "insert into venta values (null,"+
				fechaActual+",'"+detalle+"','"+total+"',"+usuario.getId()+");";
			
			//System.out.println(sql);
			
		Conexion conexion = new Conexion();
		conexion.agregarConsulta(sql);
		System.out.println("Compra realizada exitosamente");
	}
}
