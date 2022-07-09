
package Models;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private int tipodeusuario;
	private boolean tieneTarjeta;
	private Carrito carritoCompraU;

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia, int tipodeusuario,
			boolean tieneTarjeta) {
	
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.tipodeusuario = tipodeusuario;
		this.tieneTarjeta = tieneTarjeta;
		this.carritoCompraU = new Carrito();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getTipodeusuario() {
		return tipodeusuario;
	}

	public void setTipodeusuario(int tipodeusuario) {
		this.tipodeusuario = tipodeusuario;
	}

	public boolean isTieneTarjeta() {
		return tieneTarjeta;
	}

	public void setTieneTarjeta(boolean tieneTarjeta) {
		this.tieneTarjeta = tieneTarjeta;
	}

	public Carrito getCarritoCompraU() {
		return carritoCompraU;
	}

	public void setCarritoCompraU(Carrito carritoCompraU) {
		this.carritoCompraU = carritoCompraU;
	}
	
	public void agregaCarritoU(Producto prod) {
		this.carritoCompraU.agragarProducto(prod);
	}
	
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", tipodeusuario=" + tipodeusuario + ", tieneTarjeta=" + tieneTarjeta
				+ ", carritoCompraU=" + carritoCompraU + "]";
	}
}
