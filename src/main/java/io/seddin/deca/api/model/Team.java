package io.seddin.deca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString

@Document(collection ="Team")
public class Team {
    @Id
    private String id;
    //@DBRef
    private List<String> members;
    //private List<tasks>

}
