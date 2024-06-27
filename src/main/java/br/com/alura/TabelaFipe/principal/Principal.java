package br.com.alura.TabelaFipe.principal;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.service.ConsumoApi;
import br.com.alura.TabelaFipe.service.Convertedados;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private Convertedados conversor = new Convertedados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        var menu = """
                *** OPÇÕES ***
                Carro
                Moto
                Caminhão
                                
                Digite uma das opções para consultar valores: 
                """;
        System.out.println(menu);

        var opcao = leitura.nextLine();
        String endereco;
        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }
        var json = consumo.obterJson(endereco);
        System.out.println(json);

        var marcas = conversor.converterListaParaClasse(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        //daqui para cá é comigo
        System.out.println();
        System.out.print("Informe o código da marca para consulta: ");
        var codigoMarca = leitura.nextLine();
        endereco += "/"+codigoMarca+"/modelos";

        json = consumo.obterJson(endereco);
        var modeloLista = conversor.converterParaClasse(json,Modelos.class);
        System.out.println("\nModelos desa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);



    }


}


