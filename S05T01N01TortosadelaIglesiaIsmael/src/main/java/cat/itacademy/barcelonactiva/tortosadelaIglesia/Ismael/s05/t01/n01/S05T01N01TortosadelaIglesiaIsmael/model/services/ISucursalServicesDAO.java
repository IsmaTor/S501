package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.dto.SucursalDTO;

@Service
public interface ISucursalServicesDAO {
	
	public void add(SucursalDTO sucursalDTO);
	
	public void update(int id, SucursalDTO sucursalDTO);
	
	public void delete(int id);
	
	public Sucursal getOne(int id);
	
	public List<SucursalDTO> getAll();
		
}


