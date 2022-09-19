package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05v2 {
	//"eliminar logicamente" -->cambiando ele stado
	public static void main(String[] args) {
		//conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// obj de usuario a eliminar
		Usuario u = em.find(Usuario.class, 1);			

		if (u == null) {
			System.out.println("Usuario no encontrado");
		} else {
			// proceso --> cambiar el estado
			u.setEstado(2);
			
			em.getTransaction().begin();
			em.merge(u); 
			System.out.println("usuario deshabilitado");
			em.getTransaction().commit();	
		}
		em.close();
	}
}