/**
 * 
 */
package ms.piston.Negocio.FactoriaSA.imp;

import ms.piston.Negocio.Empleado.ServicioEmp;
import ms.piston.Negocio.Empleado.imp.ServicioEmpImp;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Factura.SAFactura;
import ms.piston.Negocio.Factura.imp.SAFacturaImp;
import ms.piston.Negocio.Cliente.SACliente;
import ms.piston.Negocio.Cliente.imp.SAClienteImp;
import ms.piston.Negocio.Departamentos.ServicioDepartamento;
import ms.piston.Negocio.Departamentos.imp.ServicioDepartamentoImp;
import ms.piston.Negocio.Producto.SAProducto;
import ms.piston.Negocio.Producto.imp.SAProductoImp;
import ms.piston.Negocio.Proyecto.ServicioProyecto;
import ms.piston.Negocio.Proyecto.imp.ServicioProyectoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAImp extends FactoriaSA {
	/** 
	 * (sin Javadoc)
	 * @see FactoriaSA#generarSACLiente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACliente generarSACLiente() {

		return new SAClienteImp();
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSA#generarSAProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAProducto generarSAProducto() {

		return new SAProductoImp();
	}

	@Override
	public SAFactura generarSAFactura() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new SAFacturaImp();
	}
	
	public ServicioDepartamento generarServicioDepartamento() {
		
		return new ServicioDepartamentoImp();
	}

	@Override
	public ServicioProyecto generarServicioProyecto() {
		// TODO Auto-generated method stub
		return new ServicioProyectoImp();
	}

	@Override
	public ServicioEmp generarServicioEmpleado() {
		return new ServicioEmpImp();
	}

}