package com.example.GlobalFitnessC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GlobalFitnessC.Model.User;
import com.example.GlobalFitnessC.Repository.gfRepo;
import com.example.GlobalFitnessC.Service.gfService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Controller
public class gfController {


   @Autowired
   gfService s;

   gfRepo gr;

   @GetMapping("/welcome")
   public String welcomepage() {
      return "index";
   }

   @GetMapping("/homepage")
   public String homepage() {
      return "home";
   }

   @GetMapping("/aboutpage")
   public String aboutpage() {
      return "about";
   }

   @GetMapping("/tools")
   public String toolspage() {
      return "tools";
   }

   @GetMapping("/login")
   public String loginpage() {
      return "login";
   }

   @GetMapping("/registration")
   public String signuppage() {
      return "regis";
   }

   @GetMapping("/regis1")
   public String regispage() {
      return "home";
   }

   @GetMapping("/login1")
   public String logpage() {
      return "home";
   }

   @GetMapping("/nutri")
   public String nutripage() {
      return "nutri";
   }

   @GetMapping("/back")
   public String backpage() {
      return "back";
   }

   @GetMapping("/bicep")
   public String biceppage() {
      return "bicep";
   }

   @GetMapping("/chest")
   public String chestpage() {
      return "chest";
   }

   @GetMapping("/legs")
   public String legspage() {
      return "legs";
   }

   /* to get the info and save it to the database */
   @PostMapping("/regimem")
   public String mems(@ModelAttribute User user, Model model) {
      // System.out.println(user);
      model.addAttribute("Name", user.getName());
      s.add(user);
      List<User> memberList = s.getAll();
      model.addAttribute("records", memberList);
      
      return "home";
      }
   



   /* @PostMapping("/login")
    public String login(@RequestParam String Name, @RequestParam String Password, Model model) {
        boolean isValidUser = isValidUser(Name, Password);
        if (isValidUser) {
            return "redirect:/home";
        } else {
            model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
            return "login";
        }
    }

    private boolean isValidUser(String Name, String Password) {
        User user = gr.findByUsername(Name);
        return user != null && user.getPassword().equals(Password);
    }
} */



    @PostMapping("/regismem")
   public String confirmPas(@ModelAttribute User user, Model model) {
      String p = user.getPassword();
      String cp = user.getConfirmPassword();
      if (!p.equals(cp)) {
         return "regis";
      }
      else{
      return "home";
      }
   } 
}

   /* @PostMapping("/loginOp")
   public String log(@RequestParam("Name") String Name, @RequestParam("Password") String Password, Model model) {
      Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :Name AND u.password = :Password");
      query.setParameter("Name", Name);
      query.setParameter("Password", Password);
       
      try {
         User user = (User) query.getSingleResult();
         // Valid credentials, redirect to the next page
         return "home";
     } catch (Exception e) {
         // Invalid credentials, show error message on the login page
         model.addAttribute("error", "Invalid credentials. Please try again.");
         return "login";
     }
   } */






/*
 * @PostMapping("/login1")
 * public String log(@RequestParam("Name") String
 * Name, @RequestParam("Password"), Model model){
 * query.setParameter("Name", Name);
 * query.setParameter("Password", Password);
 * }
 * 
 */
