package co.udea.ssmu.api.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import co.udea.ssmu.api.model.jpa.repository.services.ServiceRepository;

@RestController
@RequestMapping("/servicio")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping("/consultar")
    public List<Service> findAll(){
        return repository.findAll();
    }

    @PostMapping("/guardar")
    public void save(){
    }

    @PostMapping("/calificar-servicio")
    public ResponseEntity<String> calificarServicio(@RequestParam Integer servicioId, @RequestParam Integer calificacion) {
        // Aquí se debería validar el rango de la calificación (1 a 5 estrellas)
        // También se debe verificar si el servicio existe y si el usuario tiene permiso para calificarlo
        // Se puede utilizar el serviceRepository para actualizar la calificación del servicio dado

        // Ejemplo de lógica para actualizar la calificación del servicio
        Service servicio = repository.findById(servicioId).orElse(null);
        if (servicio != null) {
            // Verificar si el usuario tiene permisos para calificar el servicio
            // if (usuarioActual.getId() == servicio.getUser().getId() || usuarioActual.getId() == servicio.getDriver().getId()) {
            // Actualizar la calificación del servicio
            servicio.setCalificacionServicio(String.valueOf(calificacion));
            repository.save(servicio);
            return ResponseEntity.ok("Calificación del servicio actualizada exitosamente.");
            // }
        }
        return ResponseEntity.badRequest().body("No se pudo actualizar la calificación del servicio.");
    }

    @PostMapping("/calificar-cliente")
    public ResponseEntity<String> calificarCliente(@RequestParam Integer servicioId, @RequestParam Integer calificacion) {
        // Aquí se debería validar el rango de la calificación (1 a 5 estrellas)
        // También se debe verificar si el servicio existe y si el usuario es un conductor asociado a ese servicio
        // Se puede utilizar el serviceRepository para actualizar la calificación del cliente en el servicio dado

        // Ejemplo de lógica para actualizar la calificación del cliente en el servicio
        Service servicio = repository.findById(servicioId).orElse(null);
        if (servicio != null && servicio.getDriver() != null) {
            // Verificar si el usuario es un conductor asociado al servicio
            // if (usuarioActual.getId() == servicio.getDriver().getId()) {
            // Actualizar la calificación del cliente en el servicio
            servicio.setCalificacionUsuario(String.valueOf(calificacion));
            repository.save(servicio);
            return ResponseEntity.ok("Calificación del cliente actualizada exitosamente.");
            // }
        }
        return ResponseEntity.badRequest().body("No se pudo actualizar la calificación del cliente.");
    }

    @PostMapping("/calificar-conductor")
    public ResponseEntity<String> calificarConductor(@RequestParam Integer servicioId, @RequestParam Integer calificacion) {
        // Similar al método anterior, aquí se valida el rango de la calificación y se verifica si el servicio existe
        // Además, se debe verificar si el usuario es un cliente asociado a ese servicio
        // Se puede utilizar el serviceRepository para actualizar la calificación del conductor en el servicio dado

        // Ejemplo de lógica para actualizar la calificación del conductor en el servicio
        Service servicio = repository.findById(servicioId).orElse(null);
        if (servicio != null && servicio.getUser() != null) {
            // Verificar si el usuario es un cliente asociado al servicio
            // if (usuarioActual.getId() == servicio.getUser().getId()) {
            // Actualizar la calificación del conductor en el servicio
            servicio.setCalificacionConductor(String.valueOf(calificacion));
            repository.save(servicio);
            return ResponseEntity.ok("Calificación del conductor actualizada exitosamente.");
            // }
        }
        return ResponseEntity.badRequest().body("No se pudo actualizar la calificación del conductor.");
    }
}

