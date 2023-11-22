#!/bin/bash

set -e
set -u

# Lance l'application UseSpeedUp qui mesure le temps pour 2 façons différentes de calculer le problème "Dice"
java -cp .:./*:./ext/* -DnbFace=6 -DnbExperience=2000000 ch.hearc.tools.UseSpeedUp

echo ""