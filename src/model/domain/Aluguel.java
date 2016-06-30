package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_ALUGUEL")
public class Aluguel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ALUGUEL")
	private Integer codigo;
	
	@NotNull(message="O campo cep é obrigatorio")
	@Pattern(regexp="\\d{4}-\\d{2}-\\d{2}",message="A data não esta no formato 2016-05-11")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_SOLICITACAO")
	private Date data;

	@NotNull(message="O código do cliente é obrigatorio")
	@Pattern(regexp="[0-9]",message="Coloque somente números")
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;

	@NotNull(message="O código do filme é obrigatorio")
	@Pattern(regexp="[0-9]",message="Coloque somente números")
	@ManyToOne
	@JoinColumn(name = "filme")
	private Filme filme;

	public Aluguel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluguel(Integer codigo, Date data, Cliente cliente, Filme filme) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
		this.filme = filme;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	//@XmlTransient
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Aluguel other = (Aluguel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluguel [codigo=" + codigo + ", data=" + data + ", cliente=" + cliente + ", filme=" + filme + "]";
	}

	
	
}
