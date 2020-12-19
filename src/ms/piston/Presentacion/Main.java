package ms.piston.Presentacion;

import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Inicio.VLoading;

public class Main {

	public static void main(String[] args) {

        VLoading vLoading = new VLoading();
		Controller.ObtenerInstancia().accion("crear VInicio", null);
        vLoading.dispose();

        /*
         *
         *
         * ########### TEST-ZONE ###########
         *
         *
         */
        
      /*  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        TEmpNormal empNormal = new TEmpNormal();
        empNormal.setActivo(true);
        empNormal.setNombre("Sergio");
        empNormal.setApellidos("Pino Holgado");
        empNormal.setTelefono(636459283);
        empNormal.setNif("06338475H");
        empNormal.setEmail("sepino@ucm.es");
        empNormal.setDireccion("C/ Huertas, 2, 1A");
        empNormal.setIdDepartamento(2);
        empNormal.setSalario(234);
        Empleado emp = new Normal();

        emp.setActivo(true);
        emp.setApellidos(empNormal.getApellidos());
        emp.setDireccion(empNormal.getDireccion());
        emp.setEmail(empNormal.getEmail());
        emp.setIdDepartamento(empNormal.getIdDepartamento());
        emp.setNif(empNormal.getNif());
        emp.setNombre(empNormal.getNombre());
        emp.setSalario(empNormal.getSalario());
        emp.setTelefono(empNormal.getTelefono());

        et.begin();
        em.persist(emp);
        em.flush();
        et.commit();

        System.out.println("Empleado insertado: " + emp.getId());
        */
	}

}