package br.com.isiflix.appmercado.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.isiflix.appmercado.model.ItemLista;

public interface ItemListaRepo extends CrudRepository<ItemLista,Integer>{
	// 👈 ADICIONE ESTE MÉTODO
    List<ItemLista> findByListaId(Integer idLista);

}
