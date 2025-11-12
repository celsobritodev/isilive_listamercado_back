package br.com.isiflix.appmercado.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.service.IItemListaService;

@RestController
//@CrossOrigin("*")
public class ItemListaController {
	
	
	//@Autowired
	//private IItemListaService service;
	
    private final IItemListaService service;
	
	// Injeção via construtor
	public ItemListaController(IItemListaService service) {
		this.service = service;
	}
	
	// 👈 **ADICIONE ESTE NOVO ENDPOINT**
    @GetMapping("/itemlista/lista/{idLista}")
    public ResponseEntity<List<ItemLista>> recuperarPorLista(@PathVariable Integer idLista) {
        List<ItemLista> itens = service.recuperarPorLista(idLista);
        if (itens != null && !itens.isEmpty()) {
            return ResponseEntity.ok(itens);
        }
        return ResponseEntity.noContent().build();
    }
    
	
	
	
	// inserir um item em uma lista de itens
	@PostMapping("/itemlista")
	public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista novo) {
		ItemLista res = service.inserirItem(novo);
		if(res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	// alterar um item em uma lista de itens
	@PutMapping("/itemlista/{numSeq}")
	public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Integer numSeq) {
		item.setNumSeq(numSeq);
		ItemLista res = service.alterarItem(item);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	// remove um item de uma lista de itens
	@DeleteMapping("/itemlista/{numSeq}")
	public ResponseEntity<?> apagar(@PathVariable Integer numSeq) {
		service.removerItem(numSeq);
		return ResponseEntity.ok("ok");
	}

}
