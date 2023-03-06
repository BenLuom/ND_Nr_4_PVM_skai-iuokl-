package com.example.namu_darbas_nr_4_benas_luomanas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PVMcontroller {

    @GetMapping("/")
    public String home(Model model){
        return "PVMskaiciuokle1";
    }
    @PostMapping("/")
    public String apskaiciuoti(
            @RequestParam("kaina") double kaina,
            @RequestParam("kiekis") Integer kiekis,
            Model model
    ){
        double VntBePVM = Math.round((kaina * 100 / 121) * 100.0) / 100.0;
        model.addAttribute("VntBePVM",VntBePVM);
        model.addAttribute("VntBePVMClass", "alert-info");

        double VntPVM = Math.round((kaina - (kaina * 100 / 121)) * 100.0) / 100.0;
        model.addAttribute("VntPVM",VntPVM);
        model.addAttribute("VntPVMClass", "alert-info");

        double VntSuPVM = Math.round(kaina * 100.0) / 100.0;
        model.addAttribute("VntSuPVM", VntSuPVM);
        model.addAttribute("VntSuPVMClass", "alert-info");

        double BendraBePVM = Math.round(((kaina * 100 / 121) * kiekis) * 100.0) / 100.0;
        model.addAttribute("BendraBePVM",BendraBePVM);
        model.addAttribute("BendraBePVMClass", "alert-info");

        double BendraPVM = Math.round((((kaina - (kaina * 100 / 121)) * kiekis) * 100.0) / 100.0);
        model.addAttribute("BendraPVM",BendraPVM);
        model.addAttribute("BendraPVMClass", "alert-info");

        double BendraSuPVM = Math.round((kaina * kiekis)* 100.0) / 100.0;
        model.addAttribute("BendraSuPVM", BendraSuPVM);
        model.addAttribute("BendraSuPVMClass", "alert-info");

        return "PVMskaiciuokle2";
    }


}