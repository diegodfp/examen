package com.examenfinal.examen.bicicletas.infrastructure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.examenfinal.examen.bicicletas.domain.entity.IServiceBicicleta;
import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {

    @Autowired
    private IServiceBicicleta servicio;

    @GetMapping("/findOne/{id}")
    public Optional<Bicicleta> findOne(@PathVariable int id) {

        return servicio.getBicicletaById(id);
    }

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable int id) {

        Optional<Bicicleta> surveyOptional = servicio.delete(id);

        if (surveyOptional.isPresent()) {

            return "Bicicleta numero : " + id + " ha sido eliminada";
        }
        return "Bicicleta numero : " + id + " no existe ";
    }

    @PostMapping("/createBicicleta")
    public Bicicleta createOne(@RequestBody Bicicleta bicicleta) {

        return servicio.createBicicleta(bicicleta);

    }

    /* http://localhost:8080/bicicleta/createBicicleta
      { "id":5,
      "precio": 1500.50,
      "stock": 10,
      "modelo": {
      "id": 1
      },
      "marca": {
      "id": 1
      }
      }
      
     */

    @PutMapping("/updateBicicleta/{id}")
    public Optional<Bicicleta> updateOne(@PathVariable int id, @RequestBody Bicicleta bicicleta) {

        return servicio.update(id, bicicleta);

    }

}
