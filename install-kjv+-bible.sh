#!/bin/bash

unzip -o "/Applications/e-Sword X.app/Contents/Resources/kjv+.dzip" -d .
echo "Renaming kjv+.bbli to kjv+matches.bbli"
mv kjv+.bbli kjv+matches.bbli