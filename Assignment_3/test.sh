#!/usr/bin/env bash
cd out/classes
for dir in Q*; do
	if [ -f ${dir}/Test.class ]; then
        echo "RUNNING TEST FOR ${dir}"
        java ${dir}/Test
        echo $'\n'
    fi
done