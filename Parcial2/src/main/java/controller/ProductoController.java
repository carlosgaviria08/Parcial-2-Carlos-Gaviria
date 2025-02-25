package com.example.parcial2.controller;

import com.example.parcial2.model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @GetMapping
    public Flux<Producto> listarProductos() {
        return Flux.just(
                new Producto("1", "Laptop", 1200.0),
                new Producto("2", "Mouse", 25.0),
                new Producto("3", "Teclado", 45.0)
        );
    }
}