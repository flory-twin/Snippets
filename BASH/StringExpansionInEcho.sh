#!/bin/bash
# Displays the string expansion rules.

clear

sepstr="--------------------------------------------------------------------------------"
echo "$sepstr"

echo "Setting variables with these commands: "
echo "  str=BAR"
echo "  str0=BASHPID"
echo "  str1=\$BASHPID"
echo "  str2='\$BASHPID'"
echo "  str3=\"\$BASHPID\""
echo ""

str=BAR
str0=BASHPID
str1=$BASHPID
str2='$BASHPID'
str3="\$BASHPID"

echo "$sepstr"
echo "When the echo command is used without any quotes around the 'argument', no interpretation whatsoever is performed."
echo "  So >>echo $str0<< will give "
echo $str0

echo "$sepstr"
echo "'...' strings will not be expanded."
echo "  So >>echo '\$str0'<< will give "
echo '  $str0'
echo "  >>echo '\$str1'<< will give "
echo '  $str1'
echo "$sepstr"
echo "\$ causes expansion within implicit or double-quoted strings."
echo "So >>echo str<< will result in:"
echo     str
echo ">>echo \$str<< will result in:"
echo     $str
echo ">>echo '\$str'<< will result in:"
echo '$str'
echo "and >>echo \"\$str\"<< will result in"
echo "$str"

echo "$sepstr"
echo "When braces are added, they delimit the token to be expanded."
echo "  So >>echo \"\${str}\"<< will result in"
echo "    ${str}"
echo "  >>echo \"\${str}0\"<< will result in"
echo "    ${str}0"

echo "$sepstr"
echo "End braces escaped with backslash, present in a quoted string, or within an arithmetic expansion/command substitution/parameter expansion are ignored for expansion purposes."


