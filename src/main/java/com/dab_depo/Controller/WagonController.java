package com.dab_depo.Controller;

import com.dab_depo.Entity.Wagon;
import com.dab_depo.Service.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}

