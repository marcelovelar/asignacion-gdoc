package com.example.controlpostulacionbackend.entidades;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid")
    private Short id;

    /*@Column(name = "personaid")
    private Short personaId;*/

    @ManyToOne
    @JoinColumn(name = "personaid", nullable = false)
    private Persona persona;

    @Column(name = "usuarionick")
    private String usuarioNick;

    @Column(name = "usuariocontrasenha")
    private String usuarioContrasenha;

    @Column(name = "usuariofechaalta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioFechaAlta;

    @Column(name = "usuariologueado")
    private Boolean usuarioLogueado;

    @Column(name = "usuarioestado")
    private String usuarioEstado;

    /*@ManyToOne
    @JoinColumn(name = "departamentoid", nullable = false)
    private Departamento departamento;*/

    @Column(name = "departamentocod")
    private Short departamentoCod;

    public Short getDepartamentoCod() {
        return departamentoCod;
    }

    public void setDepartamentoCod(Short departamentoCod) {
        this.departamentoCod = departamentoCod;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    // Getters y setters
    public Short getId() {
        return id;
    }

    public void setUsuarioId(Short id) {
        this.id = id;
    }

    /*public Short getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Short personaId) {
        this.personaId = personaId;
    }*/

    public String getUsuarioNick() {
        return usuarioNick;
    }

    public void setUsuarioNick(String usuarioNick) {
        this.usuarioNick = usuarioNick;
    }

    public String getUsuarioContrasenha() {
        return usuarioContrasenha;
    }

    public void setUsuarioContrasenha(String usuarioContrasenha) {
        this.usuarioContrasenha = usuarioContrasenha;
    }

    public Date getUsuarioFechaAlta() {
        return usuarioFechaAlta;
    }

    public void setUsuarioFechaAlta(Date usuarioFechaAlta) {
        this.usuarioFechaAlta = usuarioFechaAlta;
    }

    public Boolean getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Boolean usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(String usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }


}
