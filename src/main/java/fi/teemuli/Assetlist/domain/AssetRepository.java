package fi.teemuli.Assetlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AssetRepository extends CrudRepository<Asset, Long> {
	
	List<Asset> findBySerial(@Param("serial") String serial);

}