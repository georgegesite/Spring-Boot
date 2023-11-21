package com.rungroup.web.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.rungroup.web.models.Club;

import com.rungroup.web.services.ClubService;

import jakarta.validation.Valid;

@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<Club> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/{id}")
    public String clubDetail(@PathVariable("id") Long id, Model model) {
        Club club = clubService.findClub(id); // get object from databse
        model.addAttribute("club", club); // send data to HTML
        return "club-details";
    }

    @GetMapping("/clubs/new")
    public String createClubFrom(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") Club club, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-create";
        }
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}/edit")
    public String editClubForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("club", clubService.findClub(id));
        return "club-edit";
    }

    @PostMapping("/clubs/{id}/edit")
    public String updateClub(@PathVariable("id") Long id, @Valid @ModelAttribute("club") Club club,
            BindingResult result) {
        if (result.hasErrors()) { // Validation Error
            return "club-edit";
        }
        club.setId(id);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}/delete")
    public String deleteClub(@PathVariable("id") Long id) {
        clubService.deleteClub(id);
        return "redirect:/clubs";
    }

}
