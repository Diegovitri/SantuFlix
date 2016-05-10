package model.dao;

import java.util.List;

import model.domain.Filme;

public interface FilmeDao {
List<Filme> getFilmes(Filme filme);
	
	public void excluir(Filme filme);

	Filme salvar(Filme filme);

	void atualizar(Filme filme);

}
