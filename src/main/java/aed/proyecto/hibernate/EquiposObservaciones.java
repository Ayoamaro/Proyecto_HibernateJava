package aed.proyecto.hibernate;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "equiposobservaciones")
public class EquiposObservaciones {
	
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "EquipoXXX")})
	Integer codEquipo;

	@Column(columnDefinition = "varchar(200)")
	String observaciones;
	
	@OneToOne (cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Equipos EquipoXXX;

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(Integer codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Equipos getEquipoXXX() {
		return EquipoXXX;
	}

	public void setEquipoXXX(Equipos equipoXXX) {
		EquipoXXX = equipoXXX;
	}

	@Override
	public String toString() {
		return  codEquipo + " | " + observaciones;
	}
	
	public EquiposObservaciones() {
		
	}

	public EquiposObservaciones(Integer codEquipo, String observaciones, Equipos equipoXXX) {
		this.codEquipo = codEquipo;
		this.observaciones = observaciones;
		EquipoXXX = equipoXXX;
	}
}
