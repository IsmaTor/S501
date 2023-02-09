package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.services;

import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.dto.FlorDTO;

import java.util.List;

public interface IFlorServicesDAO {
	
	public void add(FlorDTO florDTO);
	
	public FlorDTO update(int id, FlorDTO florDTO);
	
	public void delete(int id);
	
	public FlorDTO getOne(int id);
	
	public List<FlorDTO> getAll();

}
