package tech.ada.samples.nine.six.six.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "fatura")
@Entity
@Data
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mes;

    private int ano;

    private Long usuarioId;

    private double valor;

    private FaturaStatus status;



}
