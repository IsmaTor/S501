package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.controllers;

import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.services.IFlorServicesDAO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Swagger = http://localhost:9001/swagger-ui/index.html#/
@Controller
@RequestMapping("/flor")
public class FlorController {

	@Autowired //injectar dependències
	private IFlorServicesDAO florServices;

	@Operation(summary = "Mostra totes les  flors")
	@GetMapping(path= "/getAll") //http://localhost:9001/flor/getAll
	public ResponseEntity<?> getAll() {
        try {
            List<FlorDTO> flors = florServices.getAll();
				for (FlorDTO florsE : flors) {
					String tipus = florsE.tipusPais(florsE.getPaisFlor());
					florsE.setTipusFlor(tipus);
				}
			return new ResponseEntity<>(flors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Flor no trobada" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	@Operation(summary = "Crea una flor")
	@PostMapping(path= "/add") //http://localhost:9001/flor/add
	public ResponseEntity<?> addFlor(@RequestBody FlorDTO florDTO){
		try {
			String paisFlor = florDTO.tipusPais(florDTO.getPaisFlor());
			florDTO.setTipusFlor(paisFlor);
			florServices.add(florDTO);
			return new ResponseEntity<>(florDTO, HttpStatus.CREATED);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Operation(summary = "Mostra la flor per id")
	@GetMapping(path= "/getOne/{id}") //http://localhost:9001/flor/getOne/?
	public ResponseEntity<?> getOneFlor(@PathVariable int id){
		try {
			FlorDTO florDTO = florServices.getOne(id);
			String tipus = florDTO.tipusPais(florDTO.getPaisFlor());
			florDTO.setTipusFlor(tipus);

			return new ResponseEntity<>(florDTO, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>("Flor no trobada.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Operation(summary = "Modifca la flor per id")
	@PutMapping(path= "/update/{id}") //http://localhost:9001/flor/update/?
	public ResponseEntity<FlorDTO> updateFlor(@PathVariable("id") Integer id, @RequestBody FlorDTO florDTO){
		try {
			FlorDTO flors = florServices.update(id, florDTO);
			String tipus = flors.tipusPais(florDTO.getPaisFlor());
			flors.setTipusFlor(tipus);
			return new ResponseEntity<>(flors, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@Operation(summary = "Elimina la flor per id")
	@DeleteMapping(path= "/eliminar/{id}") //http://localhost:9001/flor/eliminar/?
	public ResponseEntity<String> deleteFlor(@PathVariable("id") int id) {
		try {
			florServices.delete(id);
			return new ResponseEntity<>("Flor eliminada correctament.", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Flor no trobada",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
