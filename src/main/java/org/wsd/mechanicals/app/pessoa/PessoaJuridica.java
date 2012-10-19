package org.wsd.mechanicals.app.pessoa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.google.common.base.Objects;

@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(name = "nomeRazaoSocial", length = 60)
	private String razaoSocial;

	@Column(name = "cpfCnpj", length = 20)
	private String cnpj;
	
	PessoaJuridica() {
	}

	PessoaJuridica(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PessoaJuridica) {
			PessoaJuridica other = (PessoaJuridica) obj;
			return Objects.equal(this.razaoSocial, other.razaoSocial);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.razaoSocial);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("razaoSocial", razaoSocial).toString();
	}

	@Override
	public String getNomeRazaoSocial() {
		return this.razaoSocial;
	}

	@Override
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.razaoSocial = nomeRazaoSocial;
	}

}