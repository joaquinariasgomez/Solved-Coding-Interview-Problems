#!/bin/bash
awk '{
    total=$2+$3+$4
    avg=total/3
    if(avg >= 50)
        print $1,": Pass"
    else
        print $1,": Fail"
}'