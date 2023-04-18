*** Settings ***
Documentation     This is a resource file, that can contain variables and keywords.
...               Keywords defined here can be used where this Keywords.resource in loaded.
Library  RequestsLibrary

*** Keywords ***
Récuperer l'horoscope "${signe}" pour le jour "${jour}"
    [Documentation]    Appel de l'api avec le signe et le jour voulu

    ${url}=    Set Variable    http://localhost:8081/${signe}
    
    # On ajoute la date si elle est renseigné
    ${url}=    Set Variable If    "${jour}" != "${EMPTY}"    ${url}/${jour}    ${url}

    ${resp}=     GET    ${url}   expected_status=anything
    Log    Body reçu ${resp.json()}

    [return]    ${resp}


Récuperer l'horoscope du jour "${signe}"
    [Documentation]    Appel de l'api avec le signe pour aujourd'hui
    ${resp}=    Récuperer l'horoscope "${signe}" pour le jour ""
    [return]    ${resp}



Vérifier l'égalité
    [Documentation]    On réécrit l'égalité en français
    [Arguments]    ${arg1}    ${arg2}

    Should Be Equal As Strings     ${arg1}    ${arg2}