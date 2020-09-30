package cl.springboot.errores.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.springboot.errores.app.errors.UsuarioNoEncontradoException;
import cl.springboot.errores.app.models.domain.Usuario;
import cl.springboot.errores.app.services.IUsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	/*metodo handler*/
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "Manejo de Errores en Spring Boot");
		Integer valor = Integer.parseInt("lll");
		return "index";
	}
	
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
//		Usuario user = iUsuarioService.obtenerPorId(id);
//		if(user == null)
//			throw new UsuarioNoEncontradoException(String.valueOf(id));
	
		Usuario user = iUsuarioService.obtenerPorIdOptional(id).orElseThrow( () -> new UsuarioNoEncontradoException(String.valueOf(id)));
		model.addAttribute("titulo", "Detalle de Usuario: ".concat(user.getNombre()));
		model.addAttribute("usuario", user);
		return "ver";
		
	}
}
