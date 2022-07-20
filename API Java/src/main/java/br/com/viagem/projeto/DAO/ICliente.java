package br.com.viagem.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.viagem.projeto.model.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer>{

}
