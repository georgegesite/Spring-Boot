package com.rungroup.web.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.rungroup.web.models.Club;

import com.rungroup.web.services.ClubService;

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

    @GetMapping("/clubs/new")
    public String createClubFrom(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}/edit")
    public String editClubForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("club", clubService.findClub(id));
        return "club-edit";
    }

    @PostMapping("/clubs/{id}/edit")
    public String updateClub(@PathVariable("id") Long id, @ModelAttribute("club") Club club) {
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
