package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Object doctor(@PathVariable int number) {

        if (number == 13) {
            return new Doctor(13, "Jodie Whittaker" );
        } else if ((number>0) && (number<13)) {
            // Erreur 303 : SEE_OTHER
            return new ResponseEntity<>(HttpStatus.SEE_OTHER);
        } else {
            // Erreur 404 : NOT_FOUND
            return new ResponseEntity<>("Impossible de récupérer l'incarnation " + number + ".", HttpStatus.NOT_FOUND);
        }
    }
}
