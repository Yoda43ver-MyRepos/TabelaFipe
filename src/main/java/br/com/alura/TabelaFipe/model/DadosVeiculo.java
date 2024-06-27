package br.com.alura.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(
    @JsonAlias("Valor") String valor,
    @JsonAlias("Marca") String marca,
    @JsonAlias("Modelo") String modelo,
    @JsonAlias("AnoModelo")Integer ano,
    @JsonAlias("Combustivel")String tipoCombustivel


){
    @Override
    public String toString() {
        return    " Valor: " + valor
                + " marca: " + marca
                + " Modelo: " + modelo
                + " ano: " + ano
                + " Combustivel: "+tipoCombustivel;

    }
}


