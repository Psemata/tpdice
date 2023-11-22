#!/bin/bash

set -e
set -u

# Lance l'application UseSpeedUp qui mesure le temps pour 2 façons différentes de calculer le problème "Dice"
java -cp .:./*:./ext/* ch.hearc.dice.gui.UseJDice

echo ""