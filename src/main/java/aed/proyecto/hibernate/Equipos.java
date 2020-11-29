package aed.proyecto.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "equipos")
public class Equipos {

	@Id
	@Column ( columnDefinition= "integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer codEquipo;
	
	@Column ( columnDefinition= "varchar(40)")
	String nomEquipo;
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="codLiga")
	private Ligas ligaXXX;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="equipoXXX")
	private List<Contratos> contratos = new ArrayList<Contratos>();
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn (name = "codEquipo") 
	private EquiposObservaciones equipoObservacionXXX;
	
	@Column ( columnDefinition= "varchar(60)")
	String localidad;
	
	@Column ( columnDefinition= "BIT")
	boolean internacional;
	
	public Equipos() { }
	
	public Equipos(String nomEquipo, Ligas ligaXXX, List<Contratos> contratos, String localidad, boolean internacional) {
		this.nomEquipo = nomEquipo;
		this.ligaXXX = ligaXXX;
		this.contratos = contratos;
		this.localidad = localidad;
		this.internacional = internacional;
	}

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public Ligas getLigaXXX() {
		return ligaXXX;
	}

	public void setLigaXXX(Ligas ligaXXX) {
		this.ligaXXX = ligaXXX;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}
	
	public EquiposObservaciones getEquipoObservacionXXX() {
		return equipoObservacionXXX;
	}

	public void setEquipoObservacionXXX(EquiposObservaciones equipoObservacionXXX) {
		this.equipoObservacionXXX = equipoObservacionXXX;
	}

	public void setCodEquipo(Integer codEquipo) {
		this.codEquipo = codEquipo;
	}
	
	@Override
	public String toString() {
		return getCodEquipo() + " | " + getNomEquipo() + " | " + getLigaXXX().getNomLiga() + " | " + getLocalidad() + " | " + isInternacional();
	}
}
