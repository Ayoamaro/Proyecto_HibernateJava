package aed.proyecto.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "ligas")
public class Ligas {
	
	@Id
	@Column(columnDefinition = "char(5)")
	private String codLiga;

	@Column(columnDefinition = "varchar(50)")
	private String nomLiga;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy="ligaXXX")
	private List<Equipos> equipos = new ArrayList<Equipos>();

	public Ligas() { }

	public Ligas(String codLiga, String nomLiga) {
		this.codLiga = codLiga;
		this.nomLiga = nomLiga;
	}
	
	public String getCodLiga() {
		return codLiga;
	}

	public void setCodLiga(String codLiga) {
		this.codLiga = codLiga;
	}

	public String getNomLiga() {
		return nomLiga;
	}

	public void setNomLiga(String nomLiga) {
		this.nomLiga = nomLiga;
	}

	public List<Equipos> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return  codLiga + " | " + nomLiga;
	}
}
