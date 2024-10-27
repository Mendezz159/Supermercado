/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class Cliente extends Thread {
    private String nombre;
    private ArrayList<Producto> carrito; // Usar ArrayList en lugar de array
    private Cajera cajera;

    public Cliente(String nombre, ArrayList<Producto> carrito, Cajera cajera) {
        this.nombre = nombre;
        this.carrito = carrito;
        this.cajera = cajera;
    }

    @Override
    public void run() {
        cajera.cobrar(this);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
}