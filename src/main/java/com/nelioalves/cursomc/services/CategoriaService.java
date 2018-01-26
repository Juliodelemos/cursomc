package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	/*
	 * Instancia um objeto do tipo repository (CategoriaRepository)
	 * @Autowired faz a instanciação do objeto (spring faz isso)
	 */
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		/*
		 * Implementando tratamento de erros
		 */
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!!! Id " + id 
					+ ", Tipo: "+ Categoria.class.getName() );
		}
		return obj;
	}
	
}
