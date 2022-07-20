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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import br.com.viagem.projeto.DAO.ICliente;
import br.com.viagem.projeto.DAO.IPagamento;
import br.com.viagem.projeto.model.Pagamento;
import br.com.viagem.projeto.model.Pagamento;

@RestController
@CrossOrigin("*")
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	private IPagamento dao;
	
	@GetMapping
	public List<Pagamento> listaPagamento(){
		return (List<Pagamento>) dao.findAll();
	}
	
	@PostMapping
	public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
		Pagamento pagamentoNovo = dao.save(pagamento);
		return pagamentoNovo;
	}
	
	@PutMapping
	public Pagamento editarClientes(@RequestBody Pagamento pagamento) {
		Pagamento pagamentoNovo = dao.save(pagamento);
		return pagamentoNovo;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Pagamento> excluirCliente(@PathVariable Integer id) {
		Optional<Pagamento> pagamento = dao.findById(id);
		dao.deleteById(id);
		return pagamento;
	}
	
}



