package com.springCRUD.ebillet.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.springCRUD.ebillet.model.Evenements;
import com.springCRUD.ebillet.model.Reservation;
import com.springCRUD.ebillet.repository.ReservationRepository;
import com.springCRUD.ebillet.repository.UserRepository;
import com.springCRUD.ebillet.services.EvenementsServices;
import com.springCRUD.ebillet.services.ReservationServices;

@Controller
public class EvenementsController {

	@Autowired
	EvenementsServices service;
	@Autowired
	ReservationServices service1;

	
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Evenements> listE = service.listAll(keyword);
		model.addAttribute("listE",listE);
		model.addAttribute("keyword", keyword);
		return "index";
	}

	
	
	@RequestMapping("/new")
	public String newEvenementPage(Model model) {
		Evenements evenement = new Evenements();
		model.addAttribute("evenement",evenement);
		return "new_evenement";

	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveEvenement(@ModelAttribute("evenement") Evenements e ) {
		service.save(e);
		return "redirect:/";
		
	} 
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable (name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_evenement");
		Evenements evenement =service.get(id);
		mav.addObject("evenement",evenement);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEvenement(@PathVariable (name="id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	//Ajouter reservation
    @GetMapping(value = "/addreservation/{id}")
    public String details(Model model, @ModelAttribute("reservation") Reservation r ,@PathVariable Long id) { 
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String id1 = null;
        
        if (authentication != null)
            if (authentication.getPrincipal() instanceof UserDetails)
            id1 = ((UserDetails) authentication.getPrincipal()).getUsername();
            else if (authentication.getPrincipal() instanceof String)
            id1 = (String) authentication.getPrincipal();
            Long user = (Long) service1.findByLogin(id1);
            System.out.print("-------"+ "id evenement"+id1 );
            
            Evenements evenement = service.get(id);
            Reservation res = new Reservation(evenement,user);
            evenement.setNbPlaces(evenement.getNbPlaces()-1);
        
             service1.save(res);
       
 

        return "index";
    }
    


	
}
