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
import br.com.viagem.projeto.model.Cliente;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ICliente dao;
	
	@GetMapping
	public List<Cliente> listaClientes(){
		return (List<Cliente>) dao.findAll();
	}
	
	@PostMapping
	public Cliente criarClientes(@RequestBody Cliente cliente) {
		Cliente clienteNovo = dao.save(cliente);
		return clienteNovo;
	}
	
	@PutMapping
	public Cliente editarClientes(@RequestBody Cliente cliente) {
		Cliente clienteNovo = dao.save(cliente);
		return clienteNovo;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Cliente> excluirCliente(@PathVariable Integer id) {
		Optional<Cliente> cliente = dao.findById(id);
		dao.deleteById(id);
		return cliente;
	}
	
}

