package br.com.alura.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Dados(String codigo, String nome){
    @Override
    public String toString() {
        return "Cód: " + codigo +" Descrição: "+ nome;

    }
}
