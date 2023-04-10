package com.dab_depo.Controller;

import com.dab_depo.Entity.Wagon;
import com.dab_depo.Service.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WagonController {

    @Autowired
    private WagonService wagonService;

    @GetMapping("/wagons")
    public String listWagons(Model model) {
        List<Wagon> wagons = wagonService.getWagons();
        model.addAttribute("wagons", wagons);
        return "wagons";
    }

    @GetMapping("/delete/{wagonId}")
    public String deleteWagon(@PathVariable Integer wagonId) {
        wagonService.delete(wagonId);
        return "redirect:/wagons";
    }

    @GetMapping("/edit/{wagonId}")
    public String editWagonById(@PathVariable Integer wagonId, Model model) {
        List<Wagon> wagon = new ArrayList<>();
        wagon.add(wagonService.findWagonById(wagonId));
        model.addAttribute("wagon", wagon);
        return "edit_wagon";
    }

    @PostMapping("/edit")
    public String editWagon(@ModelAttribute Wagon wagon)throws IOException {
        wagonService.update(wagon);
        return "redirect:/wagons";
    }

}

