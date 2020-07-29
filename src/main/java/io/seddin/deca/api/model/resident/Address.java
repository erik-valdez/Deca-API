package io.seddin.deca.api.model.resident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Address {
    private String street;//enum
    private int number;
    private String zone;//enum


}
