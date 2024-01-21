package JuegosdelhambreDDI.CafeteriaAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JuegosdelhambreDDI.CafeteriaAPP.model.Cafe;
import JuegosdelhambreDDI.CafeteriaAPP.service.CafeService;


@Controller
public class RegistrationController {
	// @Autowired // usa esta interfaz
	// DBConnection db;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CafeService cafeService;


	// localhost:8080/
	@RequestMapping("/")
	public String index(Model model) {
		// devuelve solo la página index
		return "index";
	}

    // localhost:8080/error
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    // localhost:8080/Login
    @RequestMapping("/Login")
    public String loginPage() {
        return "index"; 
    }
    
    // localhost:8080/Register
    @RequestMapping("/Register")
    public String registerPage() {
        return "Register"; 
    }

//     @RequestMapping("/Cafe")
//     public String requestMethodName(Cafe cafe, Model model) {
//         Cafe cafeCreado = cafeService.addCafe(cafe);
//         model.addAttribute("cafeCreado", cafeCreado);
//
//         return "Cafe";
//     }
    
	@RequestMapping("/listarCafe")
	public String listarCafe(Model model) {
		Iterable<Cafe> lista = cafeService.getAllCafes();

		model.addAttribute("cafes", lista);

		return "listarCafe";
	}

}

// @RestController
// public class RegistrationController {
	
// 	@Autowired
// 	UserRepo repo;
	
// 	@RequestMapping("/")
// 	public ModelAndView home()
// 	{
// 		ModelAndView mv = new ModelAndView();
// 		mv.setViewName("Registration_Form");
// 		return mv;
// 	}
	
// 	@RequestMapping("/AlreadyLogin")
// 	public ModelAndView AlreadyLogin()
// 	{
// 		return new ModelAndView("Login_Form");
// 	}
	
		
// 	@RequestMapping("/Registration")
// 	public ModelAndView registration(UserRegistration reg)
// 	{
// 		repo.save(reg);
// 		return new ModelAndView("Login_Form");
// 	}
		
// 	@RequestMapping("/Login")
// 	public ModelAndView login(String email, String password)
// 	{
// 		ModelAndView mv = new ModelAndView("Login_Form");
		
// 		UserRegistration user = repo.findByEmailAndPassword(email, password);
		
// 		if(user != null)
// 		{
// 			String msg="Login Sucessful";  
//             		mv.addObject("message", msg);  
//           	        mv.setViewName("view");
// 		}
// 		else
// 		{
// 			String msg="Sorry You entered an incorrect email or password";  
//           	        mv.addObject("message", msg);  
//             		mv.setViewName("error"); 
// 		}

// 		return mv;
// 	}

	
// }
