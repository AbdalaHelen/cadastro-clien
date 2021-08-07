/**
 * Validação de formulário
 */

function validar() {
	let razao = frmCliente.razaoSocial.value
	let cnpj = frmCliente.cnpj.value
	let regime = frmCliente.regime.value
	let email = frmCliente.email.value
	
	if (razao === ""){
		alert("Preencha o campo Razão Social")
		frmCliente.razaoSocial.focus()
		return false
	} else if (cnpj === ""){
		alert("Preencha o campo CNPJ")
		frmCliente.cnpj.focus()
		return false
	} else if (regime === ""){
		alert("Preencha o campo Regime Tributário")
		frmCliente.regime.focus()
		return false
	} else if (email === ""){
		alert("Preencha o campo Email")
		frmCliente.email.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
}