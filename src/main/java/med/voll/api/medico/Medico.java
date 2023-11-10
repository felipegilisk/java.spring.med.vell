package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private boolean status;

    public Medico(MedicoData novoMed) {
        this.nome = novoMed.nome();
        this.crm = novoMed.crm();
        this.email = novoMed.email();
        this.telefone = novoMed.telefone();
        this.especialidade = novoMed.especialidade();
        this.status = true;
        this.endereco = new Endereco(novoMed.endereco());
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCrm() {
        return this.crm;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void atualizar(MedicoUpdate dadosMed) {
        if (dadosMed.nome() != null) {
            this.nome = dadosMed.nome();
        }
        if (dadosMed.telefone() != null) {
            this.telefone = dadosMed.telefone();
        }
        if (dadosMed.endereco() != null) {
            this.endereco.atualizar(dadosMed.endereco());
        }
    }

    public void inativar() {
        this.status = false;
    }

    public void reativar() {
        this.status = true;
    }

}
