package cl.springboot.errores.app.services;

import java.util.List;
import java.util.Optional;

import cl.springboot.errores.app.models.domain.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
	public Optional<Usuario> obtenerPorIdOptional(Integer id);

}
