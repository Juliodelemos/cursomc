package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


/*
 * Mapeando a entidade para o JPA
 * Utilizar sempre o javax.persistence.Entity (que é a Interface)
 */
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double preco;
	
	/*
	 * Mapeando a coleção de categorias
	 * Relacionamento muitos para muitosMany
	 * @ManyToMany                                                          notação indicando tipo de relacionamento (MxM)
	 * @JoinTable(name="PRODUTO_CATEGORIA",                                 Notação criando a tabela intermediaria chamada PRODUTO_CATEGORIA
	 *	joinColumns= @JoinColumn(name="produto_id"),                        joinColumns nome que será dado para a chave estrangeira na tabela que eu estou (Produto)
	 *	inverseJoinColumns = @JoinColumn(name="categoria_id")               InverseJoinColumns  nome da outra chave strangeira que vai referenciar a Categoria
	 *
	 * ATENÇÃO:
	 * --------
	 *  Basta fazer o mapeamento (MxM) de um lado do relacionamento,
	 *  no outro lado, basta referencia-lo com @ManyToMany(mappedBy="categorias")
	 *  
	 *  @JsonBackReference   -> indica que um produto não terá uma coleção de categorias (veja a implementação de @JsonManagedReference na classe Categoria)
	 */
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="PRODUTO_CATEGORIA",
		joinColumns= @JoinColumn(name="produto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	/*
	 * Necessario um contrutor vazio
	 */
	public Produto() {}

	/*
	 * Necessário um construtor com os atributos, EXCETO coleções
	 */
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	/*
	 * Métodos Getters and Setters
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * Source - Generate hashCode and equals
	 * (para que o java faça a comparação entre os conteúdos e não entre os ponteiros
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	};
	
	
	
}
