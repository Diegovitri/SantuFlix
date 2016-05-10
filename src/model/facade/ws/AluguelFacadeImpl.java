package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AluguelDao;
import model.domain.Aluguel;
import model.facade.AluguelFacade;

@WebService(serviceName="ws/Aluguel")
public class AluguelFacadeImpl implements AluguelFacade {

	@Inject
	private AluguelDao AluguelDao;
			
	@WebMethod
	public List<Aluguel> getAluguels() {
		return AluguelDao.getFilmes(new Aluguel());
	}
	
	@Override
	@WebMethod(operationName="getAluguelCodigo")
	public List<Aluguel> getAluguels(@WebParam(name="codigoAluguel") 
							Integer codigo) {
		Aluguel Aluguel = new Aluguel();
		Aluguel.setCodigo(codigo);
		return AluguelDao.getFilmes(Aluguel);
	}
	
	@WebMethod
	public Aluguel salvar(@WebParam(name="Aluguel") Aluguel Aluguel) {
		return AluguelDao.salvar(Aluguel);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="Aluguel") Aluguel Aluguel) {
		AluguelDao.atualizar(Aluguel);
	}
	
	@WebMethod
	public void deletarAluguel(@WebParam(name="codigoAluguel") Integer codigo) {
		Aluguel Aluguel = new Aluguel();
		Aluguel.setCodigo(codigo);
		AluguelDao.excluir(Aluguel);
	}
}
