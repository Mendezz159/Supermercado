/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author Usuario
 */
public class Cajera {
    public synchronized void cobrar(Cliente cliente) {
        double total = 0;
        System.out.println("Cobrando a " + cliente.getNombre() + ":");

        for (Producto producto : cliente.getCarrito()) {
            System.out.println("Escaneando producto: " + producto.getNombre() + " - Precio: " + producto.getPrecio());
            total += producto.getPrecio();
            // Simulando un tiempo de escaneo
            try {
                Thread.sleep(500); // 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Total a pagar por %s: %.2f%n", cliente.getNombre(), total);
    }
}