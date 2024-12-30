package tn.essat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.essat.dao.IAdherant;
import tn.essat.dao.IAdministrateur;
import tn.essat.dao.IReservation;
import tn.essat.dao.ITerrain;
import tn.essat.model.Adherant;
import tn.essat.model.Administrateur;
import tn.essat.model.Reservation;
import tn.essat.model.Terrain;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AppCRT {

    @Autowired
    IAdherant dao_adhe;

    @Autowired
    IAdministrateur dao_admin;

    @Autowired
    IReservation dao_res;

    @Autowired
    ITerrain dao_ter;

    // --------------------- Reservation ---------------------
    
    @GetMapping("/reservations")
    public List<Reservation> getAllRes() {
        return dao_res.findAll();
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return dao_res.save(reservation);
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        dao_res.deleteById(id);
    }

    // --------------------- Adherant ---------------------
    
    @GetMapping("/adherants")
    public List<Adherant> getAllAdh() {
        return dao_adhe.findAll();
    }

    @PostMapping("/adherants")
    public Adherant addAdherant(@RequestBody Adherant adherant) {
        return dao_adhe.save(adherant);
    }

    @DeleteMapping("/adherants/{id}")
    public void deleteAdherant(@PathVariable Integer id) {
        dao_adhe.deleteById(id);
    }

    // --------------------- Terrain ---------------------
    
    @GetMapping("/terrains")
    public List<Terrain> getAllTer() {
        return dao_ter.findAll();
    }

    @PostMapping("/terrains")
    public Terrain addTerrain(@RequestBody Terrain terrain) {
        return dao_ter.save(terrain);
    }

    @DeleteMapping("/terrains/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        dao_ter.deleteById(id);
    }
    
}
