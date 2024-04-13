package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
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
    @Column(name="numeroCartao")
    private Long numeroCartao;

    @OneToOne
    @JoinColumn(name="treinador_id")
    private Treinador treinaodor;
}
