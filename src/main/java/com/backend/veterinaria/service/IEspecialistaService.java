package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Especialista;

import java.util.List;

public interface IEspecialistaService {

    public List<Especialista> listarEspecialistas();

    public List<Especialista> listarEspecialistasHabilitados();

    public Especialista obtenerEspecialistaPorId(Integer id);

    public Especialista guardarEspecialista(Especialista especialista);

    void eliminarEspecialista(Integer id);
}
