package tech.ada.exemplos.salao.beleza.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cnpj;
    private String identificador;
    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

}
