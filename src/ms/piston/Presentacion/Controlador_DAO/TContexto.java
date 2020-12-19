/**
 * 
 */
package ms.piston.Presentacion.Controlador_DAO;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TContexto {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer Evento;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object Dato;

	public TContexto(Integer evento, Object datos) {
		Evento = evento;
		Dato = datos;
	}

	public Integer getEvento() {
		return Evento;
	}

	public void setEvento(Integer evento) {
		Evento = evento;
	}

	public Object getDato() {
		return Dato;
	}

	public void setDato(Object dato) {
		Dato = dato;
	}

}