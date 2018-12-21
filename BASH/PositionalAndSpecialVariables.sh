#!/bin/bash
# Display all of the positional built-in variables.

clear

echo "(\$0, \$1, ...) The positional parameters--arguments passed from the command line, to a function, or 'set to a parameter' (???)"
echo "(\$#) The number of positional parameters supplied."
echo "(\"\$*\") All positional parameters 'as a single word' (-must- be quoted.) Note that parameters are both interpreted and expanded. \n While this may be used as an array, like >>for arg in \"\$*\"<<, it is a one-member array."
echo "(\"\$@\") Like \"\$\"*, but each parameter is a quoted string (one word per parameter, no interpretation or expansion.) May be used as an array, like >>for arg in \"\$@\"..."
echo "(\$-): Unreliable way to get flags passed into script."
echo "(\$!): PID of last job run in the background."
echo "(\$_): Final argument of the prior command executed."
echo "(\$?): Exit status of the last-run command, function, or the script itself."
echo "(\$\$): PID of this script."
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
echo "(\$)"
