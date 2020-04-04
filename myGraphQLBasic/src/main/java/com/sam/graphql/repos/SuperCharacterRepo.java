package com.sam.graphql.repos;

import com.sam.graphql.models.SuperCharacter;
import com.sam.graphql.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperCharacterRepo {

    @Autowired
    private SuperGroupRepo superGroupRepo;

    private List<SuperCharacter> superCharacterList = new ArrayList<>();

    public SuperCharacterRepo() {
        seedCharacters();
    }

    private void seedCharacters(){
        SuperCharacter c1 = SuperCharacter.builder()
                .id("Char1")
                .name("Super Character1")
                .age(33)
                .build();
        SuperCharacter c2 = SuperCharacter.builder()
                .id("C2")
                .name("Two is my name")
                .age(147)
                .build();
        this.superCharacterList.add(c1);
        this.superCharacterList.add(c2);
    }

    public List<SuperCharacter> getSuperCharacterList() {
        return this.superCharacterList;
    }

    public SuperCharacter getSuperCharacterById(String id) {
        List<SuperCharacter> matchedCharacters = this.superCharacterList.stream()
                .filter(c -> c.getId().equals(id))
                .collect(Collectors.toList());
        if(matchedCharacters.size() > 0){
            return matchedCharacters.get(0);
        } else {
            return null;
        }
    }

    public SuperCharacter addSuperCharacter(String name, Integer age, String groupName){
        SuperGroup superGroup = null;
        if(groupName != null && groupName.length()>0){
            superGroup = superGroupRepo.superGroupByName(groupName);
        }
        SuperCharacter newChar = SuperCharacter.builder()
                .name(name)
                .age(age)
                .id("Char"+this.superCharacterList.size()+1)
                .group(superGroup)
                .build();
        log.info(">Mutation.addCharacter ( "+name+ " )");
        this.superCharacterList.add(newChar);
        if(superGroup !=null){
            superGroup.addMember(newChar);
        }
        return newChar;
    }
}
