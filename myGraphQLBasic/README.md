query{characters{name}}

mutation{addCharacter(name:"New One",age:28){id name age}}

query{characterById(id:"Char21"){name age}}

query {groups{name orientation}}

mutation{addGroup(name:"Nice Ones",orientation:HERO){name members{name}}}

query{groupByName(name:"Bad Dudes"){orientation}}

mutation{addCharacter(name:"Venom",age:30,groupName:"Bad Dudes"){id name age group {orientation}}}

#query{characters{id name age group{name orientation}}}

query{groups{name orientation members{name}}}

query{characterById(id:"Char21"){name age group{orientation members{name}}}}