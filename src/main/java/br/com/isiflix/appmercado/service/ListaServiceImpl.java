package br.com.isiflix.appmercado.service;

import java.util.List;

import org.springframework.stereotype.Component;
import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.model.Lista;
import br.com.isiflix.appmercado.repo.ListaRepo;


@Component
public class ListaServiceImpl implements IListaService {

	//@Autowired
	//private ListaRepo repo;
	
    private final ListaRepo repo;
	
	// Injeção via construtor
	public ListaServiceImpl(ListaRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Lista criarNovaLista(Lista nova) {

		return repo.save(nova);
	}

	@Override
	public void removerLista(Integer id) {

		repo.deleteById(id);
		
	}

	@Override
	public Lista fecharLista(Integer id) {

		Lista lista = repo.findById(id).orElseThrow(() -> 
        new RuntimeException("Lista não encontrada com ID: " + id));
		
		 // Usando stream e lambda para calcular o total
	    double total = lista.getItens().stream()
	        .mapToDouble(ItemLista::getPrecoTotal)  // Lambda method reference
	        .sum();
		
		
		lista.setValorTotal(total);
		lista.setStatus(1); // lista concluida
		return repo.save(lista);
	}

	@Override
	public Lista buscarPeloId(Integer id) {
	
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Lista> buscarTodas() {
	
		return (List<Lista>) repo.findAll();
	}

}
