package com.max.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cep", "logradouro", "complemento", "bairro", "localidade", "uf", "unidade", "ibge", "gia" })
public class CepDTO {

	@JsonProperty("cep")
	private String cep;
	@JsonProperty("logradouro")
	private String logradouro;
	@JsonProperty("complemento")
	private String complemento;
	@JsonProperty("bairro")
	private String bairro;
	@JsonProperty("localidade")
	private String localidade;
	@JsonProperty("uf")
	private String uf;
	@JsonProperty("unidade")
	private String unidade;
	@JsonProperty("ibge")
	private String ibge;
	@JsonProperty("gia")
	private String gia;

	@JsonProperty("cep")
	public String getCep() {
		return cep;
	}

	@JsonProperty("cep")
	public void setCep(String cep) {
		this.cep = cep;
	}

	@JsonProperty("logradouro")
	public String getLogradouro() {
		return logradouro;
	}

	@JsonProperty("logradouro")
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@JsonProperty("complemento")
	public String getComplemento() {
		return complemento;
	}

	@JsonProperty("complemento")
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@JsonProperty("bairro")
	public String getBairro() {
		return bairro;
	}

	@JsonProperty("bairro")
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@JsonProperty("localidade")
	public String getLocalidade() {
		return localidade;
	}

	@JsonProperty("localidade")
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@JsonProperty("uf")
	public String getUf() {
		return uf;
	}

	@JsonProperty("uf")
	public void setUf(String uf) {
		this.uf = uf;
	}

	@JsonProperty("unidade")
	public String getUnidade() {
		return unidade;
	}

	@JsonProperty("unidade")
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	@JsonProperty("ibge")
	public String getIbge() {
		return ibge;
	}

	@JsonProperty("ibge")
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	@JsonProperty("gia")
	public String getGia() {
		return gia;
	}

	@JsonProperty("gia")
	public void setGia(String gia) {
		this.gia = gia;
	}

}