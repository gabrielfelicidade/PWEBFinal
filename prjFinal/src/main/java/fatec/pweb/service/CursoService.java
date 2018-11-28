package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import fatec.pweb.dao.CursoDAO;
import fatec.pweb.model.Curso;

public class CursoService implements Serializable {

	private static final long serialVersionUID = 1L;
	CursoDAO cursoDAO = new CursoDAO();

	public Curso salvar(Curso curso) {
		curso = cursoDAO.save(curso);
		cursoDAO.closeEntityManager();
		return curso;

	}

	public List<Curso> getCursos() {
		List<Curso> list = cursoDAO.getAll(Curso.class);
		cursoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Curso curso) {
		cursoDAO.save(curso);
		cursoDAO.closeEntityManager();
	}

	public void remover(Curso curso) {
		curso = cursoDAO.getById(Curso.class, curso.getSigla());
		cursoDAO.remove(curso);
		cursoDAO.closeEntityManager();
	}

	public Curso getCursoByNome(String nome) {
		Query query = cursoDAO.getEntityManager().createQuery("SELECT o FROM Curso WHERE o.nome = :nome");
		query.setParameter("nome", nome);
		return (Curso) query.getSingleResult();
	}

	public Curso getById(Curso curso) {
		curso = cursoDAO.getById(Curso.class, curso.getSigla());
		cursoDAO.closeEntityManager();
		return curso;
	}

}
