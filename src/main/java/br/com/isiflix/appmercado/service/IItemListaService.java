package br.com.isiflix.appmercado.service;

import java.util.List;

import br.com.isiflix.appmercado.model.ItemLista;

public interface IItemListaService {
	public List<ItemLista> recuperarPorLista(Integer idLista);
	public ItemLista inserirItem(ItemLista novo);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSeq);
	

}
