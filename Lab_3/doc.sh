#!/usr/bin/env bash
for dir in Q*; do
	cd ${dir}
	echo "CREATING JAVADOC FOR $dir"
	rm -rf Doc/*
	javadoc ${dir}/* -d Doc > /dev/null
	cd ..
done