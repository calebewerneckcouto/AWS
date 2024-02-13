package br.com.apiproduto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		Produto novoProduto = produtoService.salvar(produto);

		return new ResponseEntity(novoProduto, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {

		produtoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
