package com.tr.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tr.festa.model.Convidado;
import com.tr.festa.repository.ConvidadosRepo;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private ConvidadosRepo repo;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", repo.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Convidado convidado) {
		this.repo.save(convidado);
		return "redirect:/convidados";
	}

}
