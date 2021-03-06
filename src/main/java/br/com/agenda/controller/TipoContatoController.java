package br.com.agenda.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.agenda.entidade.TipoContato;
import br.com.agenda.service.TipoContatoService;
import br.com.agenda.utils.UtilsGeral;

@Controller
@ManagedBean
public class TipoContatoController {

	private TipoContato tipoContato;

	private String nomeTipoContato;

	@Autowired
	TipoContatoService tipoContatoService;
	
	@PostConstruct
	public void init() {
		this.tipoContato = new TipoContato();
	}

	public void listar() {
		UtilsGeral.redirecionar("/admin/tipoContato/listar.xhtml");
	}

	public void novo() {
		tipoContato = new TipoContato();
		nomeTipoContato = "";
		UtilsGeral.redirecionar("/admin/tipoContato/form.xhtml");
	}

	public void editar(TipoContato tipoContato) {
		nomeTipoContato = tipoContato.getTipo();
		UtilsGeral.redirecionar("/admin/tipoContato/form.xhtml");
	}

	public void excluir(TipoContato tipoContato) {

		try {
			tipoContatoService.deletar(tipoContato.getId());
			UtilsGeral.adicionarMsgInfo("Tipo de contato exclu�do com sucesso.");
		} catch (Exception e) {
			UtilsGeral.adicionarMsgErro("Existe um cliente utilizando esse tipo de contato. Imposs�vel excluir.");
		}

	}

	public List<TipoContato> getListaTiposContato() {
		return tipoContatoService.listarTodos();
	}

	public void salvar() {

		tipoContato.setTipo(nomeTipoContato);

		tipoContatoService.salvar(tipoContato);

		UtilsGeral.adicionarMsgInfo("Tipo de contato salvo com sucesso.");
		UtilsGeral.redirecionar("/admin/tipoContato/listar.xhtml");

	}

	public String getNomeTipoContato() {
		return nomeTipoContato;
	}

	public void setNomeTipoContato(String nomeTipoContato) {
		this.nomeTipoContato = nomeTipoContato;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

}
