package aed.proyecto.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "futbolistas")
public class Futbolistas {
	
	@Id
	@Column ( columnDefinition= "char(9)")
	String codDNIoNIE;
	
	@Column ( columnDefinition= "varchar(50)")
	String nombre;
	
	@Column ( columnDefinition= "varchar(40)")
	String nacionalidad;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="futbolistaXXX")
	private List<Contratos> contratos = new ArrayList<Contratos>();
	
	public Futbolistas() { }

	public Futbolistas(String codDNIoNIE, String nombre, String nacionalidad) {
		this.codDNIoNIE = codDNIoNIE;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String toString() {
		return  codDNIoNIE + " | " + nombre + " | " + nacionalidad;
	}
}
