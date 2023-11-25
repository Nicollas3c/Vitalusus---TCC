package com.vitalususPlus.VitalususPlus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name="nome", length=100, unique=false, nullable=false, updatable=false)
    private String nome;
    
    @Column(name="email", length=100, unique=true, nullable=false)
    private String email;
    
    @Column(name="senha", length=50, unique=false, nullable=false)
    private String senha;
    
    @Column(name="genero", unique=false, length=10, nullable=false)
    private String genero;
    
    @Column(name="telefone", unique=false, length=16,nullable=false)
    private String telefone;
    
    @Column(name="dataNasc", unique=false,length=10, nullable=false, updatable=false)
    private String dataNasc;
    
    @Column(name="statusUsu", unique=false, length=7, nullable=false )
    private String statusUsuario;
    
    @Column(name="tipoPessoa", length=12, unique=false, nullable=false)
    private String tipoPessoa;

    @OneToOne
    private Treinador treinador;

    @OneToOne
    private Admin admin;

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
