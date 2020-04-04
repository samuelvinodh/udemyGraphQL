package com.sam.graphql.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Builder
@Data
public class SuperGroup {
    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;

    public void addMember(SuperCharacter character){
        if(members==null){
            members = new ArrayList<>();
        }
        if(character != null){
            members.add(character);
        }
    }

    public void removeMember(SuperCharacter character){
        this.members = this.members.stream()
                .filter(c -> !c.getName().equalsIgnoreCase(character.getName()))
                .collect(Collectors.toList());
    }
}
