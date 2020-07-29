package io.seddin.deca.api.controller;

import io.seddin.deca.api.model.Team;
import io.seddin.deca.api.model.resident.Resident;
import io.seddin.deca.api.repository.ResidentRepository;
import io.seddin.deca.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
public class ResidentController {
    @Autowired
    private ResidentRepository residentRepository;
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/altaResidente")
    public String saveResident(@RequestBody Resident resident){
        List<String> li= new ArrayList<>();
        String idTeamTmp=resident.getCitizenship().getTeam();

        if(teamRepository.existsById(idTeamTmp)){
            residentRepository.save(resident);
            Team teamOld=teamRepository.findById(idTeamTmp).get();
            if(!isNull(teamOld.getMembers())){
                li=teamOld.getMembers();
                System.out.println("not null");
            }
            li.add(resident.toString());
            teamOld.setMembers(li);
            teamRepository.save(teamOld);

            return "residente creado:"+resident.getId();
        }else {
            return "no existe el quipo: "+idTeamTmp;
        }

    }

    @GetMapping("/residentes")
    public List<Resident> getResidents(){
        return residentRepository.findAll();
    }

    @GetMapping("/residentes/{id}")
    public Optional<Resident> getResident(@PathVariable String id) {
            return residentRepository.findById(id);
    }
    @DeleteMapping("/borrarResidente/{id}")
    public String  deleteResident(@PathVariable String id){
        residentRepository.deleteById(id);
        return "residente con el id "+id+" borrado";
    }
    @PutMapping("/actualizarResidente/{id}")
    public String  updateResident(@PathVariable String id,@RequestBody Resident residentNew){
        if (residentRepository.existsById(id)) {
            Resident residentOld=residentRepository.findById(id).get();
            residentOld.setName(residentNew.getName());
            residentOld.setBirthday(residentNew.getBirthday());
            residentRepository.save(residentOld);
            return "residente con el id " + id + " actualizado";
        }else{
            return "usuario con el id " + id + " no existe";
        }
    }


}
