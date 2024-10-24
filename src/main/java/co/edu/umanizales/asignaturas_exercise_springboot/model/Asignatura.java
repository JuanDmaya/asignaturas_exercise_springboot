package co.edu.umanizales.asignaturas_exercise_springboot.model;

import java.util.List;

public abstract class Asignatura {
    private String codigo;
    private String nombre;
    private List<String> estudiantes;

    public Asignatura(String codigo, String nombre, List<String> estudiantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public abstract boolean esVirtual();
}
