package com.backend.veterinaria.controller;

import com.backend.veterinaria.model.entity.Mascota;
import com.backend.veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @GetMapping("/mascotas")
    public List<Mascota> listaMascotas(){
        return mascotaService.listarMascotas();
    }

    @GetMapping("/mascotas/habilitadas")
    public List<Mascota> listaMascotasHabilitadas(){
        return mascotaService.listarMascotasHabilitadas();
    }

    @GetMapping("/mascotas/{id}")
    public Mascota detalleMascota(@PathVariable Integer id){
        return mascotaService.obtenerMascotaPorId(id);
    }

    @PostMapping("/mascotas")
    @ResponseStatus(HttpStatus.CREATED)
    public Mascota registroMascota(@RequestBody Mascota mascota){
        return mascotaService.guardarMascota(mascota);
    }

    @PutMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mascota actualizaMascota(@PathVariable Integer id, @RequestBody Mascota mascota){
        Mascota mascotaActual = mascotaService.obtenerMascotaPorId(id);

        mascotaActual.setMascotaNombre(mascota.getMascotaNombre());
        mascotaActual.setMascotaTipo(mascota.getMascotaTipo());
        mascotaActual.setMascotaRaza(mascota.getMascotaRaza());
        mascotaActual.setMascotaFechaNacimiento(mascota.getMascotaFechaNacimiento());
        mascotaActual.setMascotaColor(mascota.getMascotaColor());
        mascotaActual.setMascotaSexo(mascota.getMascotaSexo());
        mascotaActual.setMascotaObservaciones(mascota.getMascotaObservaciones());
        mascotaActual.setMascotaEstado(mascota.getMascotaEstado());
        mascotaActual.setCliente(mascota.getCliente());

        return mascotaService.guardarMascota(mascotaActual);
    }

    @DeleteMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaMascota(@PathVariable Integer id){
        mascotaService.eliminarMascota(id);
    }
}
