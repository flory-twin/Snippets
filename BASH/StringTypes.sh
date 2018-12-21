#!/bin/bash
# Displays the string rules.

clear

echo "Setting variables with these commands: "
echo "  str=BAR"
echo "  str0=BASHPID"
echo "  str1=\$BASHPID"
echo "  str2='\$BASHPID'"
echo "  str3=\"\$BASHPID\""
echo ""

set str=BAR
set str0=BASHPID
set str1=$BASHPID
set str2='$BASHPID'
set str3="\$BASHPID"

echo "	\$ causes expansion.  When braces are added, they delimit the token to be expanded; end braces escaped with backslash, present in a quoted string, or within an arithmetic expansion/command substitution/parameter expansion are ignored for expansion purposes."
echo "  So if we >>set str}0=FOO<<, >>echo \"\${str\}0}\"<< will give"
set $str}0=FOO
echo "${str\}0}"
echo "When the echo command is used without any quotes around the 'argument', no interpretation whatsoever is performed."
echo "  So >>echo $str0<< will give "
echo $str0
echo ""

echo "'...' strings will not be expanded."
echo "  So >>echo '\$str0'<< will give "
echo '  $str0'
echo "  >>echo '\$str1'<< will give "
echo '  $str1'
echo "  So >>echo '\$str1'<< will give "
echo '  $str1'

echo "	Arithmetic expansion is done with \${{...}}."
echo "  The expression within is treated =as if= it were within double quotes, but a double quote inside the parens is not treated specially."

