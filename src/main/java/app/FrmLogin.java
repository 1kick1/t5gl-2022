package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 10, 60, 13);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(80, 7, 151, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 33, 60, 13);
		contentPane.add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(80, 30, 151, 19);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(276, 6, 100, 21);
		contentPane.add(btnIngresar);
	}
	
	void ingresar() {
		//leer los campos
		String usuario =leerUsuario();
		String clave = leerClave();
		//validaciones
		
		//obtener un usuario segun los campos de usuario y clave
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//Usuario u = em.find(Usuario.class, 20);
		//select * from tb_xxx where usr_usua = ? 	and cla_usua = ? usando SQL 
		Usuario u = null;
		try {
			TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.usuario = :xusr and u.clave = :xpas", Usuario.class);
			consulta.setParameter("xusr", usuario);
			consulta.setParameter("xpas", clave);
			 u = consulta.getSingleResult(); //en caso de no encontrar un resultado lanza un Exception
			aviso("Bienvenido", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			u = null;
			aviso("Usuario no existe", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
		}
		em.close();
	}
	
	void aviso(String msg, String tit, int icono) {
		JOptionPane.showMessageDialog(this, msg, tit, icono);
	}

	private String leerClave() {
		// TODO Auto-generated method stub
		return String.valueOf(txtClave.getPassword());
	}

	private String leerUsuario() {
		// TODO Auto-generated method stub
		return txtUsuario.getText();
	}
}
