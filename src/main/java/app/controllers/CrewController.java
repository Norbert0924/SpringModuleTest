package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.services.CrewService;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrewController {

    private CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping(value = {"/crew/{registrationCode}"})
    public String saveNewSpaceShip(Model model, @PathVariable("registrationCode") String registrationCode) {

        System.out.println(
        crewService.listCrewBySpaceShipRegistrationCode(registrationCode)
        );

        return "crew";
    }

}
