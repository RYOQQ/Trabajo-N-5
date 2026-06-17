package com.inventario.demo.repository;

import com.inventario.demo.model.Producto;
import java.util.List;

public interface ProductoRepo extends Repositorio<Producto, Long> {

    List<Producto> findByCategoria(Long categoriaId);

    List<Producto> buscarPorNombre(String texto);
}
