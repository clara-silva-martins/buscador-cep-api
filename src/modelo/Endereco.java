package modelo;

import com.google.gson.annotations.SerializedName;

public class Endereco {

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    private Integer ddd;

    public Endereco(EnderecoViaCep meuEndCep) {
        this.cep = meuEndCep.cep();
        this.logradouro = meuEndCep.logradouro();
        this.bairro = meuEndCep.bairro();
        this.localidade = meuEndCep.localidade();
        this.uf = meuEndCep.uf();
        this.ddd = meuEndCep.ddd();
    }

    @Override
    public String toString() {
        return "[Endereco: " +
                "CEP= '" + cep + '\'' +
                ", Logradouro='" + logradouro + '\'' +
                ", Bairro='" + bairro + '\'' +
                ", Localidade='" + localidade + '\'' +
                ", UF='" + uf + '\'' +
                ", DDD='" + ddd +
                "']";
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }
}
