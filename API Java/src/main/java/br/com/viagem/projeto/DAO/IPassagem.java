package br.com.viagem.projeto.DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.viagem.projeto.model.Passagem;

public interface IPassagem extends CrudRepository<Passagem, Integer>{


}