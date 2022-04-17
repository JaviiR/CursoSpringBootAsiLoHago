package net.vila.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.vila.model.Vacante;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante>lista=MostrarLista();
		model.addAttribute("vacantes",lista);
		return "tabla";
	}
	
	
	
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
	
	
	@GetMapping("/detalle")
	public String MostrarDetalle(Model model) {
		Vacante v=new Vacante();
		v.setId(1);
		v.setNombre("Ingeniero de Comunicaciones");
		v.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		v.setFecha(new Date());
		v.setSalario(1000.00);
		model.addAttribute("vacante",v);
		
		return "detalle";
	}

	
	
	
	
	
	
	
	
	//metodo para crear una lista de vacantes
	private List<Vacante> MostrarLista(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista=new LinkedList<Vacante>();
		try {
			//Creamos la oferta de Trabajo 1
			Vacante vacante1=new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero de Comunicaciones");
			vacante1.setDescripcion("Se solicita ingeniero para dar soporte a intranet.");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(1000.00);
			vacante1.setDestacado(1);
			//Creamos la oferta de Trabajo 2
			Vacante vacante2=new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero Civil");
			vacante2.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(8500.00);
			vacante2.setDestacado(0);
			//Creamos la oferta de Trabajo 3
			Vacante vacante3=new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Contador Publico");
			vacante3.setDescripcion("Empresa importante solicita Contador con 5 años de experiencia titulado.");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.00);
			vacante3.setDestacado(3);
			//Creamos la oferta de Trabajo 4
			Vacante vacante4=new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero Eléctrico");
			vacante4.setDescripcion("Empresa internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica.");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.00);
			vacante4.setDestacado(1);
			
			
			//Agregando las vacantes a la lista
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
		} catch (Exception e) {
			System.out.println("Esto es un mensaje de erro"+e.getMessage());
		}	
		
		return lista;
	}
	
	
	
	
	
	
	//links pa joda
	@GetMapping("/inicio")
	public String Yamete() {
		return "inicio";
	}
}
