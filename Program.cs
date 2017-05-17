using System;
using System.Linq;

namespace Euler17
{
    class Program
    {
        static string[] lessThanTwentyNames = new[]
         {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        static string[] tensNames = new[] { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        static void Main()
        {
            var result = Enumerable.Range(1, 1000)
                .Select(Wordify)
                .Sum(words => words.Count(char.IsLetter));

            Console.WriteLine(result);

            string Wordify(int number)
            {
                if (number == 1000)
                {
                    return "one thousand";
                }
                else if (number >= 100)
                {
                    var hundreds = $"{lessThanTwentyNames[(number / 100) - 1]} hundred";
                    var remainder = number % 100;
                    return remainder == 0 ? hundreds : $"{hundreds} and {Wordify(remainder)}";
                }
                else if (number >= 20)
                {
                    var tens = tensNames[(number / 10) - 2];
                    var remainder = number % 10;
                    return remainder == 0 ? tens : $"{tens}-{Wordify(remainder)}";
                }
                else
                {
                    return lessThanTwentyNames[number - 1];
                }
            }
        }
    }
}
