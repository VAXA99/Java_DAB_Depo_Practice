package com.dab_depo.Controller;

import com.dab_depo.Entity.Wagon;
import com.dab_depo.Service.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WagonController {

    @Autowired
    private WagonService wagonService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/wagons")
    public String listWagons(Model model) {
        List<Wagon> wagons = wagonService.getWagons();
        model.addAttribute("wagons", wagons);
        return "wagons";
    }

    @GetMapping("/delete/{id}")
    public String deleteWagon(@PathVariable Integer id) {
        wagonService.delete(id);
        return "redirect:/wagons";
    }

    @GetMapping("/edit/{id}")
    public String editWagonById(@PathVariable Integer id, Model model) {
        List<Wagon> wagon = new ArrayList<>();
        wagon.add(wagonService.findWagonById(id));
        model.addAttribute("wagon", wagon);
        return "edit_wagon";
    }

    @PostMapping("/edit/{id}")
    public String editWagon(@PathVariable Integer id,
                            @RequestParam(value = "wagonType") String wagonType,
                            @RequestParam(value = "loadingPercentage") Integer loadingPercentage,
                            @RequestParam(value = "serialNumber") String serialNumber,
                            @RequestParam(value = "homeStation") String homeStation,
                            @RequestParam(value = "loadCapacity") Integer loadCapacity,
                            @RequestParam(value = "yearOfRelease") Integer yearOfRelease){
        Wagon wagon = new Wagon(id, wagonType, loadingPercentage, serialNumber, homeStation, loadCapacity, yearOfRelease);
        wagonService.update(wagon);
        return "redirect:/wagons";
    }

    @GetMapping("/add")
    public String getAddWagonPage() {
        return "add_wagon";
    }

    @PostMapping("/add")
    public String addWagon( @RequestParam(value = "wagonType") String wagonType,
                            @RequestParam(value = "loadingPercentage") Integer loadingPercentage,
                            @RequestParam(value = "serialNumber") String serialNumber,
                            @RequestParam(value = "homeStation") String homeStation,
                            @RequestParam(value = "loadCapacity") Integer loadCapacity,
                            @RequestParam(value = "yearOfRelease") Integer yearOfRelease) {
        Wagon wagon = new Wagon(wagonType, loadingPercentage, serialNumber, homeStation, loadCapacity, yearOfRelease);
        wagonService.add(wagon);
        return "redirect:/wagons";
    }

    @GetMapping("wagons/changeStatus/{id}")
    public String changeStatus(@PathVariable Integer id){
        wagonService.changeStatus(id);
        return "redirect:/wagons";
    }   

}

