#!/bin/bash
read x
read y
if [ "$x" -gt "$y" ]; then
    echo "X is greater than Y"
else
    if [ "$x" -lt "$y" ]; then
        echo "X is less than Y"
    else
        echo "X is equal to Y"
    fi
fi