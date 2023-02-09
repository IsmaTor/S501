package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.domain;

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
@Table(name = "flors")
public class FlorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //estrategia per la Primary Key. AUTO: per a autoincrement
	private int pk_FlorID;
	
	@Column(name = "nom")
	private String nomFlor;
	
	@Column(name = "pais")
	private String paisFlor;
	
}

