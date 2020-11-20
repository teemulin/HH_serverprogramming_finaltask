package fi.teemuli.Assetlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	Employee findByEmail(String email);
	List<Employee> findByPhone(@Param("phone") String phone);
}