*** Settings ***
Documentation     This is a resource file, that can contain variables and keywords.
...               Keywords defined here can be used where this Keywords.resource in loaded.
Library  RequestsLibrary
Library  Collections

*** Keywords ***
Noter l'application
    [Arguments]    ${valeur}=5
    [Documentation]    Envoi la valeur de la note dans le système de notation

    ${body}=    Create Dictionary    valeur=${valeur}

    POST    http://localhost:8081/note    json=${body}

Reset la moyenne 
    [Documentation]     Reset de la moyenne
    GET    http://localhost:8081/note/reset


Récuperer la moyenne
    
    ${resp}=    GET    http://localhost:8081/note
    
    Log    La moyenne est de : ${resp.text}
    [Return]    ${resp.text}