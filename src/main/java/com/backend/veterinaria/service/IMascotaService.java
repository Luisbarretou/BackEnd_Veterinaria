package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> listarMascotas();

    public List<Mascota> listarMascotasHabilitadas();

    public Mascota obtenerMascotaPorId(Integer id);

    public Mascota guardarMascota(Mascota mascota);

    void eliminarMascota(Integer id);
}
