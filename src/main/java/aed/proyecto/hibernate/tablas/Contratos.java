package aed.proyecto.hibernate.tablas;

import java.util.Date;
import javax.persistence.*;

/**
 * @author Ayoze Amaro
 *
 */
@Entity
@Table(name = "contratos")
public class Contratos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11)")
	private int codContrato;

	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name = "codDNIoNIE")
	private Futbolistas futbolistaXXX;
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name = "codEquipo")
	private Equipos equipoXXX;

	@Column(columnDefinition = "date")
	private Date fechaInicio;

	@Column(columnDefinition = "date")
	private Date fechaFin;

	@Column(columnDefinition = "int(11)")
	private int precioAnual;

	@Column(columnDefinition = "int(11)")
	private int precioRecision;

	public Contratos() { }
	
	public Contratos(Futbolistas futbolistaXXX, Equipos equipoXXX, Date fechaInicio, Date fechaFin, int precioAnual, int precioRecision) {
		this.futbolistaXXX = futbolistaXXX;
		this.equipoXXX = equipoXXX;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioAnual = precioAnual;
		this.precioRecision = precioRecision;
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public Futbolistas getFutbolistaXXX() {
		return futbolistaXXX;
	}

	public void setFutbolistaXXX(Futbolistas futbolistaXXX) {
		this.futbolistaXXX = futbolistaXXX;
	}
	
	public Equipos getEquipoXXX() {
		return equipoXXX;
	}

	public void setEquipoXXX(Equipos equipoXXX) {
		this.equipoXXX = equipoXXX;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecioAnual() {
		return precioAnual;
	}

	public void setPrecioAnual(int precioAnual) {
		this.precioAnual = precioAnual;
	}

	public int getPrecioRecision() {
		return precioRecision;
	}

	public void setPrecioRecision(int precioRecision) {
		this.precioRecision = precioRecision;
	}

	@Override
	public String toString() {
		return  codContrato + " | " + futbolistaXXX.getCodDNIoNIE() + " | " + equipoXXX.getCodEquipo()
				+ " | " + fechaInicio + " | " + fechaFin + " | " + precioAnual
				+ " | " + precioRecision;
	}
}
