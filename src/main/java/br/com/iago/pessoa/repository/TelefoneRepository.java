package br.com.iago.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.iago.pessoa.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	@Query(" SELECT NEW Telefone (tel.id, tel.ddd, "
			+ " tel.numero) "
			+ " FROM Telefone tel "
			+ " INNER JOIN tel.pessoa pes "
			+ " WHERE pes.id = :id")
	List<Telefone> recuperarTelefones(@Param("id") Long id);
	
	@Query("SELECT MAX(tel.id) FROM Telefone tel")
	Long buscarMaiorId();
	
}
