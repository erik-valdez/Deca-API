package io.seddin.deca.api.model.resident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import io.seddin.deca.api.model.Team;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@ToString


public class Citizenship {
    private String join;//fecha
    private String status;// enum
    //@DBRef
    private String team;

   /* 1.test add residente sin ciudadania
    2 test update the same residente con ciudadania
    4- odify all paraeters of the same residente and update it
    3. delete la ciudadania de un residente
    */
}
