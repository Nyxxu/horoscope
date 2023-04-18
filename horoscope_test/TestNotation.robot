*** Settings ***
Documentation       Suite de test pour la partie Notation.
...
...               Keywords are imported from the resource file
Resource         notation.resource
Library  RequestsLibrary

Test Setup      Reset la moyenne
Test Teardown   Reset la moyenne


*** Test Cases ***

Envoyer trois notes puis récupérer la moyenne
    [tags]  notation

    Noter l'application
    Noter l'application    valeur=1
    Noter l'application    3

    ${valeur}=     Récuperer la moyenne

    Should Be Equal As Numbers    ${valeur}    3


Vérifier le reset de la moyenne
    [tags]    notation    test

    ${valeur}=     Récuperer la moyenne
    Should Be Equal As Numbers    ${valeur}    0

    Noter l'application    1
    ${valeur}=     Récuperer la moyenne
    Should Be Equal As Numbers    ${valeur}    1

    Reset la moyenne
    ${valeur}=     Récuperer la moyenne
    Should Be Equal As Numbers    ${valeur}    0



