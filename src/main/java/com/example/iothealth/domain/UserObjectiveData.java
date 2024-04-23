package com.example.iothealth.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserObjectiveData {
    private String objectiveName;
    private Integer numberOfUsers;

    public UserObjectiveData(String objectiveName, Integer numberOfUsers) {
        this.objectiveName = objectiveName;
        this.numberOfUsers = numberOfUsers;
    }
}
