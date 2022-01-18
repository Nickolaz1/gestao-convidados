package com.study.frontend.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.frontend.gestaofesta.model.Convidado;
import com.study.frontend.gestaofesta.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private ConvidadoRepository convidadoRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listaConvidados");
		modelAndView.addObject(new Convidado());
		modelAndView.addObject("convidados", convidadoRepository.findAll());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Convidado convidado) {
		convidadoRepository.save(convidado);
		return "redirect:/convidados";
	}

}
