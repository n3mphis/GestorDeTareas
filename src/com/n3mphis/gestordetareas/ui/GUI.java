package com.n3mphis.gestordetareas.ui;

import com.n3mphis.gestordetareas.model.Tarea;
import com.n3mphis.gestordetareas.service.GestorDeTareas;

import java.util.Collection;
import java.util.Scanner;

public class GUI {
    private boolean continuar = true;
    private Scanner sc;
    private GestorDeTareas gdt;

    public GUI(GestorDeTareas gdt) {
        this.gdt = gdt;
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        while (continuar) {
            menu();
            try {
                int eleccion = sc.nextInt();
                sc.nextLine();
                switch (eleccion) {
                    case 1:
                        manejarAgregarTarea();
                        break;
                    case 2:
                        manejarMostrarTareas();
                        break;
                    case 3:
                        manejarEliminarTarea();
                        break;
                    case 4:
                        manejarMarcarCompleta();
                        break;
                    case 5:
                        manejarModificarDesc();
                        break;
                    case 6:
                        System.out.println("Muchas Gracias por usar el programa! Adiós");
                        continuar = false;
                        break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Error de entrada! Por favor, ingrese un número");
            }
        }
    }

    private void menu() {
        System.out.println("""
                ******************************
                Bienvenido al Gestor De Tareas
                ******************************
                
                1) Agregar Tarea
                2) Mostrar todas las tareas
                3) Eliminar Tarea
                4) Marcar Tarea Completada
                5) Modificar Descripción de Tarea
                
                6) Salir
                """);

        System.out.println("Ingrese su elección");
        System.out.print("-> ");
    }

    private void manejarAgregarTarea() {
        System.out.println("Ingrese la descripcion de su tarea");
        System.out.print("-> ");
        String desc = sc.nextLine();

        Tarea tarea = gdt.agregarTarea(desc);

        System.out.println("✅ Tarea agregada con éxito!" + "\nID asignado: " + tarea.getId());
    }

    private void manejarMostrarTareas() {
        Collection<Tarea> tareas = gdt.obtenerTodasLasTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas agregadas!");
            return;
        }
        for (Tarea tarea : tareas) {
            System.out.println(tarea.toString());
        }
    }

    private void manejarEliminarTarea() {
        System.out.println("Ingrese el ID de la tarea a eliminar");
        System.out.print("-> ");
        long idEliminar = sc.nextLong();
        sc.nextLine();
        boolean exito = gdt.eliminarTarea(idEliminar);

        if (exito) {
            System.out.println("Tarea eliminada con exito!");
        } else {
            System.out.println("La tarea con ID " + idEliminar + " no existe.");
        }
    }

    private void manejarMarcarCompleta() {
        System.out.println("Ingrese el ID para marcar la tarea completada");
        System.out.print("-> ");
        long idMarcar = sc.nextLong();
        sc.nextLine();

        boolean exito = gdt.marcarTareaCompletada(idMarcar);

        if (exito) {
            System.out.println("Tarea marcada como Completada con éxito!");
        } else {
            System.out.println("Tarea con ID #" + idMarcar + " no pudo ser marcada como completa (ID incorrecto o ya estaba completa");
        }
    }

    private void manejarModificarDesc() {
        System.out.println("Ingrese el ID de la tarea a modificar");
        System.out.print("-> ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingrese la nueva descripción");
        System.out.print("-> ");
        String nuevaDesc = sc.nextLine();
        boolean exito = gdt.modificarDescripcion(id, nuevaDesc);

        if (exito) {
            System.out.println("La tarea con el ID #" + id + " ha cambiado de descripción");
        } else {
            System.out.println("La tarea con el ID #" + id + " no existe.");
        }
    }

}
