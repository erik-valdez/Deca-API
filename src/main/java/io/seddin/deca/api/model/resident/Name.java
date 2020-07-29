package io.seddin.deca.api.model.resident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter


public class Name {
    private String names;
    private String firstLastName;
    private String secondLastName;

    public String toString(){
        return names+" "+firstLastName+" "+secondLastName;
    }
}
