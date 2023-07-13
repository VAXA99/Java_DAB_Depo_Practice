package com.dab_depo.Controller;

import com.dab_depo.Entity.Wagon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.dab_depo.Service.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class WagonController {

    @Autowired
    private WagonService wagonService;

    @GetMapping("wagons")
    public List<Wagon> getWagons() {
        return wagonService.getWagons();
    }

    @PostMapping("add")
    public ResponseEntity<Wagon> addWagon(@RequestBody Wagon wagon) {
        Wagon addNewWagon = wagonService.add(wagon);
        return ResponseEntity.ok(addNewWagon);
    }

    @GetMapping("wagon/{id}")
    public Wagon getWagonById(@PathVariable Integer id) {
        return wagonService.findWagonById(id);
    }

    @PutMapping("edit/{id}")
    public Wagon updateWagon(@PathVariable Integer id, @RequestBody Wagon updatedWagon) {
        updatedWagon.setId(id);
        return wagonService.update(updatedWagon);
    }

    @DeleteMapping("delete/{id}")
    public void deleteWagon(@PathVariable Integer id) {
        wagonService.delete(id);
    }
}
