package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	//registrar los datos de un nuevo usuario
	public static void main(String[] args) {
		//establecer conexion -> con la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		//crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//proceso -> reg, act, eli --> transacciones
		em.getTransaction().begin();
		
		//obj a grabar
		//Usuario u = new Usuario(1, "Juan Carlos", "Perez Lopez", "jperezl", "123", "2000/10/05", 1, 1);
		Usuario u = new Usuario(2, "Maria", "Cruz", "jcruz", "555", "2001/10/05", 2, 1, null);
		em.persist(u); //insertar
		
		System.out.println("Grabacion ok");
		
		//confirmar la transaccion
		em.getTransaction().commit();
		
		//cerrar
		em.close();
	}
}
