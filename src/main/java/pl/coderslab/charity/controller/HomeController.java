package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;


@Controller
public class HomeController {
    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;
    private UserRepository userRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository, UserRepository userRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Donation> donations = donationRepository.findAll();
        int bags = 0;
        for(Donation donation:donations) {
            bags += donation.getQuantity();
        }
        model.addAttribute("bags", bags);
        return "index";
    }

    @GetMapping("/newacc")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/newacc")
    public String createUserPost(@ModelAttribute User user){
        userRepository.save(user);
        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }

    @ModelAttribute("donations")
    public List<Donation> donations(){
        return donationRepository.findAll();
    }

}
