package aed.proyecto.hibernate;

import java.util.Scanner;

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
			System.out.println("10. Mostrar Equipos");
			System.out.println("11. Mostrar todo");
			System.out.print("Opción: ");
			String select = sc.nextLine();
			System.out.println("");

			switch (select) {
				case "1":
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "6":
					break;
				case "7":
					break;
				case "8":
					break;
				case "9":
					break;
				case "10":
					break;
				case "11":
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
