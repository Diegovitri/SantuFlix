package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.FilmeDao;
import model.domain.Filme;
import model.facade.FilmeFacade;

@WebService(serviceName="ws/Filme")
public class FilmeFacadeImpl implements FilmeFacade {

	@Inject
	private FilmeDao FilmeDao;
			
	@WebMethod
	public List<Filme> getFilmes() {
		return FilmeDao.getFilmes(new Filme());
	}
	
	@Override
	@WebMethod(operationName="getFilmeCodigo")
	public List<Filme> getFilmes(@WebParam(name="codigoFilme") 
							Integer codigo) {
		Filme Filme = new Filme();
		Filme.setCodigo(codigo);
		return FilmeDao.getFilmes(Filme);
	}
	
	@WebMethod
	public Filme salvar(@WebParam(name="Filme") Filme Filme) {
		return FilmeDao.salvar(Filme);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="Filme") Filme Filme) {
		FilmeDao.atualizar(Filme);
	}
	
	@WebMethod
	public void deletarFilme(@WebParam(name="codigoFilme") Integer codigo) {
		Filme Filme = new Filme();
		Filme.setCodigo(codigo);
		FilmeDao.excluir(Filme);
	}
}
