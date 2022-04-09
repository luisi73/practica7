package com.volta.chargerMap.controller;

import com.volta.chargerMap.model.Charger;
import com.volta.chargerMap.service.ChargerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ChargerController {
    @Autowired
    private ChargerService chargerService;
    
    @GetMapping("/charger")
    public ResponseEntity<Iterable<Charger>> retrieveChargerPosition(@RequestParam(required=false) String longitude, @RequestParam(required=false) String latitude) {

        Iterable<Charger> response = chargerService.retrieveChargerLong(longitude);
        response = chargerService.retrieveChargerLat(latitude);
        return ResponseEntity.ok().body(response);
    }

   /* @PostMapping("/chargers")
    public ResponseEntity<Charger> createCharger(@RequestBody Charger charger) {
        Charger newCharger = chargerService.createCharger(charger);
        return ResponseEntity.ok().body(newCharger);
    }*/

    @GetMapping("/charger/{id}/")
    public ResponseEntity<Charger> retrieveCharger(@PathVariable String id) {
        Charger response = chargerService.retrieveCharger(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/chargers/{id}/")
    public ResponseEntity<Charger> updateCharger(@PathVariable String id, @RequestBody Charger charger) {
        Charger newCharger = chargerService.updateCharger(id, charger);
        if (newCharger == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newCharger);
    }

    @DeleteMapping("/chargers/{id}")
    public ResponseEntity<Charger> deleteCharger(@PathVariable String id) {
        chargerService.deleteCharger(id);
        return ResponseEntity.noContent().build();
    }
    
}

// /charger/ (Crear, Coger)
// /chargers/{id} (Coger un elemento, actualizar, eleminar)