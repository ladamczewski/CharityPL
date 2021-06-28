package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/donation")
public class DonationController {
private final DonationRepository donationRepository;
private final InstitutionRepository institutionRepository;
private final CategoryRepository categoryRepository;

    public DonationController(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/newdonate")
    public String donate(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/newdonate")
    public String donatePost(@ModelAttribute Donation donation){
        donationRepository.save(donation);
        return "redirect:../../";
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }


}
