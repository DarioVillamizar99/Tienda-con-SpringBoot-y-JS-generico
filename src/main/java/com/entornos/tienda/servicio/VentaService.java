package com.entornos.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entornos.tienda.modelo.Venta;
import com.entornos.tienda.repositorio.VentaRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService implements IVentaService{

    @Autowired
    VentaRepositorio ventaRespositorio;

    @Override
    public List<Venta> geVenta() {
        return ventaRespositorio.findAll();
    }

    @Override
    public Venta nuevaVenta(Venta venta) {
        return ventaRespositorio.save(venta);
    }

    @Override
    public Venta buscarVenta(Long id) {
        Venta venta = null;
        venta = ventaRespositorio.findById(id).orElse(null);
        if (venta == null) {
            return null;
        }
        return venta;
    }

    @Override
    public void borrarVenta(Long id) {
        ventaRespositorio.deleteById(id);
    } 

}
