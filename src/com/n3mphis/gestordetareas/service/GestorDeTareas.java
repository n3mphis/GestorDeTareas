package com.n3mphis.gestordetareas.service;

import com.n3mphis.gestordetareas.model.EstadoTarea;
import com.n3mphis.gestordetareas.model.Tarea;

import java.util.ArrayList;
import java.util.Collection;
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

        return tarea;
    }

    public Collection<Tarea> obtenerTodasLasTareas() {
        return new ArrayList<>(this.tareas.values());
    }

    public boolean eliminarTarea(Long id) {
        return tareas.remove(id) != null;
    }

    public boolean marcarTareaCompletada(Long id) {
        Tarea tarea = tareas.get(id);

        if (tarea != null && tarea.getEstado() != EstadoTarea.COMPLETADO) {
            tarea.setEstado(EstadoTarea.COMPLETADO);
            return true;
        }
        return false;
    }

    public boolean modificarDescripcion(Long id, String descripcion) {
        Tarea tarea = tareas.get(id);
        if (tarea != null) {
            tarea.setDescripcion(descripcion);
            return true;
        }
        return false;
    }
}
