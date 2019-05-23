#!/usr/bin/env bash

set -euo pipefail

FILE=/Users/fpmoles/Downloads/creds.zip
if [[ -f "$FILE" ]]; then
    mv ~/Downloads/creds.zip ~/Desktop/accelerate/creds.zip
fi

mkdir -p ~/Desktop/accelerate/creds
unzip -o ~/Desktop/accelerate/creds.zip -d ~/Desktop/accelerate/creds
cp ~/Desktop/accelerate/creds.zip ~/code/starwars-character-service/src/main/resources
cd ~/Desktop/accelerate/creds
cqlsh --cqlshrc=./cqlshrc -u {{username}} -p {{password}} -f /Users/fpmoles/code/demo-utilities/starwars/c_schema.cql
cqlsh --cqlshrc=./cqlshrc -u {{username}} -p {{password}} -f /Users/fpmoles/code/demo-utilities/starwars/c_data.cql
