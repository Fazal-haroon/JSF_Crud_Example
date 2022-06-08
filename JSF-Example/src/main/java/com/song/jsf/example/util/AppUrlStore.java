package com.song.jsf.example.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class AppUrlStore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String baseUrl = null;
	private String simpleCrudUrl = null;
	private String freshSafeCrudUrl = null;

	public String getBaseUrl() {return baseUrl; }
	public String getSimpleCrudUrl() { return simpleCrudUrl; }
	public String getFreshSafeCrudUrl() {return freshSafeCrudUrl; }

	@PostConstruct
    public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String baseUrl = externalContext.getInitParameter("BaseUrl");

		this.baseUrl = baseUrl;
		this.simpleCrudUrl = baseUrl + "simplecrud.xhtml";
		this.freshSafeCrudUrl = baseUrl + "freshsafecrud.xhtml";
    }
}
