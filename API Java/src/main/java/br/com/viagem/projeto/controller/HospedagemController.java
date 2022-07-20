package br.com.viagem.projeto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import br.com.viagem.projeto.DAO.IHospedagem;
import br.com.viagem.projeto.model.Hospedagem;

@RestController
@CrossOrigin("*")
@RequestMapping("/hospedagens")
public class HospedagemController {

	@Autowired
	private IHospedagem dao;
	
	@GetMapping
	public List<Hospedagem> listaPassagens(@RequestParam ("dataInicio") java.sql.Date dataInicio, @RequestParam ("dataFim") java.sql.Date dataFim){
		List<Hospedagem> hospedagem = (List<Hospedagem>) dao.findAll();
		List<Hospedagem> auxiliar = new ArrayList<Hospedagem>();
		
		for(int i = 0; i < hospedagem.size(); i++) {
			if((hospedagem.get(i).getData_entrada().getTime() >= dataInicio.getTime()) &&  (hospedagem.get(i).getData_saida().getTime() <= dataFim.getTime())) {
				auxiliar.add(hospedagem.get(i));
			}
		}
		return auxiliar;
		//return auxiliar;
		//return 0;
		//return cont;
	}
	
	/*
	@GetMapping
	public List<Hospedagem> listaHospedagens(){
		return (List<Hospedagem>) dao.findAll();
	}
	*/
	@PostMapping
	public Hospedagem criarHospedagem(@RequestBody Hospedagem hospedagem) {
		Hospedagem hospedagemNova = dao.save(hospedagem);
		return hospedagemNova;
	}
	
	@PutMapping
	public Hospedagem editarHospedagem(@RequestBody Hospedagem hospedagem) {
		Hospedagem hospedagemNova = dao.save(hospedagem);
		return hospedagemNova;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Hospedagem> excluirHospedagem(@PathVariable Integer id) {
		Optional<Hospedagem> hospedagem = dao.findById(id);
		dao.deleteById(id);
		return hospedagem;
	}
	
}

