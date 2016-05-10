package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.FilmeDao;
import model.domain.Filme;
import model.facade.FilmeFacade;

@Path("/filme")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class FilmeFacadeImpl implements FilmeFacade {

	@Inject
	private FilmeDao FilmeDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.FilmeFacade#getFilmes()
	 */
	@Override
	@GET
	public List<Filme> getFilmes() {
		return FilmeDao.getFilmes(new Filme());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.FilmeFacade#getFilmes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Filme> getFilmes(@PathParam("codigo") Integer codigo) {
		Filme Filme = new Filme();
		Filme.setCodigo(codigo);
		return FilmeDao.getFilmes(Filme);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.FilmeFacade#salvar(model.domain.Filme)
	 */
	@Override
	@POST 
	public Filme salvar(Filme Filme) { 
		Filme = FilmeDao.salvar(Filme);
	 	return Filme;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.FilmeFacade#atualizar(model.domain.Filme)
	 */
	@Override
	@PUT 
	public void atualizar(Filme Filme) { 
		FilmeDao.atualizar(Filme);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.FilmeFacade#deletarFilme(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarFilme(@PathParam("codigo") Integer codigo) {
		Filme Filme = new Filme();
		Filme.setCodigo(codigo);
		FilmeDao.excluir(Filme);
	}
}
