package com.backend.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.veterinaria.model.entity.DetalleHistoria;
import com.backend.veterinaria.model.entity.Historia;
import com.backend.veterinaria.service.IDetalleHistoriaService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class DetalleHistoriaController {

    @Autowired
    private IDetalleHistoriaService detalleHistoriaService;

    @GetMapping("/detalleHistoria")
    public List<DetalleHistoria> listaDetalleHistorias() {
        return detalleHistoriaService.listarDetallesHistoria();
    }

    @GetMapping("/detalleHistoria/{id}")
    public DetalleHistoria obtenerDetalleHistoria(@PathVariable Integer id) {
        return detalleHistoriaService.obtenerDetalleHistoriaPorId(id);
    }

    @PostMapping("/detalleHistoria/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleHistoria registroDetalleHistoria(@PathVariable Integer id, @RequestBody DetalleHistoria detalleHistoria) {
        Historia historiaNueva = new Historia();
        historiaNueva.setHistoriaId(id);

        detalleHistoria.setHistoria(historiaNueva);
        return detalleHistoriaService.guardarDetalleHistoria(detalleHistoria);
    }

    @PutMapping("/detalleHistoria/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleHistoria actualizaDetalleHistoria(@PathVariable Integer id, @RequestBody DetalleHistoria detalleHistoria) {
        DetalleHistoria detalleActual = detalleHistoriaService.obtenerDetalleHistoriaPorId(id);
        detalleActual.setDetHistoriaFechaProgramada(detalleHistoria.getDetHistoriaFechaProgramada());
        detalleActual.setDetHistoriaFechaAplicada(detalleHistoria.getDetHistoriaFechaAplicada());
        detalleActual.setDetHistoriaFarmaco(detalleHistoria.getDetHistoriaFarmaco());
        detalleActual.setDetHistoriaPeso(detalleHistoria.getDetHistoriaPeso());
        detalleActual.setDetHistoriaObservaciones(detalleHistoria.getDetHistoriaObservaciones());
        detalleActual.setDetHistoriaTratamiento(detalleHistoria.getDetHistoriaTratamiento());
        detalleActual.setDetHistoriaEstado(detalleHistoria.getDetHistoriaEstado());
        detalleActual.setServicio(detalleHistoria.getServicio());
        detalleActual.setEspecialista(detalleHistoria.getEspecialista());
        return detalleHistoriaService.guardarDetalleHistoria(detalleActual);
    }

    @PutMapping("/detalleHistoria/{id}/inhabilitar")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleHistoria inhabilitaDetalleHistoria(@PathVariable Integer id) {
        DetalleHistoria detalleActual = detalleHistoriaService.obtenerDetalleHistoriaPorId(id);
        detalleActual.setDetHistoriaEstado("Inhabilitado");
        return detalleHistoriaService.guardarDetalleHistoria(detalleActual);
    }

}
