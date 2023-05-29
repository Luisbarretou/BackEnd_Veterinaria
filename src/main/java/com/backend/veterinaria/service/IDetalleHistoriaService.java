package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.DetalleHistoria;

import java.util.List;

public interface IDetalleHistoriaService {

    public List<DetalleHistoria> listarDetallesHistoria();

    public DetalleHistoria obtenerDetalleHistoriaPorId(Integer id);

    public DetalleHistoria guardarDetalleHistoria(DetalleHistoria detalleHistoria);

    void eliminarDetalleHistoria(Integer id);
}
