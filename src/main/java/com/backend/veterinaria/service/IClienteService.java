package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public List<Cliente> listarClientesHabilitados();

    public Cliente obtenerClientePorId(Integer id);

    public Cliente guardarCliente(Cliente cliente);

    void eliminarCliente (Integer id);
}
