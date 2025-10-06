package com.n3mphis.gestordetareas;

import com.n3mphis.gestordetareas.service.GestorDeTareas;
import com.n3mphis.gestordetareas.ui.GUI;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas gestorDeTareas = new GestorDeTareas();
        GUI gui = new GUI(gestorDeTareas);
        gui.iniciar();
    }
}
