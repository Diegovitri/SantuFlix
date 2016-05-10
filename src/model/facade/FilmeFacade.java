package model.facade;

import java.util.List;

import model.domain.Filme;

public interface FilmeFacade {

	List<Filme> getFilmes();

	List<Filme> getFilmes(Integer codigo);

	Filme salvar(Filme Filme);

	void atualizar(Filme Filme);

	void deletarFilme(Integer codigo);

}
