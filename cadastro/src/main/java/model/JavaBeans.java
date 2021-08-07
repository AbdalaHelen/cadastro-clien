package model;

public class JavaBeans {
	private String idcli;
	private String razaoSocial;
	private String cnpj;
	private String regime;
	private String email;

	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcli, String razaoSocial, String cnpj, String regime, String email) {
		super();
		this.idcli = idcli;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.regime = regime;
		this.email = email;
	}

	public String getIdcli() {
		return idcli;
	}
	public void setIdcli(String idcli) {
		this.idcli = idcli;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
