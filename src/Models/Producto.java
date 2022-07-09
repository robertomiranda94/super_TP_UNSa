package Models;

public class Producto {
	private int id;
	private String nombre;
	private int cantidad;
	private String fechadevencimiento;
	private double precio;
	
	
	
	

	public Producto(int id, String nombre, int cantidad, String fechadevencimiento, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechadevencimiento = fechadevencimiento;
		this.precio = precio;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechadevencimiento() {
		return fechadevencimiento;
	}

	public void setFechadevencimiento(String fechadevencimiento) {
		this.fechadevencimiento = fechadevencimiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", Stock=" +  ", cantidad=" + cantidad
				+ ", fechadevencimiento=" + fechadevencimiento + ", precio=" + precio + "]";
	}

}
