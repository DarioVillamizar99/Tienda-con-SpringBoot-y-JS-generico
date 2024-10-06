package com.entornos.tienda.servicio;

import java.util.List;

import com.entornos.tienda.modelo.Venta;

public interface IVentaService{

    List<Venta> geVenta();

    Venta nuevaVenta(Venta venta);

    Venta buscarVenta(Long id);

    void borrarVenta(Long id);

}
