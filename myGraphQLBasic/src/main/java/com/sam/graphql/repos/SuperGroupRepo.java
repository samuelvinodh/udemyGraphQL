package com.sam.graphql.repos;

import com.sam.graphql.models.Orientation;
import com.sam.graphql.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SuperGroupRepo {
    private List<SuperGroup> superGroups = new ArrayList<>();

    public SuperGroupRepo() {
        seedGroups();
    }

    public void seedGroups(){
        SuperGroup g1 = SuperGroup.builder()
                .name("Bad Dudes")
                .orientation(Orientation.VILLAIN)
                .build();
        this.superGroups.add(g1);
    }

    public List<SuperGroup> superGroups(){
        return this.superGroups;
    }

    public SuperGroup superGroupByName(String name){
        List<SuperGroup> matchGroup = this.superGroups.stream()
                .filter(g -> g.getName().equals(name))
                .collect(Collectors.toList());
        if(matchGroup.size()>0){
            return matchGroup.get(0);
        } else {
            return null;
        }
    }

    public SuperGroup addGroup(String name, Orientation orientation){
        SuperGroup newGroup = SuperGroup.builder()
                .name(name)
                .orientation(orientation)
                .build();
        this.superGroups.add(newGroup);
        return newGroup;
    }
}
