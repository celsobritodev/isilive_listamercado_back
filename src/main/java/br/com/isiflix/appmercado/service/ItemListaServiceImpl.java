package br.com.isiflix.appmercado.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.repo.ItemListaRepo;

@Component
public class ItemListaServiceImpl implements IItemListaService{

	//@Autowired
	//private ItemListaRepo repo;
	
    private final ItemListaRepo repo;
    
 // 👈 IMPLEMENTE ESTE MÉTODO
    @Override
    public List<ItemLista> recuperarPorLista(Integer idLista) {
        return repo.findByListaId(idLista);
    }
    
	
	// Injeção via construtor
	public ItemListaServiceImpl(ItemListaRepo repo) {
		this.repo = repo;
	}
	
	
	@Override
	public ItemLista inserirItem(ItemLista novo) {
	
		return repo.save(novo); // sem chave primaria, o save é um insert
	}

	@Override
	public ItemLista alterarItem(ItemLista item) {

		return repo.save(item); // com chave primaria o save entende que é um update
	}

	@Override
	public void removerItem(Integer numSeq) {

		repo.deleteById(numSeq);
	}

}
