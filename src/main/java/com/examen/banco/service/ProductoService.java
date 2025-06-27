package com.examen.banco.service;


import org.springframework.stereotype.Service;

import com.examen.banco.model.Productos;
import com.examen.banco.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Productos crearProducto(Productos producto) {
        return productoRepository.save(producto);
    }

    public List<Productos> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Productos> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Productos actualizarProducto(Long id, Productos productoActualizado) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setCategoria(productoActualizado.getCategoria());
                    producto.setStock(productoActualizado.getStock());
                    producto.setPrecio(productoActualizado.getPrecio());
                    return productoRepository.save(producto);
                }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public List<Productos> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Productos> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }
}
