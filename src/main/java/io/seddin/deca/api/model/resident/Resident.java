package io.seddin.deca.api.model.resident;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter



@Document(collection ="Residente")
public class Resident {

    @Id
    private String id;
    private Name name;
    private Address address;
    private String gender;//enum
    private String birthday; //fecha
    private String occupation;
    private Citizenship citizenship;

    @Override
    public String toString(){
        return id+"   "+name.toString();
    }

}
