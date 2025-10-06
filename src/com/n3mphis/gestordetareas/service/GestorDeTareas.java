package com.n3mphis.gestordetareas.service;

import com.n3mphis.gestordetareas.model.Tarea;

import java.util.HashMap;
import java.util.Map;

public class GestorDeTareas {
    private Map<Long, Tarea> tareas = new HashMap<>();
    private Long proximoId = 1L;

    public Tarea agregarTarea(String descripcion) {
        long idActual = this.proximoId;
        this.proximoId++;
        Tarea tarea = new Tarea(descripcion, idActual);
        tareas.put(idActual, tarea);

        System.out.println("Tarea #" + idActual + " agregada correctamente.");

        return tarea;
    }


}
