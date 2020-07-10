package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class EstudanteController {

	// TODO efetue a correção dos problemas que existem na classe Estudante Controller
	EstudandeService service;
	
	@Autowired
	private EstudanteRepository er;

	@GetMapping("/")
	public ModelAndView index(){
		ModelAndView andView = new ModelAndView("index");
		Iterable<Estudante> estudantesIt = er.findAll();
		andView.addObject("estudantes", estudantesIt);
		return andView;
	}

	@GetMapping("estudantes/criar")
	public String iniciarCastrado(Estudante estudante) {
		return "estudantes/cadastrar-estudante";
	}

	@GetMapping("estudantes/listar")
	public ModelAndView listarEstudantes() {
		ModelAndView andView = new ModelAndView("index");
		Iterable<Estudante> estudantesIt = er.findAll();
		andView.addObject("estudantes", estudantesIt);
		return andView;
	}

	@PostMapping("estudantes/add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "estudantes/cadastrar-estudante";
		}

		er.save(estudante);
		model.addAttribute("estudante", er.findAll());
		return "redirect:listar";
	}

	@GetMapping("estudantes/editar/{id}")
	public ModelAndView exibirEdicaoEstudante(@PathVariable("id") long id) {

		Optional<Estudante> estudante = er.findById(id);

		ModelAndView modelAndView = new ModelAndView("estudantes/atualizar-estudante");
		modelAndView.addObject("estudante", estudante.get());
		return modelAndView;
	}

	@PostMapping("estudantes/atualizar/{id}")
	public String atualizarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "estudantes/atualizar-estudante";
		}

		er.save(estudante);
		model.addAttribute("estudantes", er.findAll());
		return "index";
	}

	@GetMapping("estudantes/apagar/{id}")
	public String apagarEstudante(Estudante estudante, Model model) {
		er.delete(estudante);
		model.addAttribute("estudantes", er.findAll());
		return "index";
	}
}
