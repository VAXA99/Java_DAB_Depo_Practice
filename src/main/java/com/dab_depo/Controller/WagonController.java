package com.dab_depo.Controller;

import com.dab_depo.Entity.Wagon;
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
    public Wagon addWagon(@RequestBody Wagon wagon) {
        return wagonService.add(wagon);
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
