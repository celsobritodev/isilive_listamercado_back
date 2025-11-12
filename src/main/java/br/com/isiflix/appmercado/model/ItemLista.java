package br.com.isiflix.appmercado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_itemlista")
public class ItemLista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_seq")
	private Integer numSeq;
	
	@Column(name="quantidade")
	private Double quantidade;
	
	@Column(name="preco_total")
	private Double precoTotal;
	
	@Column(name="concluido")
	private Integer concluido;
	
    // Muitos ItemLista podem estar associados a um Produto
    // Chave estrangeira: tbl_produto_id_produto
    // Exemplo: O produto "Arroz" pode aparecer em vários itens de lista
	@ManyToOne
	@JoinColumn(name="tbl_produto_id_produto")
	private Produto produto;
	
	
    // Muitos ItemLista podem pertencer a uma Lista
    // Chave estrangeira: tbl_lista_id_lista
    // Exemplo: Uma lista de compras pode ter vários itens
	@ManyToOne
	@JoinColumn(name="tbl_lista_id_lista")
	//@JsonBackReference: Lado "passivo" da relação (NÃO será serializado)
	@JsonBackReference // Lado "volta da referência"
	private Lista lista;

	public Integer getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(Integer numSeq) {
		this.numSeq = numSeq;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Integer getConcluido() {
		return concluido;
	}

	public void setConcluido(Integer concluido) {
		this.concluido = concluido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}
	
	

}
