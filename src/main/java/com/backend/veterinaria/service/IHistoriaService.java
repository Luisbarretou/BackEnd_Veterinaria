package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Historia;

import java.util.List;

public interface IHistoriaService {

    public List<Historia> listarHistorias();

    public List<Historia> listarHistoriasHabilitadas();

    public Historia obtenerHistoriaPorId(Integer id);

    public Historia guardarHistoria(Historia historia);

    void eliminarHistoria(Integer id);
}
