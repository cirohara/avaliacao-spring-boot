package br.com.tokiomarine.seguradora.avaliacao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javassist.SerialVersionUID;


@Entity
public class Estudante implements Serializable{
	
	private static final long SerialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @NotEmpty(message = "Nome é obrigatório")
    @NotNull(message = "Nome é obrigatório")
	private String nome;
    
    @Email(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @NotNull(message = "Email é obrigatório")
    private String email;
    
    private String telefone;

    @NotEmpty(message = "Matricula é obrigatório")
    @NotNull(message = "Matricula é obrigatório")
    private String matricula;

    private String curso;

    public Estudante() {

    }
    
    public Estudante(String nome, String email, String telefone) {
    	this.nome = nome;
    	this.email = email;
    	this.telefone = telefone;
    }
    
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    @Column
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    @Column
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    @Column
    public String getTelefone() {
    	return telefone;
    }
    
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }

    @Column
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Column
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
    	return "Estudante{" +
    			"id=" + id +
    			", nome='" + nome + '\''+
    			", email= '" + email + '\''+
                ", telefone= " + telefone +
                ", matricla= '" + matricula + '\''+
                ", curso= " + curso +
    			'}';
    }
}
