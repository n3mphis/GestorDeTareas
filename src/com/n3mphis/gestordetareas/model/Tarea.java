package com.n3mphis.gestordetareas.model;

import java.util.Objects;

public class Tarea {
    private String descripcion;
    private EstadoTarea estado;
    private Long id;

    public Tarea(String descripcion, Long id) {
        this.descripcion = descripcion;
        this.id = id;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return "Descripción de la tarea: " + descripcion +"\n" +
                "Estado: " + estado + "\n" +
                "ID: " + id + "\n";
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(descripcion, tarea.descripcion) && estado == tarea.estado && Objects.equals(id, tarea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, estado, id);
    }
}
