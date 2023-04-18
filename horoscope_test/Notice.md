Installation

installé python

pip install robotframework
pip install robotframework-requests
pip install robotframework-jsonlibrary

Tous les tests :
robot --outputdir results .

Par fichier :
robot --outputdir results .\TestNotation.robot

Par test :
robot -t "Tester l'horoscope LION pour le 14 juillet 2023" --outputdir results . 