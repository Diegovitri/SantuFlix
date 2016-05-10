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

import model.dao.AluguelDao;
import model.domain.Aluguel;
import model.facade.AluguelFacade;

@Path("/aluguel")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AluguelFacadeImpl implements AluguelFacade {

	@Inject
	private AluguelDao AluguelDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AluguelFacade#getAluguels()
	 */
	@Override
	@GET
	public List<Aluguel> getAluguels() {
		return AluguelDao.getFilmes(new Aluguel());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AluguelFacade#getAluguels(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Aluguel> getAluguels(@PathParam("codigo") Integer codigo) {
		Aluguel Aluguel = new Aluguel();
		Aluguel.setCodigo(codigo);
		return AluguelDao.getFilmes(Aluguel);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AluguelFacade#salvar(model.domain.Aluguel)
	 */
	@Override
	@POST 
	public Aluguel salvar(Aluguel Aluguel) { 
		Aluguel = AluguelDao.salvar(Aluguel);
	 	return Aluguel;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AluguelFacade#atualizar(model.domain.Aluguel)
	 */
	@Override
	@PUT 
	public void atualizar(Aluguel Aluguel) { 
		AluguelDao.atualizar(Aluguel);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.AluguelFacade#deletarAluguel(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAluguel(@PathParam("codigo") Integer codigo) {
		Aluguel Aluguel = new Aluguel();
		Aluguel.setCodigo(codigo);
		AluguelDao.excluir(Aluguel);
	}

}
