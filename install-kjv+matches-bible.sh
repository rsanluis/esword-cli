#!/bin/bash

ESWORD_CLI_DIR=../esword-db
pushd .
if [ -d "$ESWORD_CLI_DIR" ];
then
  echo "$ESWORD_CLI_DIR directory exists."
  cd ..
else
  echo "$ESWORD_CLI_DIR directory does not exist."
  cd ..
  git clone https://github.com/rsanluis/esword-db.git
fi
cd esword-db
git pull
./build.sh
popd
cp ../esword-db/*.bbli .

#Fetch DB method #2
#if [ ! -f "kjv.zip" ]; then
#  curl https://codified.com/kjv.zip -o kjv.zip
#fi
#unzip -o kjv.zip

#Fetch DB method #3 - regenerate the DB from kjv+.bbli file
#Comment out the above lines then uncomment the below lines if you're running a mac to recreate the database from the baseline kjv+.dzip file
#Note: You will need to have e-Sword installed on your mac prior to running this.

#unzip -o "/Applications/e-Sword X.app/Contents/Resources/kjv+.dzip" -d .
#echo "Renaming kjv+.bbli to kjv+matches.bbli"
#mv kjv+.bbli kjv+matches.bbli
