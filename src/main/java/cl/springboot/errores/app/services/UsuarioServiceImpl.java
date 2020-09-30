package cl.springboot.errores.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.springboot.errores.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private List<Usuario> lista;
	
	
	
	public UsuarioServiceImpl() {
		this.lista = Arrays.asList(new Usuario(1, "Juan Daniel", "M Queupul"),
				new Usuario(2, "Francisco Adrián", "Vera Cornejo"),
				new Usuario(3, "Ignacio Javier", "Zuñiga Diaz")
				);
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = null;
		//long cantidad = lista.stream().filter(usu -> usu.getId() == id).count();
		for(Usuario user : lista) {
			if(user.getId().equals(id)) {
				usuario = user;
				break;
			}
		}
		return usuario;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario user = obtenerPorId(id);
		return Optional.ofNullable(user);
	}

}
