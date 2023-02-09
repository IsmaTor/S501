package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.controllers;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.services.ISucursalServicesDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller //controlador per la vista y model
@RequestMapping( "/") //solicitud web
public class SucursalController {
	
	@Autowired //injectar dependències
	private ISucursalServicesDAO sucursalServices;

	@GetMapping(path= "/index") //http://localhost:9000/index
	public String index() {
		return "Home";
	}

	@GetMapping(path= "/listado") //http://localhost:9000/listado
	public String listarSucursales(Model model) {
		List<SucursalDTO> listadoSucursales = sucursalServices.getAll();
		
		String tipus;
		for (SucursalDTO sucursalDTO : listadoSucursales) {
			tipus = sucursalDTO.tipusPais(sucursalDTO.getPaisSucursal());
			sucursalDTO.setTipusSucursal(tipus);
		}
		
		model.addAttribute("titulo", "Llista de sucursals");
		model.addAttribute("sucursales", listadoSucursales);
		return "views/sucursales/listar";
	}

	@GetMapping(path= "/create") //http://localhost:9000/create
	public String add( Model model) {
		SucursalDTO novaSucursal = new SucursalDTO();
		
		model.addAttribute("titulo", "Formulari: Nou Formulari");
		model.addAttribute("sucursal", novaSucursal);
		
		return "views/sucursales/frmCrear";
	}
	
	@PostMapping(path= "/save")
	public String save(@ModelAttribute SucursalDTO sucursalDTO) { //Ens permet fer un binding (vinculació) de les dades que tenim en un formulari de Spring amb la capa de backend.
		
		sucursalServices.add(sucursalDTO);
		System.out.println("Sucursal guardada");
		return "redirect:/listado";
		
	}

	@GetMapping(path= "/edit/{pk_SucursalID}") //http://localhost:9000/edit/
	public String editar(@PathVariable("pk_SucursalID") int idSucursal, Model model) { //Configurar variables dins dels propis segments de la URL
		Sucursal novaSucursal = sucursalServices.getOne(idSucursal);
			
		model.addAttribute("titulo", "Formulari: Editar Formulari");
		model.addAttribute("sucursal", novaSucursal);
			
		return "views/sucursales/frmActualizar";
	}
	
	@PostMapping(path= "/update")
	public String updateSucursalDTO(@ModelAttribute("sucursal") SucursalDTO sucursalDTO) { 
		sucursalServices.update(sucursalDTO.getPk_SucursalID(), sucursalDTO);
		return "redirect:/listado";
	}

	@GetMapping(path= "/eliminar/{pk_SucursalID}") //http://localhost:9000/eliminar/
	public String eliminar(@PathVariable("pk_SucursalID") int idSucursal) {
		sucursalServices.delete(idSucursal);
		System.out.println("Sucursal eliminada correctament.");
		
		return "redirect:/listado";
	}

}
