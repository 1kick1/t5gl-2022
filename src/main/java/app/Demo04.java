package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	//obtener todos los datos de un usuario según su codigo
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//proceso -> consulta --> select * from tb_xx where xx ->obj de usuario
		Usuario u = em.find(Usuario.class, 2);
		if(u==null) {
			System.out.println("usuario no encontrado");
		} else {
			System.out.println("usuario encontrado");
			System.out.println(u);
		}
		
		em.close();
	}
}
