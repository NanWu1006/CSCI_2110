#!/usr/bin/env bash
for dir in *; do
	if [[ (-d $dir) && ($dir != "out") ]]; then
		cd ${dir}
		echo "${dir}"
		ant test
		echo -e "\n\n"
		cd ..
	fi
done
