package com.example.Parcial2;

import com.example.parcial2.controller.ProductoController;
import com.example.parcial2.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@SpringBootTest
public class ProductoControllerTest {

    @Autowired
    private ApplicationContext context;

    private ProductoController productoController;

    @BeforeEach
    void setUp() {
        productoController = context.getBean(ProductoController.class);
    }

    @Test
    public void testListaProductos() {
        Flux<Producto> productos = productoController.listarProductos();

        StepVerifier.create(productos)
                .expectNextMatches(p -> "Laptop".equals(p.getNombre()) && p.getPrecio() == 1200.0)
                .expectNextMatches(p -> "Mouse".equals(p.getNombre()) && p.getPrecio() == 25.0)
                .expectNextMatches(p -> "Teclado".equals(p.getNombre()) && p.getPrecio() == 45.0)
                .verifyComplete();
    }
}

