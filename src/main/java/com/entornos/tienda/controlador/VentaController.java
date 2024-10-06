package com.entornos.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entornos.tienda.modelo.Venta;
import com.entornos.tienda.servicio.VentaService;

import jakarta.validation.Valid;

@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;

    //listar ventas
    @GetMapping("/list/ventas")
    public List<Venta> cargarVentas(){
        return ventaService.geVenta();
    }

    //buscar ventas
    @GetMapping("list/ventas/{id}")
    public Venta buscarVentaPorId(@RequestParam Long id) {
        return ventaService.buscarVenta(id);
    }

    //agregar ventas
    @PostMapping("/ventas/agregar")
    public ResponseEntity<Venta> agregarVenta(@Valid @RequestBody Venta venta) {
        Venta obj = ventaService.nuevaVenta(venta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //actualizar ventas
    @PutMapping("/ventas/actualizar")
    public ResponseEntity<Venta> editarVenta(@Valid @RequestBody Venta venta) {
        Venta obj = ventaService.buscarVenta(venta.getId());
        if (obj != null) {
            obj.setIdCliente(venta.getIdCliente());
            obj.setIdUsuario(venta.getIdUsuario());
            obj.setIvaVenta(venta.getIvaVenta());
            obj.setTotalVenta(venta.getTotalVenta());
            obj.setValorVenta(venta.getValorVenta());
            ventaService.nuevaVenta(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    //eliminar ventas
    @DeleteMapping("venta/{id}")
    public ResponseEntity<Venta> venta(@PathVariable Long id) {
        Venta obj = ventaService.buscarVenta(id);
        if (obj != null) {
            ventaService.borrarVenta(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
