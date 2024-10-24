package co.edu.umanizales.asignaturas_exercise_springboot.service;

import co.edu.umanizales.asignaturas_exercise_springboot.model.Asignatura;
import co.edu.umanizales.asignaturas_exercise_springboot.model.AsignaturaPresencial;
import co.edu.umanizales.asignaturas_exercise_springboot.model.AsignaturaVirtual;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaService {

    private List<Asignatura> asignaturas = new ArrayList<>();

    public AsignaturaService() {
        
        asignaturas.add(new AsignaturaPresencial("MAT101", "Matemáticas", List.of("Juan Pérez", "Ana Gómez")));
        asignaturas.add(new AsignaturaVirtual("INF202", "Informática", List.of("Carlos Díaz", "Lucía Méndez")));
        asignaturas.add(new AsignaturaPresencial("HIS303", "Historia", List.of("Roberto Rodríguez", "Carla Fernández")));
    }

    public Asignatura obtenerAsignaturaPorCodigo(String codigo) {
        return asignaturas.stream()
                .filter(asignatura -> asignatura.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }


    public List<String> obtenerEstudiantesPorLetra(String letra) {
        return asignaturas.stream()
                .filter(asignatura -> !asignatura.esVirtual())
                .flatMap(asignatura -> asignatura.getEstudiantes().stream())
                .filter(estudiante -> estudiante.startsWith(letra) || estudiante.endsWith(letra))
                .collect(Collectors.toList());
    }
}
