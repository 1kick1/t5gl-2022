package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	//actualizar los datos del usuario registrado
	public static void main(String[] args) {
		//conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
			
		//proceso -> reg, act, eli --> transacciones
		em.getTransaction().begin();
			
		//obj a actualizar
		//Usuario u = new Usuario(1, "Juan", "Perez", "jperez", "555", "2000/10/05", 2, 1);
		Usuario u = new Usuario(1, "Juan", "Perez", "jperez", "789", "2000/10/05", 2, 1, null);
		em.merge(u); //busca -->actualiza si existe / registra si no existe!!
		System.out.println("Usuario actualizado");
		
		em.getTransaction().commit();
		
		em.close();
	}
}