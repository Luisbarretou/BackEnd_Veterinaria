package com.backend.veterinaria.controller;

import com.backend.veterinaria.model.entity.Cliente;
import com.backend.veterinaria.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listaClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/clientes/habilitados")
    public List<Cliente> listaClientesHabilitados() {
        return clienteService.listarClientesHabilitados();
    }

    @GetMapping("/clientes/{id}")
    public Cliente detalleCliente(@PathVariable Integer id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente registroCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizaCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteActual = clienteService.obtenerClientePorId(id);
        clienteActual.setClienteNroDocumento(cliente.getClienteNroDocumento());
        clienteActual.setClienteNombre(cliente.getClienteNombre());
        clienteActual.setClienteTelefono(cliente.getClienteTelefono());
        clienteActual.setClienteDireccion(cliente.getClienteDireccion());
        clienteActual.setClienteCorreo(cliente.getClienteCorreo());
        clienteActual.setClienteGenero(cliente.getClienteGenero());
        clienteActual.setClienteEstado(cliente.getClienteEstado());
        return clienteService.guardarCliente(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
    }
}
