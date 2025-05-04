package com.careassistant.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
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

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Formato de correo inválido")
	@Column(unique = true, nullable = false)
	private String correo;

	@NotBlank(message = "La contraseña es obligatoria")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String contraseña;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String rol;
	
	@CreationTimestamp
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "fecha_creacion", updatable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "ultimo_login")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private LocalDateTime ultimoLogin;

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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(LocalDateTime ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
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
