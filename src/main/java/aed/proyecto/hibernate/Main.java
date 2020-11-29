package aed.proyecto.hibernate;

import java.util.Scanner;

/**
 * @author Ayoze Amaro
 *
 */
public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static boolean salir = false;

	public static void main(String[] args) {
		
		while (salir == false) {
			System.out.println("¡Bienvenido al Proyecto Hibernate de Java!");
			menuPrincipal();
		}
	}
	
	private static void menuPrincipal() {
		try {
			System.out.println("");
			System.out.println("OPCIONES DISPONIBLES");
			System.out.println("1. Insertar Equipo");
			System.out.println("2. Insertar Equipo con Observación");
			System.out.println("3. Insertar Contrato");
			System.out.println("4. Insertar Liga");
			System.out.println("5. Insertar Futbolista");
			System.out.println("6. Elimina Equipo");
			System.out.println("7. Actualiza Equipo");
			System.out.println("8. Elimina Contrato");
			System.out.println("9. Actualiza Contrato");
			System.out.println("10. Visualizar Equipos");
			System.out.println("11. Visualizar todos los Equipos, Contratos, Futbolistas etc.");
			System.out.print("Opción: ");
			String select = sc.nextLine();
			System.out.println("");

			switch (select) {
				case "1":
					Funciones.insertarEquipo();
					break;
				case "2":
					Funciones.insertarObservacion();
					break;
				case "3":
					Funciones.insertarContrato();
					break;
				case "4":
					Funciones.insertarLiga();
					break;
				case "5":
					Funciones.insertarFutbolista();
					break;
				case "6":
					Funciones.listarEquipos();
					System.out.print("Elige el equipo a borrar: ");
					String codEquipoBorrar = sc.nextLine();
					Funciones.eliminarEquipo(codEquipoBorrar);
					System.out.println("");
					break;
				case "7":
					Funciones.listarEquipos();
					System.out.print("Elige el equipo a modificar: ");
					String codEquipoModificar = sc.nextLine();
					Funciones.modificarEquipo(codEquipoModificar);
					break;
				case "8":
					Funciones.listarContratos();
					System.out.print("Elige el contrato a borrar: ");
					String codContratoBorrar = sc.nextLine();
					Funciones.eliminarContrato(codContratoBorrar);
					System.out.println("");
					break;
				case "9":
					Funciones.listarContratos();
					System.out.print("Elige el contrato a modificar: ");
					String codContratoModificar = sc.nextLine();
					Funciones.modificarContrato(codContratoModificar);
					System.out.println("");
					break;
				case "10":
					Funciones.listarEquipos();
					break;
				case "11":
					Funciones.listarTodo();
					break;
				case "12":
					salir = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					salir = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
}
