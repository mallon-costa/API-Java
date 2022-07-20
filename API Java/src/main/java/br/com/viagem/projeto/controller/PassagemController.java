package br.com.viagem.projeto.controller;


import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;
import javax.websocket.server.PathParam;

import br.com.viagem.projeto.DAO.IPassagem;
import br.com.viagem.projeto.model.Passagem;

@RestController
@CrossOrigin("*")
@RequestMapping("/passagens")
public class PassagemController {

	@Autowired
	private IPassagem dao;
	
	private LocalDate date = LocalDate.now();
	/*
	@RequestMapping("/transacoes")
	public List<Passagem> lista(String data) {
	    LocalDate dataDaTransacao = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	    if (dataDaTransacao == null) {
	        List<Passagem> transacao = (List<Passagem>) dao.findAll();
	        return TransacaoDto.converter(transacao);
	    } else {
	        List<Transacao> transacao = transacaoRepository.findByDataDaTransacao(dataDaTransacao);
	        return TransacaoDto.converter(transacao);
	    }
	}
	*/
	@GetMapping
	public List<Passagem> listaPassagens(@RequestParam ("dataInicio") java.sql.Date dataInicio, @RequestParam ("dataFim") java.sql.Date dataFim){
		List<Passagem> passagem = (List<Passagem>) dao.findAll();
		List<Passagem> auxiliar = new ArrayList<Passagem>();
		
		for(int i = 0; i < passagem.size(); i++) {
			if((passagem.get(i).getData_ida().getTime() >= dataInicio.getTime()) &&  (passagem.get(i).getData_volta().getTime() <= dataFim.getTime())) {
				auxiliar.add(passagem.get(i));
			}
		}
		return auxiliar;
		//return auxiliar;
		//return 0;
		//return cont;
	}
	/*
	@Override public boolean equals(Object passagem) { 
	    if (this.dao. == ((Livro) livro).getNome()){
	         return true; } return false;
	}*/
	
	/*
	@GetMapping
	public ResponseEntity<List<Passagem>> findByPeriod(LocalDate inicio, LocalDate termino) {
	    List<Passagem> collection = dao.findByPeriod(inicio, termino);
	    return ResponseEntity.ok().body(collection);
	}
	*/
	
	/*
	@GetMapping
	public List<Passagem> listaPassagens(){
		return (List<Passagem>) dao.findAll();
	}*/
	
	@PostMapping
	public Passagem criarPassagem(@RequestBody Passagem passagem) {
		Passagem passagemNova = dao.save(passagem);
		return passagemNova;
	}
	
	@PutMapping
	public Passagem editarPassagem(@RequestBody Passagem passagem) {
		Passagem passagemNova = dao.save(passagem);
		return passagemNova;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Passagem> excluirPassagem(@PathVariable Integer id) {
		Optional<Passagem> passagem = dao.findById(id);
		dao.deleteById(id);
		return passagem;
	}
	
}

