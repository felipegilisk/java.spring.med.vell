package med.voll.api.domain.especialidade;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "especialidades")
@Entity(name = "Especialidade")
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String descricao;
    boolean status;

    public Especialidade(EspecialidadeData novaEsp){
        this.nome = novaEsp.nome();
        this.descricao = novaEsp.descricao();
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inativar() {
        this.setStatus(false);
    }
}
