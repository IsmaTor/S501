package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.services;

import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServicesImp implements IFlorServicesDAO {

	@Autowired()
	private FlorRepository florRepository;

	@Override
	public void add(FlorDTO florDTO) {
		FlorEntity novaFlor = new FlorEntity();

		novaFlor.setNomFlor(florDTO.getNomFlor());
		novaFlor.setPaisFlor(florDTO.getPaisFlor());
		
		florRepository.save(novaFlor);
	}

	@Override
	public FlorDTO getOne (int id){
		Optional<FlorEntity> flor = florRepository.findById(id);

		FlorDTO florDTO = convertEntityToDTO(flor.get());

		return florDTO;
	}

	@Override
	public FlorDTO update(int id, FlorDTO florDTO) {

		FlorEntity florEntity = florRepository.findById(id).orElseThrow();
		florEntity.setNomFlor(florDTO.getNomFlor());
		florEntity.setPaisFlor(florDTO.getPaisFlor());

		FlorEntity florActualitzada = florRepository.save(florEntity);
		return convertEntityToDTO(florActualitzada);
	}

	@Override
	public void delete(int id) {
		this.florRepository.deleteById(id);
	}

	@Override
	public List<FlorDTO> getAll() {

		return florRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}
	
	//Entity a DTO
    public FlorDTO convertEntityToDTO(FlorEntity flor){
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNomFlor(flor.getNomFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        florDTO.setTipusFlor(florDTO.getTipusFlor()); 
        
        return florDTO;
    }

}
