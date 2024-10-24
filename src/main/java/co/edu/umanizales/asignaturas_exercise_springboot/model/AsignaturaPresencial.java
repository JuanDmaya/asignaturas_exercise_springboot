package co.edu.umanizales.asignaturas_exercise_springboot.model;

import java.util.List;

public class AsignaturaPresencial extends Asignatura {

    public AsignaturaPresencial(String codigo, String nombre, List<String> estudiantes) {
        super(codigo, nombre, estudiantes);
    }

    @Override
    public boolean esVirtual() {
        return false;
    }
}