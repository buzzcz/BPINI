#!/bin/bash

for file in "$@"
do
	vlna -v KkSsVvZzOoUuAaIi -l -m -n -r "$file"
done
