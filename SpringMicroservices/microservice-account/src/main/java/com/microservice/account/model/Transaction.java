package com.microservice.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactionlog")
public class Transaction {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "id_cuenta")
    private long idCuenta;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "monto")
    private double amount;

    @Column(name = "tipo_trx")
    private String tipoTrx;

}
