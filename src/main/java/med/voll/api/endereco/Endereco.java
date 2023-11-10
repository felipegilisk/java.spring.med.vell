package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(EnderecoData novoEnd) {
        this.logradouro = novoEnd.logradouro();
        this.numero = novoEnd.numero();
        this.complemento = novoEnd.complemento();
        this.cep = novoEnd.cep();
        this.bairro = novoEnd.bairro();
        this.cidade = novoEnd.cidade();
        this.uf = novoEnd.uf();
    }

    public void atualizar(EnderecoData novoEnd) {
        if (novoEnd.logradouro() != null) {
            this.logradouro = novoEnd.logradouro();
        }
        if (novoEnd.numero() != null) {
            this.numero = novoEnd.numero();
        }
        if (novoEnd.complemento() != null) {
            this.complemento = novoEnd.complemento();
        }
        if (novoEnd.cep() != null) {
            this.cep = novoEnd.cep();
        }
        if (novoEnd.bairro() != null) {
            this.bairro = novoEnd.bairro();
        }
        if (novoEnd.cidade() != null) {
            this.cidade = novoEnd.cidade();
        }
        if (novoEnd.uf() != null) {
            this.uf = novoEnd.uf();
        }
    }
}
