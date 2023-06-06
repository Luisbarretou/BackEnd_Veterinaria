package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.clienteEstado = 'Habilitado'")
    public List<Cliente> obtenerClientesHabilitados();

}
