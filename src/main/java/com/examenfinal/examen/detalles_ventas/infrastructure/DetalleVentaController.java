package com.examenfinal.examen.detalles_ventas.infrastructure;

import java.util.List;
import java.util.Optional;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;
import com.examenfinal.examen.detalles_ventas.domain.service.IServiceDetalleVenta;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private IServiceDetalleVenta servicio;

    @PostMapping("/createDetalleVenta")
    public ResponseEntity<DetalleVenta> createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta nuevoDetalleVenta = servicio.createDetalleVenta(detalleVenta);
        return ResponseEntity.ok(nuevoDetalleVenta);
    }

    @PutMapping("/updateDetalleVenta/{id}")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@PathVariable int id, @RequestBody DetalleVenta detalleVenta) {
        Optional<DetalleVenta> detalleVentaActualizado = servicio.update(id, detalleVenta);
        return detalleVentaActualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteDetalleVenta/{id}")
    public ResponseEntity<String> deleteDetalleVenta(@PathVariable int id) {
        Optional<DetalleVenta> detalleVentaEliminado = servicio.delete(id);
        if (detalleVentaEliminado.isPresent()) {
            return ResponseEntity.ok("Detalle de venta eliminado con éxito");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findDetalleVenta/{id}")
    public ResponseEntity<DetalleVenta> getDetalleVentaById(@PathVariable int id) {
        Optional<DetalleVenta> detalleVenta = servicio.getDetalleVentaById(id);
        return detalleVenta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allDetallesVentas")
    public ResponseEntity<List<DetalleVenta>> getAllDetallesVentas() {
        List<DetalleVenta> detallesVentas = servicio.getAllDetalleVenta();
        return ResponseEntity.ok(detallesVentas);
    }
}
