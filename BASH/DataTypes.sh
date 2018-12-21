#!/bin/bash

clear 

sepstr="--------------------------------------------------------------------------------"
echo "$sepstr"

echo "Let:"
echo "a=1"
echo "b=5ti"
echo "c=20"

a=1
b=5
c=20

echo "$sepstr"
echo "BASH regards =EVERYTHING= as a character string.  However, certain operations become available based on that string's content."
echo "  If the string matches [+-]{0,1}[1-9]{0,*}, then it can be treated as an integer."
echo "  So >>echo \"\$[a + 1]\"<< can be performed meaningfully, and evaulates to"
echo "    $[a + 1]"
echo "$sepstr"

echo "  However, arithmetic operations on strings also work; the integer value of a string is defined as 0 (except when dividing).  So \$[a + b] evaluates to"
echo "    $[a + b]"
echo "  This is also true for the empty string!"
echo "    When >>d=\"\"<<, then \$[a + d] evaulates to"
d=""
echo "      $[a + d]"
echo "  ...and for the null value:"
echo "    When >>e=<<, then \$[a + e] evaluates to"
e=
echo "      $[a + e]"
echo "  It's even true for 'undeclared variables', which use the 'let' syntax, like >>let \"f += 1\"<<:"
let "f += 1"
echo "    then \$[a + f] evaulates to"
echo "      $[a + f]"
echo "    However, this does NOT work for the case where we divide by an undeclared variable.  It will throw a syntax error rather than a divide-by-zero error."

echo "$sepstr"
echo "Divide by string is a special case.  When dividing by a string, it will not throw a divide-by-zero."
echo "  For example, \$[a / b] gives"
echo "    $[a / b]"
echo "  However, beware that \$[a / 0] gives an error:"
echo "    $[a / 0]"

echo "$sepstr"
echo "Note that floating-point values are not available; such require the use of tools such as 'bc'."
echo "  For example, >>g=-1.1<< throws a syntax error, and \$[a / c] gives"
echo "    $[a / c]"

