package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s05.t01.n01.S05T01N01TortosadelaIglesiaIsmael.model.repository.SucursalRepository;

@Service
public class SucursalServiceImp implements ISucursalServicesDAO {

	@Autowired()
	private SucursalRepository sucursalRepository;

	@Override
	public void add(SucursalDTO sucursalDTO) {
		Sucursal novaSucursal = new Sucursal();
		
		novaSucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		novaSucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		
		sucursalRepository.save(novaSucursal);
	}
	
	@Override
	public Sucursal getOne(int id) {
		
        return sucursalRepository.findById(id).orElse(null);
    }
	
	@Override
	public void update(int id, SucursalDTO sucursalDTO) {

		Optional<Sucursal> SetSucursal = sucursalRepository.findById(id);

		SetSucursal.orElseThrow().setNomSucursal(sucursalDTO.getNomSucursal());
		SetSucursal.orElseThrow().setPaisSucursal(sucursalDTO.getPaisSucursal());

		sucursalRepository.save(SetSucursal.orElseThrow());
	}

	@Override
	public void delete(int id) {
		this.sucursalRepository.deleteById(id);
	}

	@Override
	public List<SucursalDTO> getAll() {
		
		return sucursalRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}
	
	//Entity a DTO
    public SucursalDTO convertEntityToDTO(Sucursal sucursal){
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipusSucursal(sucursalDTO.getTipusSucursal()); 
        return sucursalDTO;
    }

}
