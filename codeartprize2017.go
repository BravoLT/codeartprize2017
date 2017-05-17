package main

import (
	"fmt"
	"github.com/pemcconnell/num2words"
	"github.com/urfave/cli"
	"os"
	"strings"
)

//   'Beauty in art is often nothing but ugliness subdued.'
//       --Jean Rostand

func main() {

	// Using cli package to subdue ugliness of creating a cli application
	app := cli.NewApp()
	app.Name = "codeartprize2017"
	app.Version = "0.9.0"
	app.Usage = "Compute the sum of the number letter counts per https://projecteuler.net/problem=17"

	var rangemin, rangemax int
	app.Flags = []cli.Flag{
		cli.IntFlag{Name: "min", Value: 1, Usage: "Minimum range value", Destination: &rangemin},
		cli.IntFlag{Name: "max", Value: 1000, Usage: "Maximum range value", Destination: &rangemax},
	}

	app.Action = func(c *cli.Context) error {
		if rangemin > rangemax {
			return cli.NewExitError("min cannot be greater than max", 1)
		}
		sum := numberLetterSum(rangemin, rangemax)
		fmt.Println(sum)
		return nil
	}

	app.Run(os.Args)

}

func numberLetterSum(min int, max int) int {
	sum := 0
	for i := min; i <= max; i++ {
		// Leveraging num2words to subdue the ugliness of turning numbers to words
		sum += len(stripChars(num2words.Convert(i), " -"))
	}
	return sum
}

// Using http://rosettacode.org/wiki/Strip_a_set_of_characters_from_a_string#Go to subdue ugliness of processing
// non-alphanumeric characters
func stripChars(str, chr string) string {
	return strings.Map(func(r rune) rune {
		if strings.IndexRune(chr, r) < 0 {
			return r
		}
		return -1
	}, str)
}
