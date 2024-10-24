package co.edu.umanizales.asignaturas_exercise_springboot.controller;

import co.edu.umanizales.asignaturas_exercise_springboot.model.Asignatura;
import co.edu.umanizales.asignaturas_exercise_springboot.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    
    @GetMapping("/{codigo}")
    public String obtenerAsignatura(@PathVariable String codigo) {
        Asignatura asignatura = asignaturaService.obtenerAsignaturaPorCodigo(codigo);
        if (asignatura != null) {
            return "Asignatura: " + asignatura.getNombre() + 
                   " - Es virtual: " + asignatura.esVirtual() + 
                   " - Estudiantes: " + asignatura.getEstudiantes();
        }
        return "Asignatura no encontrada.";
    }

   
    @GetMapping("/estudiantes/{letra}")
    public List<String> obtenerEstudiantesPorLetra(@PathVariable String letra) {
        return asignaturaService.obtenerEstudiantesPorLetra(letra);
    }
}