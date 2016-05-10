package model.facade;

import java.util.List;

import model.domain.Aluguel;

public interface AluguelFacade {

	List<Aluguel> getAluguels();

	List<Aluguel> getAluguels(Integer codigo);

	Aluguel salvar(Aluguel Aluguel);

	void atualizar(Aluguel Aluguel);

	void deletarAluguel(Integer codigo);

}
