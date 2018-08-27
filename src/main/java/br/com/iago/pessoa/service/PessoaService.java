package br.com.iago.pessoa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iago.pessoa.model.Pessoa;
import br.com.iago.pessoa.model.Telefone;
import br.com.iago.pessoa.repository.PessoaRepository;
import br.com.iago.pessoa.repository.TelefoneRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@Transactional
	public void salvar(Pessoa pessoa) {
		
		if(pessoa.getLstTelefone() != null) {
			for (Telefone telefone : pessoa.getLstTelefone()) {
				telefone.setPessoa(pessoa);
			}
		}
		
		pessoaRepository.save(pessoa);
		
	}
	
	@Transactional
	public void alterar(Pessoa pessoa) {
		
		if(pessoa.getLstTelefone() != null) {
			for (Telefone telefone : pessoa.getLstTelefone()) {
				telefone.setPessoa(pessoa);
			}
		}
		
		if(pessoa.getLstTelefoneAux() != null) {
			for (Telefone telefone : pessoa.getLstTelefoneAux()) {
				telefone.setPessoa(pessoa);
			}
		}
		
		Pessoa pessoaMerge = pessoaRepository.save(pessoa);
		ajustarListaTelefone(pessoa.getLstTelefoneAux(), pessoaMerge.getLstTelefone());
		
	}
	
	@Transactional
	public void excluir(Long id) {
		
		pessoaRepository.deleteById(id);
		
	}
	
	public List<Pessoa> buscarPessoa(Pessoa pessoa) {
		
		if(pessoa != null && pessoa.getNome() != null) {
			pessoa.setNome("%"+pessoa.getNome().toUpperCase()+"%");
		}
		return pessoaRepository.buscarPessoa(pessoa.getNome(), pessoa.getCpf());
	}
	
	public Pessoa consultarPorCodigo(Long id) {
		Pessoa pessoa = pessoaRepository.consultarPorCodigo(id);
		
		atualizarListaTelefone(pessoa);
		return pessoa;
	}
	
	public Boolean existsById(Long id) {
		return pessoaRepository.existsById(id);
	}
	
	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	private void atualizarListaTelefone(Pessoa pessoa) {
		if(pessoa != null && pessoa.getId() != null) {
			pessoa.setLstTelefone(telefoneRepository.recuperarTelefones(pessoa.getId()));	
		}
	}
	
	private void ajustarListaTelefone(final List<Telefone> lstBanco, final List<Telefone> lstPosterior) {
		
		final List<Telefone> lstRemocao = getListaItemRemovidoTelefone(lstBanco, lstPosterior);

		if (lstRemocao != null || !lstBanco.isEmpty()) {
			for (final Telefone tel : lstRemocao) {
				telefoneRepository.delete(telefoneRepository.findById(tel.getId()).get());
			}
		}

	}
	
	private List<Telefone> getListaItemRemovidoTelefone(final List<Telefone> lstBanco,
			final List<Telefone> lstPosterior) {
		
		if (lstBanco == null || lstBanco.isEmpty()) {
			return null;
		}

		if (lstPosterior == null || lstPosterior.isEmpty()) {
			return lstBanco;
		}

		final List<Telefone> retorno = new ArrayList<>();

		for (final Telefone tel : lstBanco) {
			if (!lstPosterior.contains(tel)) {
				retorno.add(tel);
			}
		}
		return retorno;
		
	}
	
}
