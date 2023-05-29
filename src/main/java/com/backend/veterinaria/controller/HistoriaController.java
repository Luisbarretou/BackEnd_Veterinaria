package com.backend.veterinaria.controller;

import com.backend.veterinaria.model.entity.Historia;
import com.backend.veterinaria.service.IHistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api")
public class HistoriaController {

    @Autowired
    private IHistoriaService historiaService;

    @GetMapping("/historias")
    public List<Historia> listaHistorias(){
        return historiaService.listarHistorias();
    }

    @GetMapping("/historias/{id}")
    public Historia detalleHistoria(@PathVariable Integer id){
        return historiaService.obtenerHistoriaPorId(id);
    }

    @PostMapping("/historias")
    @ResponseStatus(HttpStatus.CREATED)
    public Historia registroHistoria(@RequestBody Historia historia){
        return historiaService.guardarHistoria(historia);
    }

    @PutMapping("/historias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Historia actualizaHistoria(@PathVariable Integer id, @RequestBody Historia historia){
        Historia historiaActual = historiaService.obtenerHistoriaPorId(id);
        historiaActual.setHistoriaEstado(historia.getHistoriaEstado());
        historiaActual.setMascota(historia.getMascota());
        return historiaService.guardarHistoria(historiaActual);
    }

    @PutMapping("/historias/{id}/inhabilitar")
    public Historia inhabilitarHistoria(@PathVariable Integer id){
        Historia historiaActual = historiaService.obtenerHistoriaPorId(id);
        historiaActual.setHistoriaEstado("Inhabilitado");
        return historiaService.guardarHistoria(historiaActual);
    }

}
