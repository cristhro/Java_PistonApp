/**
 * 
 */
package ms.piston.Integracion.Producto;

import java.util.Collection;

import ms.piston.Negocio.Producto.TProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOProducto {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto readByID(int id);
	
	public Boolean modificarProducto(TProducto tproducto);
	
	public Boolean eliminarProducto(Integer id);
	
	public Integer anadirProducto(TProducto tp);
	
	public Collection<TProducto> consultarProductos();
	
	public TProducto readByMarcaModeloAnoPrecioPlazasCombustibleS(TProducto p);
}