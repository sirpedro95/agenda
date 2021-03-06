package br.com.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.dao.EstadoDAO;
import br.com.agenda.entidade.Estado;

@Service
@Transactional
public class EstadoService {

	@Autowired
	EstadoDAO dao;

	public Estado salvar(Estado estado) {
		return dao.salvar(estado);
	}

	public void deletar(Long id) {
		dao.deletar(id);
	}

	public Estado buscarPorId(Long id) {

		Estado estado = null;
		
		if (id != null) {
			estado = dao.buscarPorId(id);

		}

		if (estado != null) {
			estado.getCidades().size();
		}

		return estado;
	}

	public List<Estado> listarTodos() {
		return dao.listarTodos();
	}

}
