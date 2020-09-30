package cl.springboot.errores.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.springboot.errores.app.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler({ArithmeticException.class})
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	@ExceptionHandler({NumberFormatException.class})
	public String numberFormatError(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Error de formateo de datos");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}	
	
	@ExceptionHandler({UsuarioNoEncontradoException.class})
	public String UsuarioNoEncontradoExceptionError(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "el objeto viene nulo.");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status", HttpStatus.NOT_FOUND.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}	
}


