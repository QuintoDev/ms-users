package com.careassistant.users.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({ @JsonSubTypes.Type(value = Paciente.class, name = "PACIENTE"),
		@JsonSubTypes.Type(value = ProfesionalSalud.class, name = "PROFESIONAL_SALUD"),
		@JsonSubTypes.Type(value = Administrador.class, name = "ADMIN") })
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_usuario")
public class Usuario {

	@Id
	private Long id;

	private String nombre;

	@Column(unique = true, nullable = false)
	private String correo;

	private String contraseña;

	private String rol;

	public Usuario() {
	}

	public Usuario(Long id, String nombre, String correo, String contraseña, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void registrarse() {
		System.out.println(nombre + " se ha registrado correctamente.");
	}

	public void iniciarSesion() {
		System.out.println(nombre + " ha iniciado sesión.");
	}

	public void cerrarSesion() {
		System.out.println(nombre + " ha cerrado sesión.");
	}
}
