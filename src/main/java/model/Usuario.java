package model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Entity
@Table(name = "tb_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Usuario {
	@Id
	@Column(name = "cod_usua")
	private int codigo;
	
	@Column(name = "nom_usua", length = 15)
	private String nom;
	
	@Column(name = "ape_usua")
	private String apellido;
	
	@Column(name = "usr_usua", unique = true)
	private String usuario;
	
	@Column(name = "cla_usua")
	private String clave;
	
	@Column(name = "fna_usua")
	private String fnac;
	
	@Column(name = "idtipo")
	private int tipo;
	
	@Column(name = "est_usua")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name="idtipo", insertable = false, updatable = false)
	private Tipo objTipo; //solo me servirá para el listado y obtener información
}
