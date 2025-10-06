package com.n3mphis.gestordetareas.ui;

import com.n3mphis.gestordetareas.model.Tarea;
import com.n3mphis.gestordetareas.service.GestorDeTareas;

import java.util.Scanner;

public class GUI {
    private boolean continuar = true;
    private Scanner sc = new Scanner(System.in);
    private GestorDeTareas gdt = new GestorDeTareas();

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
//                    case 2:
//                        manejarMostrarTareas();
//                        break;
//                    case 3:
//                        manejarEliminarTarea();
//                        break;
//                    case 4:
//                        manejarMarcarCompleta();
//                        break;
//                    case 5:
//                        manejarModificarDesc();
//                        break;
                    case 6:
                        System.out.println("Muchas Gracias por usar el programa! Adiós");
                        continuar = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error de entrada! Por favor, ingrese un número");
            }
        }
    }

    public void menu() {
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
    }

    public void manejarAgregarTarea() {
        System.out.println("Ingrese la descripcion de su tarea");
        System.out.print("-> ");
        String desc = sc.nextLine();

        Tarea tarea = gdt.agregarTarea(desc);

        System.out.println("✅ Tarea agregada con éxito!" + "\nID asignado: " + tarea.getId());
    }

}
