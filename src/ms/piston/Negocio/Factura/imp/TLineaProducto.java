package ms.piston.Negocio.Factura.imp;

public class TLineaProducto {

	
	private Integer cantidad;
	private double Precio;
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	@Override
	public String toString() {
		return "TLineaProducto [cantidad=" + cantidad + ", Precio=" + Precio
				+ "]";
	}
	
}
