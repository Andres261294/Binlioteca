package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de la Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Listar todos los libros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    Libro nuevoLibro = new Libro(titulo, autor, isbn);
                    biblioteca.agregarLibro(nuevoLibro);
                    break;

                case 2:
                    System.out.print("Ingrese el título a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    List<Libro> resultadosTitulo = biblioteca.buscarPorTitulo(tituloBusqueda);
                    if (resultadosTitulo.isEmpty()) {
                        System.out.println("No se encontraron libros con ese título.");
                    } else {
                        System.out.println("Resultados de la búsqueda por título:");
                        for (Libro libro : resultadosTitulo) {
                            System.out.println(libro);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el autor a buscar: ");
                    String autorBusqueda = scanner.nextLine();
                    List<Libro> resultadosAutor = biblioteca.buscarPorAutor(autorBusqueda);
                    if (resultadosAutor.isEmpty()) {
                        System.out.println("No se encontraron libros de ese autor.");
                    } else {
                        System.out.println("Resultados de la búsqueda por autor:");
                        for (Libro libro : resultadosAutor) {
                            System.out.println(libro);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Listado de todos los libros:");
                    biblioteca.listarLibros();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}