package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //mètodes getters i setters
@NoArgsConstructor //Constructor buit
@AllArgsConstructor //Constructor amb arguments
@Entity //indica que la classe es una classe Java Persistent JPA
@Table(name = "sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //estrategia per la Primary Key. AUTO: per a autoincrement
	private int pk_SucursalID;
	
	@Column(name = "nom")
	private String nomSucursal;
	
	@Column(name = "pais")
	private String paisSucursal;


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
	
	
	

}
