package aed.proyecto.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author Ayoze Amaro
 *
 */
public class Utilidades {

	/*
	 * --- 1. SELECCIONAR LIGA ---
	 * Función que devuelve una Liga según su ID
	 */
	public static Ligas getLigaPorID(String id) {
		
		Ligas resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			Ligas consulta = (Ligas) sesion.get(Ligas.class, id);
			resultado = consulta;
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}
	
	/*
	 * --- 2. SELECCIONAR EQUIPO ---
	 * Función que devuelve un Equipo según su ID
	 */
	public static Equipos getEquipoPorINT(int id) {
		
		Equipos resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Equipos where codEquipo = " + id);
		try {
			resultado = (Equipos) q.getSingleResult();

		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}
	
	/*
	 * --- 3. SELECCIONAR FUTBOLISTA ---
	 * Función que devuelve una Futbolista según su ID
	 */
	public static Futbolistas getFutbolistaPorDNI(String dni) {
		
		Futbolistas resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			Futbolistas consulta = (Futbolistas) sesion.get(Futbolistas.class, dni);
			resultado = consulta;
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}
	
	/*
	 * --- 4. SELECCIONAR CONTRATO ---
	 * Función que devuelve una Contrato según su ID
	 */
	public static Contratos getContratoPorINT(int id) {
		
		Contratos resultado = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Contratos where codContrato = " + id);
		
		try {
			resultado = (Contratos) q.getSingleResult();

		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		sesion.close();
		return resultado;
	}
}
