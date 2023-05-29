package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IClienteDao;
import com.backend.veterinaria.model.entity.Cliente;
import com.backend.veterinaria.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Transactional
    @Override
    public List<Cliente> listarClientesHabilitados() {
        return (List<Cliente>) clienteDao.obtenerClientesHabilitados();
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Transactional
    @Override
    public void eliminarCliente(Integer id) {
        clienteDao.deleteById(id);
    }
}
