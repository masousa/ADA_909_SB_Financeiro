package tech.ada.samples.nine.six.six.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Pacote_Usuario")
@Entity
@Data
public class PacoteUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long pacoteId;
    private Long usuarioId;
    private double valor;
}
