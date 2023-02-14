package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data //mètodes getters i setters
@NoArgsConstructor //Constructor buit
@AllArgsConstructor
public class FlorDTO implements Serializable {
	
	/**
	 * número de versió de la classe per serialitzar
	 */
	private static final long serialVersionUID = 1L;
	
	private int pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
	
	private List<String> paisos = new ArrayList<>(Arrays.asList("Espanya", "Italia", "França", "Alemania", "Països Baixos"));
	
	//mètodes
	public String tipusPais(String string) {
		String pais = null;
		boolean paisTrobat = false;
		int i = 0;

		while (i < paisos.size()) {
			if (paisos.get(i).equalsIgnoreCase(string)) {
				paisTrobat = true;
			} 
			i++;
		} 
		if(paisTrobat) {
			pais = "U.E.";
		} else {
			pais = "Fora de la U.E.";
		}
		return pais;
	}

}

