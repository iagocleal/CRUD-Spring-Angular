package br.com.iago.pessoa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.iago.pessoa.model.Pessoa;
import br.com.iago.pessoa.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoaApplicationTests {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void teste1_inserirUmaPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Iago");
		pessoa.setCpf("000.000.000-00");
		pessoa.setEmail("iago@teste.com");
		pessoa.setDataNascimento(new Date());
		
		pessoaRepository.save(pessoa);
		
		assertTrue(pessoaRepository.existsById(1L));
		
	}
	
	@Test
	public void teste2_AlterarNomeDeUmaPessoa() {
		Optional<Pessoa> pessoa = pessoaRepository.findById(1L);
		
		pessoa.get().setNome("Iago Leal");
		
		Pessoa pessoaBanco = pessoaRepository.save(pessoa.get());
		
		assertEquals("Iago Leal", pessoaBanco.getNome());
	}
	
	@Test
	public void teste3_consultarUmaPessoaPorId() {
		Pessoa pessoa = pessoaRepository.consultarPorCodigo(1L);
		
		assertNotNull(pessoa);
	}
	
	@Test
	public void teste4_deletarUmaPessoaPorId() {
		pessoaRepository.deleteById(1L);
		
		assertFalse(pessoaRepository.existsById(1L));
	}

}
