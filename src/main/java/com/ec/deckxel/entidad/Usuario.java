/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.deckxel.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author gato
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@JsonIgnore
	@Column(name = "usu_foto")
	private Character usuFoto;
	@Size(max = 20)
	@Column(name = "usu_whatsapp")
	private String usuWhatsapp;
	@JsonIgnore
	@Size(max = 100)
	@Column(name = "usu_pagina")
	private String usuPagina;
	@JsonIgnore
	@Size(max = 100)
	@Column(name = "usu_facebook")
	private String usuFacebook;
	@JsonIgnore
	@Column(name = "usu_numero_fotos")
	private Integer usuNumeroFotos;
	@Size(max = 150)
	@JsonIgnore
	@Column(name = "usu_fotografia")
	private String usuFotografia;
	@Size(max = 150)
	@JsonIgnore
	@Column(name = "usu_actividad")
	private String usuActividad;
	@Size(max = 150)
	@JsonIgnore
	@Column(name = "usu_servlet")
	private String usuServlet;
	@Column(name = "usu_activa_movil")
	private Boolean usuActivaMovil;
	@Column(name = "usu_fecha_reg_mov")
	@Temporal(TemporalType.TIMESTAMP)
	private Date usuFechaRegMov;
	@Column(name = "usu_fecha_caduca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date usuFechaCaduca;
	@JsonIgnore
	@Size(max = 300)
	@Column(name = "usu_descripcion_negocio")
	private String usuDescripcionNegocio;
	@JsonIgnore
	@Size(max = 100)
	@Column(name = "usu_long_negocio")
	private String usuLongNegocio;
	@JsonIgnore
	@Size(max = 100)
	@Column(name = "usu_lat_negocio")
	private String usuLatNegocio;
	@JsonIgnore
	@Column(name = "usu_es_drive")
	private Boolean usuEsDrive;
	@Column(name = "usu_drive_activo")
	@JsonIgnore
	private Boolean usuDriveActivo;
	@JsonIgnore
	@Size(max = 10)
	@Column(name = "usu_drive_placa")
	private String usuDrivePlaca;
	@JsonIgnore
	@Size(max = 20)
	@Column(name = "usu_drive_color")
	private String usuDriveColor;

	@Column(name = "usu_direccion")
	private String usuDireccion;
	@JsonIgnore
	@Column(name = "usu_drive_disponible")
	private Boolean usuDriveDisponible;
	@JsonIgnore
	@JoinColumn(name = "id_parroquia", referencedColumnName = "id_parroquia")
	@ManyToOne
	private Parroquia idParroquia;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	@Size(max = 100)
	@Column(name = "usu_nombre")
	private String usuNombre;
	@Size(max = 100)
	@Column(name = "usu_login")
	private String usuLogin;
	@Size(max = 100)
	@Column(name = "usu_password")
	private String usuPassword;
	@Size(max = 100)
	@Column(name = "usu_correo")
	private String usuCorreo;
	@Column(name = "usu_nivel")
	private Integer usuNivel;
	@Column(name = "usu_ruc")
	private String usuRuc;
	@JsonIgnore
	@Column(name = "usu_ilimitado")
	private Boolean usuIlimitado;
	@JsonIgnore
	@Column(name = "usu_num_documentos")
	private Integer usuNumDocumentos;
	@JsonIgnore
	@Column(name = "usu_total_contratado")
	private Integer usuTotalContratado;
	@Column(name = "usu_fecha_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date usuFechaRegistro;
	@JsonIgnore
	@Column(name = "usu_fecha_pago")
	@Temporal(TemporalType.TIMESTAMP)
	private Date usuFechaPago;
	@JsonIgnore
	@Size(max = 100)
	@Column(name = "usu_tipo_usuario")
	private String usuTipoUsuario;
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private Collection<Factura> facturaCollection;
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private Collection<CabeceraCompra> cabeceraCompraCollection;
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private Collection<CierreCaja> cierreCajaCollection;
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private Collection<OrdenTrabajo> ordenTrabajoCollection;
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private Collection<Tipoambiente> tipoambienteCollection;
	@JsonIgnore
	@Transient
	private String accionRest;
	@JsonIgnore
	@Transient
	private Integer codTipoAmbiente;
	@JsonIgnore
	@Transient
	private Tipoambiente tipoambiente;
	@OneToMany(mappedBy = "idUsuario")
    private Collection<Postulaciones> postulacionesCollection;

	public Usuario() {
	}

	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuNombre() {
		return usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public String getUsuLogin() {
		return usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuPassword() {
		return usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuCorreo() {
		return usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

	public Integer getUsuNivel() {
		return usuNivel;
	}

	public void setUsuNivel(Integer usuNivel) {
		this.usuNivel = usuNivel;
	}

//    public byte[] getUsuFoto() {
//        return usuFoto;
//    }
//
//    public void setUsuFoto(byte[] usuFoto) {
//        this.usuFoto = usuFoto;
//    }
	public String getUsuTipoUsuario() {
		return usuTipoUsuario;
	}

	public void setUsuTipoUsuario(String usuTipoUsuario) {
		this.usuTipoUsuario = usuTipoUsuario;
	}

	@XmlTransient
	public Collection<Factura> getFacturaCollection() {
		return facturaCollection;
	}

	public void setFacturaCollection(Collection<Factura> facturaCollection) {
		this.facturaCollection = facturaCollection;
	}

	@XmlTransient
	public Collection<CabeceraCompra> getCabeceraCompraCollection() {
		return cabeceraCompraCollection;
	}

	public void setCabeceraCompraCollection(Collection<CabeceraCompra> cabeceraCompraCollection) {
		this.cabeceraCompraCollection = cabeceraCompraCollection;
	}

	@XmlTransient
	public Collection<CierreCaja> getCierreCajaCollection() {
		return cierreCajaCollection;
	}

	public void setCierreCajaCollection(Collection<CierreCaja> cierreCajaCollection) {
		this.cierreCajaCollection = cierreCajaCollection;
	}

	public Collection<OrdenTrabajo> getOrdenTrabajoCollection() {
		return ordenTrabajoCollection;
	}

	public void setOrdenTrabajoCollection(Collection<OrdenTrabajo> ordenTrabajoCollection) {
		this.ordenTrabajoCollection = ordenTrabajoCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUsuario != null ? idUsuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.idUsuario == null && other.idUsuario != null)
				|| (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ec.deckxel.entidad.Usuario[ idUsuario=" + idUsuario + " ]";
	}

	public Character getUsuFoto() {
		return usuFoto;
	}

	public void setUsuFoto(Character usuFoto) {
		this.usuFoto = usuFoto;
	}

	public String getUsuWhatsapp() {
		return usuWhatsapp;
	}

	public void setUsuWhatsapp(String usuWhatsapp) {
		this.usuWhatsapp = usuWhatsapp;
	}

	public String getUsuPagina() {
		return usuPagina;
	}

	public void setUsuPagina(String usuPagina) {
		this.usuPagina = usuPagina;
	}

	public String getUsuFacebook() {
		return usuFacebook;
	}

	public void setUsuFacebook(String usuFacebook) {
		this.usuFacebook = usuFacebook;
	}

	public Integer getUsuNumeroFotos() {
		return usuNumeroFotos;
	}

	public void setUsuNumeroFotos(Integer usuNumeroFotos) {
		this.usuNumeroFotos = usuNumeroFotos;
	}

	public String getUsuFotografia() {
		return usuFotografia;
	}

	public void setUsuFotografia(String usuFotografia) {
		this.usuFotografia = usuFotografia;
	}

	public String getUsuActividad() {
		return usuActividad;
	}

	public void setUsuActividad(String usuActividad) {
		this.usuActividad = usuActividad;
	}

	public String getUsuServlet() {
		return usuServlet;
	}

	public void setUsuServlet(String usuServlet) {
		this.usuServlet = usuServlet;
	}

	public Boolean getUsuActivaMovil() {
		return usuActivaMovil;
	}

	public void setUsuActivaMovil(Boolean usuActivaMovil) {
		this.usuActivaMovil = usuActivaMovil;
	}

	public Date getUsuFechaRegMov() {
		return usuFechaRegMov;
	}

	public void setUsuFechaRegMov(Date usuFechaRegMov) {
		this.usuFechaRegMov = usuFechaRegMov;
	}

	public Date getUsuFechaCaduca() {
		return usuFechaCaduca;
	}

	public void setUsuFechaCaduca(Date usuFechaCaduca) {
		this.usuFechaCaduca = usuFechaCaduca;
	}

	public String getUsuDescripcionNegocio() {
		return usuDescripcionNegocio;
	}

	public void setUsuDescripcionNegocio(String usuDescripcionNegocio) {
		this.usuDescripcionNegocio = usuDescripcionNegocio;
	}

	public String getUsuLongNegocio() {
		return usuLongNegocio;
	}

	public void setUsuLongNegocio(String usuLongNegocio) {
		this.usuLongNegocio = usuLongNegocio;
	}

	public String getUsuLatNegocio() {
		return usuLatNegocio;
	}

	public void setUsuLatNegocio(String usuLatNegocio) {
		this.usuLatNegocio = usuLatNegocio;
	}

	public Boolean getUsuEsDrive() {
		return usuEsDrive;
	}

	public void setUsuEsDrive(Boolean usuEsDrive) {
		this.usuEsDrive = usuEsDrive;
	}

	public Boolean getUsuDriveActivo() {
		return usuDriveActivo;
	}

	public void setUsuDriveActivo(Boolean usuDriveActivo) {
		this.usuDriveActivo = usuDriveActivo;
	}

	public String getUsuDrivePlaca() {
		return usuDrivePlaca;
	}

	public void setUsuDrivePlaca(String usuDrivePlaca) {
		this.usuDrivePlaca = usuDrivePlaca;
	}

	public String getUsuDriveColor() {
		return usuDriveColor;
	}

	public void setUsuDriveColor(String usuDriveColor) {
		this.usuDriveColor = usuDriveColor;
	}

	public Boolean getUsuDriveDisponible() {
		return usuDriveDisponible;
	}

	public void setUsuDriveDisponible(Boolean usuDriveDisponible) {
		this.usuDriveDisponible = usuDriveDisponible;
	}

	public Parroquia getIdParroquia() {
		return idParroquia;
	}

	public void setIdParroquia(Parroquia idParroquia) {
		this.idParroquia = idParroquia;
	}

	public String getUsuRuc() {
		return usuRuc;
	}

	public void setUsuRuc(String usuRuc) {
		this.usuRuc = usuRuc;
	}

	public Boolean getUsuIlimitado() {
		return usuIlimitado == null ? Boolean.FALSE : usuIlimitado;
	}

	public void setUsuIlimitado(Boolean usuIlimitado) {
		this.usuIlimitado = usuIlimitado;
	}

	public Integer getUsuNumDocumentos() {
		return usuNumDocumentos == null ? 0 : usuNumDocumentos;
	}

	public void setUsuNumDocumentos(Integer usuNumDocumentos) {
		this.usuNumDocumentos = usuNumDocumentos;
	}

	public Integer getUsuTotalContratado() {
		return usuTotalContratado == null ? 0 : usuTotalContratado;
	}

	public void setUsuTotalContratado(Integer usuTotalContratado) {
		this.usuTotalContratado = usuTotalContratado;
	}

	public Date getUsuFechaRegistro() {
		return usuFechaRegistro;
	}

	public void setUsuFechaRegistro(Date usuFechaRegistro) {
		this.usuFechaRegistro = usuFechaRegistro;
	}

	public Date getUsuFechaPago() {
		return usuFechaPago;
	}

	public void setUsuFechaPago(Date usuFechaPago) {
		this.usuFechaPago = usuFechaPago;
	}

	public Collection<Tipoambiente> getTipoambienteCollection() {
		return tipoambienteCollection;
	}

	public void setTipoambienteCollection(Collection<Tipoambiente> tipoambienteCollection) {
		this.tipoambienteCollection = tipoambienteCollection;
	}

	public String getAccionRest() {
		return accionRest;
	}

	public void setAccionRest(String accionRest) {
		this.accionRest = accionRest;
	}

	public Integer getCodTipoAmbiente() {
		return codTipoAmbiente;
	}

	public void setCodTipoAmbiente(Integer codTipoAmbiente) {
		this.codTipoAmbiente = codTipoAmbiente;
	}

	public Tipoambiente getTipoambiente() {
		return tipoambiente;
	}

	public void setTipoambiente(Tipoambiente tipoambiente) {
		this.tipoambiente = tipoambiente;
	}

	public String getUsuDireccion() {
		return usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
	}

	public Collection<Postulaciones> getPostulacionesCollection() {
		return postulacionesCollection;
	}

	public void setPostulacionesCollection(Collection<Postulaciones> postulacionesCollection) {
		this.postulacionesCollection = postulacionesCollection;
	}
	

}
