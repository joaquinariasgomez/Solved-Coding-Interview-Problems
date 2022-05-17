#!/bin/bash
read line
printf "%.3f\n" $(bc -l <<< $line)