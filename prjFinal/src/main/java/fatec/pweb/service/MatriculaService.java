package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.MatriculaDAO;
import fatec.pweb.model.Matricula;

public class MatriculaService {
	MatriculaDAO matriculaDAO = new MatriculaDAO();

	public Matricula salvar(Matricula matricula) {
		matricula = matriculaDAO.save(matricula);
		matriculaDAO.closeEntityManager();
		return matricula;

	}

	public List<Matricula> getMatriculas() {
		List<Matricula> list = matriculaDAO.getAll(Matricula.class);
		matriculaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Matricula matricula) {
		matriculaDAO.save(matricula);
		matriculaDAO.closeEntityManager();
	}

	public void remover(Matricula matricula) {

		matricula = matriculaDAO.getById(Matricula.class, matricula.getCodigo());
		matriculaDAO.remove(matricula);
		matriculaDAO.closeEntityManager();
	}
}
