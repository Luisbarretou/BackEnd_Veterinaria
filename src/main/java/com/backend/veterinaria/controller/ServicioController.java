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

import com.backend.veterinaria.model.entity.Servicio;
import com.backend.veterinaria.service.IServicioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping("/servicios")
    public List<Servicio> listaServicios() {
        return servicioService.listarServicios();
    }

    @GetMapping("/servicios/habilitados")
    public List<Servicio> listaServiciosHabilitados() {
        return servicioService.listarServiciosHabilitados();
    }

    @GetMapping("/servicios/{id}")
    public Servicio detalleServicio(@PathVariable Integer id) {
        return servicioService.obtenerServicioPorId(id);
    }

    @PostMapping("/servicios")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio registroServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }

    @PutMapping("/servicios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio actualizaServicio(@PathVariable Integer id, @RequestBody Servicio servicio) {
        Servicio servicioActual = servicioService.obtenerServicioPorId(id);
        servicioActual.setServicioCategoria(servicio.getServicioCategoria());
        servicioActual.setServicioTipo(servicio.getServicioTipo());
        servicioActual.setServicioPrecio(servicio.getServicioPrecio());
        servicioActual.setServicioEstado(servicio.getServicioEstado());
        return servicioService.guardarServicio(servicioActual);
    }

    @PutMapping("/servicios/{id}/inhabilitar")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio inhabilitaServicio(@PathVariable Integer id) {
        Servicio servicioActual = servicioService.obtenerServicioPorId(id);
        servicioActual.setServicioEstado("Inhabilitado");
        return servicioService.guardarServicio(servicioActual);
    }

    @DeleteMapping("/servicios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaServicio(@PathVariable Integer id) {
        servicioService.eliminarServicio(id);
    }

}
