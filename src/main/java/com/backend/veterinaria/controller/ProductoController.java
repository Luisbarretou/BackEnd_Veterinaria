package com.backend.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.veterinaria.model.entity.Producto;
import com.backend.veterinaria.service.IProductoService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @RequestMapping("/productos")
    public List<Producto> listaProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/productos/habilitados")
    public List<Producto> listaProductosHabilitados() {
        return productoService.listarProductosHabilitados();
    }

    @GetMapping("/productos/{id}")
    public Producto detalleProducto(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto registroProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto actualizaProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto productoActual = productoService.obtenerProductoPorId(id);
        productoActual.setProductoNombre(producto.getProductoNombre());
        productoActual.setProductoMarca(producto.getProductoMarca());
        productoActual.setProductoCategoria(producto.getProductoCategoria());
        productoActual.setProductoDescripcion(producto.getProductoDescripcion());
        productoActual.setProductoPrecio(producto.getProductoPrecio());
        productoActual.setProductoEstado(producto.getProductoEstado());
        productoActual.setProveedores(producto.getProveedores());
        return productoService.guardarProducto(productoActual);
    }

    @PutMapping("/productos/{id}/inhabilitar")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto inhabilitarProducto(@PathVariable Integer id) {
        Producto productoActual = productoService.obtenerProductoPorId(id);
        productoActual.setProductoEstado("Inhabilitado");
        return productoService.guardarProducto(productoActual);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }

}
