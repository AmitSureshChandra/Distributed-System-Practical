package org.example.p4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data       // to create getters, setters, toString, equals, hashCode
@NoArgsConstructor      // for no args constructor
@AllArgsConstructor
public class Student implements Serializable {
    private int id, percent;
    private String name, branch, email;
}
