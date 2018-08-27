package br.com.iago.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.iago.pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(" SELECT NEW Pessoa(pes.id, pes.nome, "
			+ " pes.cpf, pes.dataNascimento, pes.email, "
			+ " (SELECT COUNT(*) FROM Telefone tel WHERE tel.pessoa = pes) ) "
			+ " FROM Pessoa pes "
			+ " WHERE (:nome IS NULL OR pes.nome LIKE :nome) "
			+ " AND (:cpf IS NULL OR pes.cpf = :cpf)")
	List<Pessoa> buscarPessoa(@Param("nome") String nome, @Param("cpf") String cpf);
	
	@Query(" SELECT NEW Pessoa(pes.id, pes.nome, "
			+ " pes.cpf, pes.dataNascimento, pes.email) "
			+ " FROM Pessoa pes "
			+ " WHERE pes.id = :id")
	Pessoa consultarPorCodigo(@Param("id") Long id);
	
	@Query("SELECT MAX(pes.id) FROM Pessoa pes")
	Long buscarMaiorId();
	
}
