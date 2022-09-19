package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tb_tipos")
public class Tipo {
	@Id
	private int idtipo; //los atributos de la clase tienen los mismos nombres que los campos
	private String descripcion;
}
