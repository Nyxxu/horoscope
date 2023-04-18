*** Settings ***
Documentation       Suite de test pour la partie Horoscope.
...
...                 Keywords are imported from the resource file

Resource            horoscope.resource
Library             RequestsLibrary
Library             Collections


*** Test Cases ***
Tester l'horoscope Belier pour le 2 mars 2023
    [tags]  test

    ${resp}=     Récuperer l'horoscope "BELIER" pour le jour "2023-03-02"

    Status Should Be    OK    ${resp}
    ${body}    Set Variable    ${resp.json()}
    Should Be Equal As Strings    ${body}[signe]    BELIER
    Should Be Equal As Strings    ${body}[date]    2023-03-02
    Should Be Equal As Strings    ${body}[texte]    Vous pourriez recevoir une nouvelle opportunité professionnelle cette semaine.


Tester l'horoscope LION pour le 14 juillet 2023
    ${expected}    Create Dictionary    signe=LION    date=2023-07-14
    Set To Dictionary
    ...    ${expected}
    ...    texte
    ...    Votre approche confiante et audacieuse de la vie vous permet de prendre des risques calculés et de relever des défis stimulants.

    ${resp}    Récuperer l'horoscope "LION" pour le jour "2023-07-14"

    Dictionaries Should Be Equal    ${expected}    ${resp.json()}


Tester l'horoscope Taureau du jour
    [tags]  test
    ${resp}=     Récuperer l'horoscope du jour "TAUREAU"
    
    Vérifier l'égalité    ${resp.json()}[signe]    TAUREAU
    Vérifier l'égalité    ${resp.json()}[date]     2023-04-13
    Vérifier l'égalité    ${resp.json()}[texte]    
    ...    	Vous êtes sur le point de réaliser un rêve que vous avez depuis longtemps - continuez à travailler dur et à croire en vous-même.


#Faire la démo pour l'appel pour récupérer le signe
