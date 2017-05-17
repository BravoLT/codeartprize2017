package main

import (
	"flag"
	"fmt"
	"strings"

	"github.com/yieldbot/gocli"
)

var (
	cli         gocli.Cli
	usageFlag   bool
	versionFlag bool
)

func init() {
	const usageTxt = "Display usage"
	const versionTxt = "Display version information"

	flag.BoolVar(&usageFlag, "h", false, usageTxt)
	flag.BoolVar(&usageFlag, "help", false, usageTxt)
	flag.BoolVar(&versionFlag, "version", false, versionTxt)
	flag.BoolVar(&versionFlag, "v", false, versionTxt)
}

func main() {
	// Init cli
	cli = gocli.Cli{
		Name:        "NumTxtLenSum",
		Version:     "now in beta!",
		Description: "Calculates the length of all number words from min to max",
		Commands: map[string]string{
			"echo": "Print the given arguments",
		},
	}
	cli.Init()

	// Run commands
	if cli.SubCommand == "echo" {
		// Echo command
		fmt.Println(strings.Join(cli.SubCommandArgs, " "))
	} else if versionFlag {
		// Version
		cli.PrintVersion(true)
	} else {
		// Default
		cli.PrintUsage()
	}
}

func Run(min int, max int) {

	var NumberNames = map[int]string{
		1:    "one",
		2:    "two",
		3:    "three",
		4:    "four",
		5:    "five",
		6:    "six",
		7:    "seven",
		8:    "eight",
		9:    "nine",
		10:   "ten",
		11:   "eleven",
		12:   "twelve",
		13:   "thirteen",
		14:   "fourteen",
		15:   "fifteen",
		16:   "sixteen",
		17:   "seventeen",
		18:   "eighteen",
		19:   "nineteen",
		20:   "twenty",
		30:   "thirty",
		40:   "forty",
		50:   "fifty",
		60:   "sixty",
		70:   "seventy",
		80:   "eighty",
		90:   "ninety",
		100:  "hundred",
		1000: "thousand",
	}

	for i := min; i <= max; i++ {
		numberWordLength := 1
		// magic happens here...
		sum += numberWordLength
	}

	fmt.Println(sum)
}
