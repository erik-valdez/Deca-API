package io.seddin.deca.api.repository;

import io.seddin.deca.api.model.resident.Name;
import io.seddin.deca.api.model.resident.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends MongoRepository<Resident,String> {
    public Resident findByName(Name name);
   // public Resident findByIdObj(String id);

}
