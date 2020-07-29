package io.seddin.deca.api.controller;

import io.seddin.deca.api.model.Team;
import io.seddin.deca.api.model.resident.Resident;

import io.seddin.deca.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/altaEquipo")
    public String saveTeam(@RequestBody Team team){
        teamRepository.save(team);
        return "Equipo "+ team.getId()+" creado";
    }

    @GetMapping("/equipos")
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/equipos/{id}")
    public Optional<Team> getTeams(@PathVariable String id) {
        return teamRepository.findById(id);
    }
    @DeleteMapping("/borrarEquipo/{id}")
    public String  deleteTeam(@PathVariable String id){
        teamRepository.deleteById(id);
        return "Equipo con el id "+id+" borrado";
    }
   /* @PutMapping("/actualizarEquipo/{id}")
    public String  updateResident(@PathVariable String id,@RequestBody Team teamNew){
        if (teamRepository.existsById(id)) {
            Team teamOld=teamRepository.findById(id).get();
            teamOld.setName(residentNew.getName());
            residentOld.setBirthday(residentNew.getBirthday());
            residentRepository.save(residentOld);
            return "residente con el id " + id + " actualizado";
        }else{
            return "usuario con el id " + id + " no existe";
        }
    }*/


}
