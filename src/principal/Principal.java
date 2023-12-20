package principal;

import client.ViaCepClient;
import modelo.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.*;
import modelo.EnderecoViaCep;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leituraCep = new Scanner(System.in);
        var buscaCep = "";
        List<Endereco> enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();


        while(!buscaCep.equals("sair")){

        System.out.println("Digite um CEP ou 'sair' para finalizar o programa: ");
        buscaCep = leituraCep.nextLine();

            if (buscaCep.equals("sair")){
                break;
            }

        try {

            ViaCepClient cepClient = new ViaCepClient();
            HttpResponse<String> httpResponse = cepClient.procurarCep(buscaCep);
            String json = httpResponse.body();

            EnderecoViaCep meuEndCep = gson.fromJson(json, EnderecoViaCep.class);

            Endereco meuEndereco = new Endereco(meuEndCep);
            System.out.println(meuEndereco);

            enderecos.add(meuEndereco);
        } catch (Exception e){
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());
        }

        }

        System.out.println(enderecos);
        FileWriter escrita = new FileWriter("enderecosCep.json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();


    }
}
