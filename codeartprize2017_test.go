package main

import (
	"testing"
)

func TestNumberLetterSum(t *testing.T) {
	cases := []struct {
		min  int
		max  int
		want int
	}{
		{1, 1, 3},
		{2, 2, 3},
		{0, 1, 7},
		{1, 5, 19},
		{342, 342, 23},
		{115, 115, 20},
		{1, 9, 36},
		{10, 19, 70},
		{20, 99, 748},
		{1, 1000, 21124},
	}
	for _, c := range cases {
		got := numberLetterSum(c.min, c.max)
		if got != c.want {
			t.Errorf("numberLetterSum(%d, %d) == %d, want %d", c.min, c.max, got, c.want)
		}
	}
}
