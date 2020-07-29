package io.seddin.deca.api.repository;


import io.seddin.deca.api.model.Team;
import io.seddin.deca.api.model.resident.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team,String> {
}
