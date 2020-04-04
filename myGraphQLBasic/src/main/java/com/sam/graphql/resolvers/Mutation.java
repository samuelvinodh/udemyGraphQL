package com.sam.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sam.graphql.models.Orientation;
import com.sam.graphql.models.SuperCharacter;
import com.sam.graphql.models.SuperGroup;
import com.sam.graphql.repos.SuperCharacterRepo;
import com.sam.graphql.repos.SuperGroupRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private SuperCharacterRepo superCharacterRepo;

    @Autowired
    private SuperGroupRepo superGroupRepo;

    public SuperCharacter addCharacter(String name, Integer age, String groupName){
        SuperCharacter superCharacter = this.superCharacterRepo.addSuperCharacter(name,age,groupName);
        return superCharacter;
    }

    public SuperGroup addGroup(String name, Orientation orientation){
        SuperGroup superGroup = this.superGroupRepo.addGroup(name,orientation);
        return superGroup;
    }
}
