package com.sam.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sam.graphql.models.SuperCharacter;
import com.sam.graphql.models.SuperGroup;
import com.sam.graphql.repos.SuperCharacterRepo;
import com.sam.graphql.repos.SuperGroupRepo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver{

    @Autowired
    private SuperCharacterRepo superCharacterRepo;

    @Autowired
    private SuperGroupRepo superGroupRepo;

    /*public Query(SuperCharacterRepo superCharacterRepo, SuperGroupRepo superGroupRepo) {
        this.superCharacterRepo = superCharacterRepo;
        this.superGroupRepo = superGroupRepo;
    }*/

    public List<SuperCharacter> characters(){
        return superCharacterRepo.getSuperCharacterList();
    }

    public SuperCharacter characterById(String id){
        return superCharacterRepo.getSuperCharacterById(id);
    }

    public List<SuperGroup> groups(){
        return superGroupRepo.superGroups();
    }

    public SuperGroup groupByName(String name){
        return superGroupRepo.superGroupByName(name);
    }

}
