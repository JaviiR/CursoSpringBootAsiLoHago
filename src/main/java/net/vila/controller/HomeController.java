package net.vila.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista=new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos",lista);
		return "listado";
	}
	
	
	
	@RequestMapping("/")
	public String Inicio(Model model) {
		/*model.addAttribute("mensaje","Comenzando Spring desde cero");
		model.addAttribute("fecha",new Date());
		*/
		
		String nombre="Auxiliar de Contabilidad";
		Date fechaPub=new Date();
		double salario=9000.0;
		boolean vigente=true;
		
		model.addAttribute("nombre",nombre);
		model.addAttribute("fecha",fechaPub);
		model.addAttribute("salario",salario);
		model.addAttribute("vigente",vigente);
		return "Inicio";
	}

}