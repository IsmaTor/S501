package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s05.t01.n02.S05T01N02TortosadelaIglesiaIsmael.model.domain.FlorEntity;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {


}
