package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO implements Serializable {
	
	/**
	 * número de versió de la classe per serialitzar
	 */
	private static final long serialVersionUID = 1L;
	
	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	
	private List<String> paisos = new ArrayList<>(Arrays.asList("Espanya", "Italia", "França", "Alemania", "Països Baixos"));
	
	//getters
	public int getPk_SucursalID() {
		return pk_SucursalID;
	}
	
	public String getNomSucursal() {
		return nomSucursal;
	}
	
	public String getPaisSucursal() {
		return paisSucursal;
	}
	
	public String getTipusSucursal() {
		return tipusSucursal;
	}
	
	//setters
	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	
	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	} 
	
	//mètodes
	public String tipusPais(String string) {
		String pais = null;
		boolean paisTrobat = false;
		int i = 0;

		while (i < paisos.size() ) { //busca el pais
			if (paisos.get(i).equalsIgnoreCase(string)) {   //si troba el pais torna true y asigna U.E a la variable pais
				paisTrobat = true;							//si no troba el pais torna false y asigna un String buit a pais
			} 
			i++;
		} 
		if(paisTrobat) {
			pais = "U.E.";
		} else {
			pais = " ";
		}
		return pais;
	}

}
