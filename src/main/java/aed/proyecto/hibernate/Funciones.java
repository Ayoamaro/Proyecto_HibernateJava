package aed.proyecto.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author Ayoze Amaro
 *
 */
public class Funciones {
	
	private static Scanner sc = new Scanner(System.in);
	private static String pattern = "yyyy-MM-dd";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	/*
	 * --- INSERTAR EQUIPO ---
	 * Insercción de una nuevo equipo en la base de datos
	 */
	public static void insertarEquipo() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("INSERCIÓN DE UN EQUIPO");
		System.out.println("");
		System.out.print("Nombre del equipo: ");
		String nomEquipo = sc.nextLine();
		System.out.print("Código de liga: ");
		String codLiga = sc.nextLine();
		System.out.print("Localidad del equipo: ");
		String localidad = sc.nextLine();
		System.out.print("Internacional (SÍ o NO): ");
		String internacional = sc.nextLine();
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");

		boolean newInternacional = false;
		if (internacional.toLowerCase().equals("si")) {
			newInternacional = true;
		}
		Ligas ligaXXX = Utilidades.getLigaPorID(codLiga);
		Equipos equipo = new Equipos(nomEquipo, ligaXXX, null, localidad, newInternacional);
		
		try {
			sesion.beginTransaction();
			sesion.save(equipo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}
	
	/*
	 * --- INSERTAR OBSERVACIÓN DE UN EQUIPO ---
	 * Insercción de una nueva observacion en la base de datos
	 */
	public static void insertarObservacion() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("INSERCIÓN DE UNA OBSERVACIÓN");
		System.out.println("");
		System.out.print("Código de equipo: ");
		String codEquipo = sc.nextLine();
		System.out.print("Observacion para el equipo: ");
		String observaciones = sc.nextLine();
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		
		Equipos equipo = Utilidades.getEquipoPorINT(Integer.parseInt(codEquipo));
		EquiposObservaciones observacion = new EquiposObservaciones(equipo.getCodEquipo(), observaciones, equipo);
		
		try {
			sesion.beginTransaction();
			sesion.save(observacion);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}
	
	/*
	 * --- INSERTAR CONTRATO ---
	 * Insercción de un nuevo contrato en la base de datos
	 */
	public static void insertarContrato() throws ParseException {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("INSERCIÓN DE UN CONTRATO");
		System.out.println("");
		System.out.print("DNI del futbolista: ");
		String dni = sc.nextLine();
		System.out.print("Código del equipo: ");
		String codEquipo = sc.nextLine();
		System.out.print("Fecha de inicio (yyyy-MM-dd): ");
		String fechaComienzo = sc.nextLine();
		System.out.print("Fecha de final (yyyy-MM-dd): ");
		String fechaFinal = sc.nextLine();
		System.out.print("Precio anual: ");
		String precioAnualString = sc.nextLine();
		System.out.print("Precio recisión: ");
		String precioRecisionString = sc.nextLine();
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		
		Date fechaFin = simpleDateFormat.parse(fechaFinal);
		Date fechaInicio = simpleDateFormat.parse(fechaComienzo);
		Equipos equipoXXX = Utilidades.getEquipoPorINT(Integer.parseInt(codEquipo));
		Futbolistas futbolistaXXX = Utilidades.getFutbolistaPorDNI(dni);

		Contratos contrato = new Contratos(futbolistaXXX, equipoXXX, fechaInicio, fechaFin, Integer.parseInt(precioAnualString), Integer.parseInt(precioRecisionString));
		try {
			sesion.beginTransaction();
			sesion.save(contrato);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}

	
	
	/*
	 * --- INSERTAR LIGA ---
	 * Insercción de una nueva liga en la base de datos
	 */
	public static void insertarLiga() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("INSERCIÓN DE UNA LIGA");
		System.out.println("");
		System.out.print("Código de la liga: ");
		String codLiga = sc.nextLine();
		System.out.print("Nombre de liga: ");
		String nomLiga = sc.nextLine();
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		
		Ligas liga = new Ligas(codLiga, nomLiga);
		try {
			sesion.beginTransaction();
			sesion.save(liga);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}
	
	/*
	 * --- INSERTAR FUTBOLISTA ---
	 * Insercción de un nuevo futbolista en la base de datos
	 */
	public static void insertarFutbolista() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("INSERCIÓN DE UN FUTBOLISTA");
		System.out.println("");
		System.out.print("DNI: ");
		String codDNIoNIE = sc.nextLine();
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Nacionalidad: ");
		String nacionalidad = sc.nextLine();
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		
		Futbolistas futbolista = new Futbolistas(codDNIoNIE, nombre, nacionalidad);
		try {
			sesion.beginTransaction();
			sesion.save(futbolista);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
	}
	
	/*
	 * --- BORRAR EQUIPO ---
	 * Borrado de un equipo existente en la base de datos
	 */
	public static void eliminarEquipo(String idEquipo) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipos where codEquipo = " + idEquipo);
		
		try {
			sesion.beginTransaction();
			Equipos consulta = (Equipos) q.getSingleResult();
			sesion.delete(consulta);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
	}
	
	/*
	 * --- BORRAR CONTRATO ---
	 * Borrado de un contrato existente en la base de datos
	 */
	public static void eliminarContrato(String idContrato) {
		
		Session sesion  = HibernateUtil.getSessionFactory().openSession(); 
		Query q = sesion.createQuery("from Contratos where codContrato = " + idContrato);
		
		try {
			sesion.beginTransaction();
			Contratos contrato = (Contratos) q.getSingleResult();
			sesion.delete(contrato);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		sesion.close();
	}
	
	/*
	 * --- MOSTRAR CONTRATOS ---
	 * Mostrado de todos los contratos de la base de datos
	 */
	public static void listarContratos() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Contratos");
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("LISTADO DE LOS CONTRATOS");
		System.out.println("");
		try {
			List<Contratos> listaContratos = q.getResultList();
			for (Contratos contrato : listaContratos) {
				System.out.println(contrato.toString());
			}
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		sesion.close();
	}
	
	/*
	 * --- MODIFICACIÓN EQUIPO ---
	 * Modificación de un equipo existente en la base de datos
	 */
	public static void modificarEquipo(String idEquipo) {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Equipos equipo = Utilidades.getEquipoPorINT(Integer.parseInt(idEquipo));
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("EQUIPO ACTUAL");
		System.out.println("Nombre de equipo: " + equipo.getNomEquipo());
		System.out.println("Código de liga: " + equipo.getLigaXXX().getCodLiga());
		System.out.println("Localidad: " + equipo.getLocalidad());
		System.out.println("Internacional: " + equipo.isInternacional());
		System.out.println("-------------------------");
		System.out.println("MODIFICACIÓN DEL EQUIPO (" + idEquipo +")");
		System.out.print("Nombre: ");
		String nomEquipo = sc.nextLine();
		System.out.print("Código de liga: ");
		String codLiga = sc.nextLine();
		System.out.print("Localidad: ");
		String localidad = sc.nextLine();
		System.out.print("Internacional (SÍ o NO): ");
		String internacional = sc.nextLine();
		System.out.println("-------------------------");
		System.out.println("");

		boolean newInternacional = false;
		if (internacional.toLowerCase().equals("si")) {
			newInternacional = true;
		}
		
		equipo.setNomEquipo(nomEquipo);
		equipo.setLigaXXX(Utilidades.getLigaPorID(codLiga));
		equipo.setInternacional(newInternacional);
		equipo.setLocalidad(localidad);
		
		try {
			sesion.beginTransaction();
			sesion.update(equipo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
	}
	
	/*
	 * --- MODIFICACIÓN CONTRATO ---
	 * Modificación de un contrato existente en la base de datos
	 */
	public static void modificarContrato(String idContrato) throws ParseException {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Contratos contrato = Utilidades.getContratoPorINT(Integer.parseInt(idContrato));
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("CONTRATO ACTUAL");
		System.out.println("DNI: " + contrato.getFutbolistaXXX().getCodDNIoNIE());
		System.out.println("Código del equipo: " + contrato.getEquipoXXX().getCodEquipo());
		System.out.println("Fecha de inicio: " + contrato.getFechaInicio());
		System.out.println("Fecha de final: " + contrato.getFechaFin());
		System.out.println("Precio anual: " + contrato.getPrecioAnual());
		System.out.println("Precio recisión: " + contrato.getPrecioRecision());
		System.out.println("-------------------------");
		System.out.println("MODIFICACIÓN DEL CONTRATO (" + idContrato +")");
		System.out.print("DNI del futbolista: ");
		String dni = sc.nextLine();
		System.out.print("Código del equipo: ");
		String codEquipo = sc.nextLine();
		System.out.print("Fecha de inicio (yyyy-MM-dd): ");
		String fechaComienzo = sc.nextLine();
		System.out.print("Fecha de final (yyyy-MM-dd): ");
		String fechaFin = sc.nextLine();
		System.out.print("Precio anual: ");
		String precioAnual = sc.nextLine();
		System.out.print("Precio recisión: ");
		String precioRecision = sc.nextLine();
		System.out.println("-------------------------");
		System.out.println("");

		Date fechaInicio = simpleDateFormat.parse(fechaComienzo);
		Date fechaFinal = simpleDateFormat.parse(fechaFin);
		Equipos equipoXXX = Utilidades.getEquipoPorINT(Integer.parseInt(codEquipo));
		Futbolistas futbolistaXXX = Utilidades.getFutbolistaPorDNI(dni);
		
		contrato.setFutbolistaXXX(futbolistaXXX);
		contrato.setEquipoXXX(equipoXXX);
		contrato.setFechaInicio(fechaInicio);
		contrato.setFechaFin(fechaFinal);
		contrato.setPrecioAnual(Integer.parseInt(precioAnual));
		contrato.setPrecioRecision(Integer.parseInt(precioRecision));

		try {
			sesion.beginTransaction();
			sesion.update(contrato);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
	}

	/*
	 * --- MOSTRAR EQUIPOS ---
	 * Mostrado de todos los equipos de la base de datos
	 */
	public static void listarEquipos() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipos");
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("LISTADO DE LOS EQUIPOS");
		System.out.println("");
		try {
			List<Equipos> listaEquipos = q.getResultList();
			for (Equipos equipo : listaEquipos) {
				System.out.println(equipo.toString());
			}
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		sesion.close();
	}

	/*
	 * --- MOSTRAR TODO ---
	 * Mostrado de todos los equipos, contratos, futbolistas y observaciones del equipo
	 */
	public static void listarTodo() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipos");
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("LISTADO DE LOS EQUIPOS Y SUS CONTRATOS");
		System.out.println("");
		
		try {
			List<Equipos> listaEquipos = q.getResultList();
			
			for (Equipos equipo : listaEquipos) {
				System.out.println(equipo.toString());
				System.out.print("\t- Liga: ");
				System.out.println(equipo.getLigaXXX().toString());
				System.out.print("\t- Contratos: ");
				List<Contratos> contratos = equipo.getContratos();
				for (Contratos contrato : contratos) {
					System.out.println(contrato.toString());
					Futbolistas futbolista = contrato.getFutbolistaXXX();
					System.out.print("\t- Futbolista: ");
					System.out.println(futbolista.toString());
				}

				EquiposObservaciones ob = equipo.getEquipoObservacionXXX();
				if (ob != null) {
					System.out.print("\t- Observación: ");
					System.out.println(ob.toString());
				}
				System.out.println("");
			}
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		sesion.close();
	}
}
