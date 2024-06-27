package br.com.alura.TabelaFipe.service;

import java.util.List;

public interface IConvertedados {

    <T> T converterParaClasse (String json, Class<T> classe);

    <T> List<T> converterListaParaClasse (String json, Class<T> classe);
}
