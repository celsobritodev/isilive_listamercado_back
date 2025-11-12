package br.com.isiflix.appmercado.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_lista")
public class Lista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_lista")
	private Integer id;
	
	@Column(name="data_criacao", nullable=false)
	private LocalDate data;
	
	@Column(name="nome_mercado", length=50)
	private String nomeMercado;
	
	@Column(name="valor_total" )
	private Double valorTotal;
	
	@Column(name="status")
	private Integer status;
	
	
    // Uma Lista pode ter muitos ItemLista
    // mappedBy="lista": Indica que o relacionamento é bidirecional e o lado dono é o ItemLista
    // cascade = CascadeType.ALL: Operações na Lista afetam os Itens automaticamente
	@OneToMany(mappedBy="lista", cascade = CascadeType.ALL)
	@JsonManagedReference // Lado "gerenciado"
	private List<ItemLista> itens;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getNomeMercado() {
		return nomeMercado;
	}
	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<ItemLista> getItens() {
		return itens;
	}
	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}
	
	
	

}
