#!/bin/bash

clear 

sepstr="--------------------------------------------------------------------------------"
echo "$sepstr"

echo "Arithmetic expansion is done with >>\$(( ...))<<"
echo "   or >>\$[ ... ] (marked as the preferred form by >>http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_03_04.html<<.)"
echo "  The expression within is treated =as if= it were within double quotes, but a double quote inside the parens is not treated specially."

echo "$sepstr"
echo "Let:"
echo "a=1"
echo "b=5"
echo "c=20"

a=1
b=5
c=20

echo "$sepstr"
echo "Then: "
echo ">>echo \"\$a\"<< gives"
echo "  $a"
echo ">>echo \"\${a}\"<< gives"
echo "  ${a}"
echo ">>echo \"\$(( a ))\"<< gives"
echo "  $(( a ))"
echo ">>echo \"\$[ a ]\"<< gives"
echo "  $[ a ]"

echo "$sepstr"
echo "Further: "
echo ">>echo \"\${a} + \${b}\"<< gives"
echo "  ${a} + ${b}"
echo "but >>echo \"\$[a+b]\"<< gives"
echo "  $[a+b]"

