package com.backend.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.veterinaria.model.entity.Especialista;
import com.backend.veterinaria.service.IEspecialistaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EspecialistaController {

    @Autowired
    private IEspecialistaService especialistaService;

    @GetMapping("/especialistas")
    public List<Especialista> listaEspecialistas() {
        return especialistaService.listarEspecialistas();
    }

    @GetMapping("/especialistas/habilitados")
    public List<Especialista> listaEspecialistasHabilitados() {
        return especialistaService.listarEspecialistasHabilitados();
    }

    @GetMapping("/especialistas/{id}")
    public Especialista detalleEspecialista(@PathVariable Integer id) {
        return especialistaService.obtenerEspecialistaPorId(id);
    }

    @PostMapping("/especialistas")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialista registroEspecialista(@RequestBody Especialista especialista) {
        return especialistaService.guardarEspecialista(especialista);
    }

    @PutMapping("/especialistas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialista actualizaEspecialista(@PathVariable Integer id, @RequestBody Especialista especialista) {
        Especialista especialistaActual = especialistaService.obtenerEspecialistaPorId(id);
        especialistaActual.setEspecialistaDNI(especialista.getEspecialistaDNI());
        especialistaActual.setEspecialistaNombres(especialista.getEspecialistaNombres());
        especialistaActual.setEspecialistaTelefono(especialista.getEspecialistaTelefono());
        especialistaActual.setEspecialistaArea(especialista.getEspecialistaArea());
        especialistaActual.setEspecialistaEstado(especialista.getEspecialistaEstado());
        return especialistaService.guardarEspecialista(especialistaActual);
    }

    @PutMapping("/especialistas/{id}/inhabilitar")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialista inhabilitaEspecialista(@PathVariable Integer id) {
        Especialista especialistaActual = especialistaService.obtenerEspecialistaPorId(id);
        especialistaActual.setEspecialistaEstado("Inhabilitado");
        return especialistaService.guardarEspecialista(especialistaActual);
    }

    @DeleteMapping("/especialistas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaEspecialista(@PathVariable Integer id) {
        especialistaService.eliminarEspecialista(id);
    }

}
