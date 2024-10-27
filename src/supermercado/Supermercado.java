/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class Supermercado {
    public static void main(String[] args) {
        // Crear algunos productos
        Producto manzana = new Producto("Manzana", 0.50);
        Producto pan = new Producto("Pan", 1.00);
        Producto leche = new Producto("Leche", 0.80);
        Producto arroz = new Producto("Arroz", 1.50);

        // Crear la cajera
        Cajera cajera = new Cajera();

        // Crear carritos de clientes usando ArrayList
        ArrayList<Producto> carritoCliente1 = new ArrayList<>();
        carritoCliente1.add(manzana);
        carritoCliente1.add(pan);
        carritoCliente1.add(leche);

        ArrayList<Producto> carritoCliente2 = new ArrayList<>();
        carritoCliente2.add(arroz);
        carritoCliente2.add(manzana);

        ArrayList<Producto> carritoCliente3 = new ArrayList<>();
        carritoCliente3.add(leche);
        carritoCliente3.add(pan);
        carritoCliente3.add(arroz);

        // Crear algunos clientes con sus carritos
        Cliente cliente1 = new Cliente("Juan", carritoCliente1, cajera);
        Cliente cliente2 = new Cliente("María", carritoCliente2, cajera);
        Cliente cliente3 = new Cliente("Carlos", carritoCliente3, cajera);

        // Iniciar el proceso de cobro de cada cliente en un hilo separado
        cliente1.start();
        cliente2.start();
        cliente3.start();

        // Esperar a que todos los hilos terminen
        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los clientes han sido atendidos.");
    }
}
