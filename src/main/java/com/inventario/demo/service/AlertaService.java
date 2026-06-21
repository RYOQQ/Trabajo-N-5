package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.model.NivelAlerta;
import com.inventario.demo.model.Producto;

public interface AlertaService {

    NivelAlerta obtenerNivelAlerta(Producto producto);

    List<Producto> productosConStockBajo();

    List<Producto> productosConStockCritico();
}