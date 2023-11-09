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
}
