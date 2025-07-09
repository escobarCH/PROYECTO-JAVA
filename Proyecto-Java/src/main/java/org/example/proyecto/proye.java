package org.example.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class proye {

    Scanner sc = new Scanner(System.in);
    List<Jugador> jugadores = new ArrayList<>();
    Map<Integer, Jugador> mapaCamisas = new HashMap<>();

    int opcion;
        do {
        System.out.println("\nGestión de Jugadores");
        System.out.println("1. Registrar jugador");
        System.out.println("2. Mostrar todos");
        System.out.println("3. Buscar por número de camiseta");
        System.out.println("4. Salir");
        System.out.print("Ingrese opción: ");
        opcion = leerEntero(sc);

        switch (opcion) {
            case 1:
                registrarJugador(sc, jugadores, mapaCamisas);
                break;
            case 2:
                mostrarTodos(jugadores);
                break;
            case 3:
                buscarPorCamisa(sc, mapaCamisas);
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    } while (opcion != 4);

        sc.close();
}

private static int leerEntero(Scanner sc) {
    while (true) {
        try {
            int valor = Integer.parseInt(sc.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            System.out.print("Entrada inválida. Intente de nuevo: ");
        }
    }
}

private static void registrarJugador(Scanner sc,
                                     List<Jugador> jugadores,
                                     Map<Integer, Jugador> mapaCamisas) {
    System.out.print("ID jugador (entero): ");
    int id = leerEntero(sc);

    System.out.print("Nombre completo: ");
    String nombre = sc.nextLine().trim();

    System.out.print("Número de camiseta: ");
    int numero = leerEntero(sc);
    if (mapaCamisas.containsKey(numero)) {
        System.out.println("Ya existe un jugador con el número " + numero);
        return;
    }

    System.out.print("Posición (Portero, Defensa…): ");
    String posicion = sc.nextLine().trim();

    System.out.print("Equipos previos (separados por comas): ");
    List<String> equipos = new ArrayList<>();
    String linea = sc.nextLine().trim();
    if (!linea.isEmpty()) {
       
        equipos.addAll(Arrays.asList(parts));
    }

    System.out.print("Número total de lesiones: ");
    int lesiones = leerEntero(sc);

    LocalDate fechaRegistro = LocalDate.now();

    Jugador j = new Jugador(id, nombre, numero, posicion, equipos, lesiones, fechaRegistro);
    jugadores.add(j);
    mapaCamisas.put(numero, j);

    System.out.println("👉 Jugador registrado correctamente.");
}

private static void mostrarTodos(List<Jugador> jugadores) {
    if (jugadores.isEmpty()) {
        System.out.println("No hay jugadores registrados.");
        return;
    }
    System.out.println("\n--- Jugadores Registrados ---");
    for (Jugador j : jugadores) {
        System.out.println(j);
        System.out.println("-----------------------------");
    }
}

private static void buscarPorCamisa(Scanner sc, Map<Integer, Jugador> mapaCamisas) {
    System.out.print("Ingrese número de camiseta a buscar: ");
    int numero = leerEntero(sc);
    Jugador j = mapaCamisas.get(numero);
    if (j != null) {
        System.out.println("\n--- Datos del Jugador ---");
        System.out.println(j);
        System.out.println("--------------------------");
    } else {
        System.out.println("No se encontró un jugador con ese número.");
    }
}

