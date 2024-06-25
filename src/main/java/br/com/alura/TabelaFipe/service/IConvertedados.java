package br.com.alura.TabelaFipe.service;

public interface IConvertedados {

    <T> T obterDados (String json, Class<T> classe);
}
