#!/bin/bash

if [ ! -f "kjv.zip" ]; then
  curl https://codified.com/kjv.zip -o kjv.zip
  unzip -o kjv.zip
fi

#Comment out the above lines then uncomment the below lines if you're running a mac to recreate the database from the baseline kjv+.dzip file
#Note: You will need to have e-Sword installed on your mac prior to running this.

#unzip -o "/Applications/e-Sword X.app/Contents/Resources/kjv+.dzip" -d .
#echo "Renaming kjv+.bbli to kjv+matches.bbli"
#mv kjv+.bbli kjv+matches.bbli
