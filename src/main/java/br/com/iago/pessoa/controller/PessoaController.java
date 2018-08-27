package br.com.iago.pessoa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.pessoa.model.Pessoa;
import br.com.iago.pessoa.service.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping(value = "/pessoa/salvar")
	public ResponseEntity<?> salvar(@RequestBody Pessoa pessoa) {
		
		pessoaService.salvar(pessoa);
		return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "/pessoa/alterar")
	public ResponseEntity<?> alterar(@RequestBody Pessoa pessoa) {
		
		pessoaService.alterar(pessoa);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/pessoa/excluir/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		
		pessoaService.excluir(id);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);

	}

	@PostMapping(value = "pessoa/buscarPessoa")
	public ResponseEntity<List<Pessoa>> buscarPessoa(@RequestBody Pessoa pessoa) {
		
		return new ResponseEntity<List<Pessoa>>(pessoaService.buscarPessoa(pessoa), HttpStatus.OK);

	}
	
	@GetMapping(value="pessoa/consultarPorCodigo/{id}")
	public ResponseEntity<Pessoa> consultarPorCodigo(@PathVariable Long id) {

		return new ResponseEntity<Pessoa>(pessoaService.consultarPorCodigo(id), HttpStatus.OK);

	}
	
}
