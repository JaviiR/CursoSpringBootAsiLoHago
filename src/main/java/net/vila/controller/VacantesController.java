package net.vila.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping(value="/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante,Model model) {
		System.out.println("IdVacante: "+idVacante);
		model.addAttribute("idVacante",idVacante);
		return "vacantes/detalle";
	}
}
