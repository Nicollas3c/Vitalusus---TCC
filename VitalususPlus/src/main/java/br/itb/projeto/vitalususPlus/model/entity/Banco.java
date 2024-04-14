package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Banco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "campo não preenchido")
    @Column(name="numeroCartao")
    private String numeroCartao;

    @OneToOne
    @JoinColumn(name="treinador_id")
    private Treinador treinaodor;
}
