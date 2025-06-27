package com.examen.banco.controller;


import org.springframework.web.bind.annotation.*;

import com.examen.banco.model.Productos;
import com.examen.banco.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Productos crearProducto(@RequestBody Productos producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping
    public List<Productos> obtenerTodos(@RequestParam(required = false) String nombre,
                                       @RequestParam(required = false) String categoria) {
        if (nombre != null) {
            return productoService.buscarPorNombre(nombre);
        } else if (categoria != null) {
            return productoService.buscarPorCategoria(categoria);
        } else {
            return productoService.obtenerTodos();
        }
    }

    @PutMapping("/{id}")
    public Productos actualizarProducto(@PathVariable Long id, @RequestBody Productos producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
