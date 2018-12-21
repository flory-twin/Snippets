#!/bin/bash
# Display all of the named built-in variables.

clear

echo "(\$BASH) The path to the BASH binary is >>$BASH<<."
echo "(\$BASH_ENV) The BASH startup script is >>$BASH_ENV<<."
echo "(\$BASH_SUBSHELL) The current subshell level is >>$BASH_SUBSHELL<<."
echo "(\$BASHPID) The process ID of the current shell is >>$BASHPID<<."
echo "(\$BASH_VERSINFO[x]) The BASH version information array is:"
	for n in 0 1 2 3 4 5
		do
			case $n in 
				0)
					member="major version no."
					;;
				1)
					member="minor version no."
					;;
				2)
					member="patch level"
					;;
				3)
					member="build version"
					;;
				4)
					member="release status"
					;;
				5)
					member="architecture"
					;;
			esac
			echo "	BASH_VERSINFO[$n] (${member}) = ${BASH_VERSINFO[$n]}"
		done
echo "(\$BASH_VERSION) The BASH version"
echo "(\$CDPATH)"
echo "(\$DIRSTACK)"
echo "(\$EDITOR)"
echo "(\$EUID) The effective user ID is >>$EUID<<."
echo "(\$FUNCNAME) The name of the current function is >>$FUNCNAME<<."
echo "(\$GLOBIGNORE) The list (array) of filename patterns to be excluded from globbing (wildcard name match) is >>$GLOBIGNORE<<."
echo "(\$GROUPS) The list (array) of groups to which the current user belongs is >>$GROUPS<<."
echo "(\$HOME)"
echo "(\$HOSTNAME)"
echo "(\$HOSTTYPE) The architecture of the system hardware is >>$HOSTTYPE<<."
echo "(\$IFS) The internal field separator (the word boundary separator) is >>$IFS<<."
echo "(\$IGNOREEOF) The number of Ctrl-Ds (EOF characters) the shell will ignore before logging out is >>$IGNOREEOF<< (???)"
echo "(\$LC_COLLATE)"
echo "(\$LC_CTYPE)"
echo "(\$LINENO)"
echo "(\$MACHTYPE) Same as \$HOSTTYPE."
echo "(\$OLDPWD) The prior working directory was >>$OLDPWD<<."
echo "(\$PATH)"
echo "(\$PIPESTATUS) The list of the exit status(es) of the last executed -foreground- pipe(s) are given by \$PIPESTATUS: >>$PIPESTATUS<<."
echo "(\$PPID) The process ID of this process's parent is >>$PPID<<."
echo "(\$PROMPT_COMMAND) The command to be executed just before the primary prompt is to be displayed is >>$PROMPT_COMMAND<<."
echo "(\$PS1) The main prompt."
echo "(\$PS2) The secondary prompt (seen when additional input is expected.)"
echo "(\$PS3) The prompt shown within a select loop."
echo "(\$PS4)"
echo "(\$PWD) The working directory."
echo "(\$REPLY)"
echo "(\$SECONDS) The length of the time this script has been running, in seconds."
echo "(\$SHELLOPTS (readonly)) The list (array) of enabled shell options"
echo "(\$SHLVL) The shell level (stating which PSn is current, NOT which subshell level is current.)"
echo "(\$TMOUT) The timeout, if any, to use for the current prompt."
echo "(\$UID)"
