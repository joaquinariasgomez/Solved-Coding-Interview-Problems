#!/bin/bash
read nItems
sum=0
for i in $(seq 1 $nItems);
do
    read item
    sum=$(( $sum + $item ))
done

printf "%.3f\n" `echo "$sum / $nItems" | bc -l