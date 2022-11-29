package com.dh.clinica.demo.persistence.entities.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    @Column
    private Integer id;

    @Setter
    @Column
    private Integer dni;

    @Setter
    @Column
    private String username;

    @Setter
    @Column
    private String email;

    @Setter
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="UsuarioRoles",
            joinColumns = @JoinColumn(name="id_usuario"),
            inverseJoinColumns = @JoinColumn(name="id_rol")
    )
    private Set<Rol> roles;

    public Usuario(Integer dni, String username, String email, String password, Set<Rol> roles) {
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
