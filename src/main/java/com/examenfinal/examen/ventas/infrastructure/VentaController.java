package com.examenfinal.examen.ventas.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examenfinal.examen.ventas.domain.entity.Venta;
import com.examenfinal.examen.ventas.domain.service.IServiceVenta;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IServiceVenta servicio;

    @PostMapping("/createVenta")
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = servicio.createVenta(venta);
        return ResponseEntity.ok(nuevaVenta);
    }

    @PutMapping("/updateVenta/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable int id, @RequestBody Venta venta) {
        Optional<Venta> ventaActualizada = servicio.update(id, venta);
        return ventaActualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteVenta/{id}")
    public ResponseEntity<String> deleteVenta(@PathVariable int id) {
        Optional<Venta> ventaEliminada = servicio.delete(id);
        if (ventaEliminada.isPresent()) {
            return ResponseEntity.ok("Venta eliminada con éxito");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findVenta/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable int id) {
        Optional<Venta> venta = servicio.getVentaById(id);
        return venta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allVentas")
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = servicio.getAllVenta();
        return ResponseEntity.ok(ventas);
    }
}
