package br.com.apiproduto.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.repository.ProdutoRepository;
import br.com.apiproduto.service.ProdutoService;
@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	
	@Override
	public List<Produto> buscarTodos() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Produto salvar(Produto produto) {
		
		return produtoRepository.save(produto);
	}

	@Override
	public void delete(Long id) {
		
		try {
			
			produtoRepository.deleteById(id);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao Excluir o Produto");
		}
		
	}

}
