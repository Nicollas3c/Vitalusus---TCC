package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Comentario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="texto")
    private String texto;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="videoaula_id")
    private Videoaula videoaula;

}
