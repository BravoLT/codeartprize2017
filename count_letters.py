# Print the sum of the letters in the English form of the integers from 1 to 1000.
# This code is based on code from
# https://github.com/w-hat/ctci-solutions/blob/master/ch-16-moderate/08-english-int.py

SINGLE_DIGIT = {0: 'zero', 1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five',
                6: 'six', 7: 'seven', 8: 'eight', 9: 'nine'}
TEENS = {10: 'ten', 11: 'eleven', 12: 'twelve', 13: 'thirteen', 14: 'fourteen',
         15: 'fifteen', 16: 'sixteen', 17: 'seventeen', 18: 'eighteen',
         19: 'nineteen'}
TENS = {20: 'twenty', 30: 'thirty', 40: 'forty', 50: 'fifty', 60: 'sixty',
        70: 'seventy', 80: 'eighty', 90: 'ninety'}
LARGE_NUMBERS = ['thousand', 'million', 'billion', 'trillion', 'quadrillion']

def count_letters(n):
  sum = 0
  for i in range(1, n + 1):
    string = english_int(i).replace(" ", "")
    sum += len(string)
  return sum

def english_int(n):
  if n == 0:
    return "zero"
  parts = []
  hundreds = n % 1000
  if hundreds != 0:
    parts.append(english_int_hundreds(hundreds))
  added_and = False
  magnitude_index = 0
  n = int(n / 1000)
  while n:
    if len(parts) > 0 and not added_and:
      parts.append("and")
      added_and = True
    hundreds = int(n % 1000)
    if hundreds:
      parts.append(LARGE_NUMBERS[magnitude_index])
      parts.append(english_int_hundreds(hundreds))
    magnitude_index += 1
    n = int(n / 1000)
  return " ".join(reversed(parts))
  
def english_int_hundreds(n):
  if n == 0:
    return ""
  parts = []
  tens_ones = int(n % 100)
  if tens_ones < 10:
    if tens_ones > 0:
      parts.append(SINGLE_DIGIT[tens_ones])
  elif tens_ones < 20:
    parts.append(TEENS[tens_ones])
  else:
    ones = tens_ones % 10
    tens = tens_ones - ones
    if ones > 0:
      parts.append(SINGLE_DIGIT[ones])
    parts.append(TENS[tens])
  hundreds = int(n / 100)
  if hundreds:
    if len(parts) > 0:
      parts.append("and")
    parts.append("hundred")
    parts.append(SINGLE_DIGIT[hundreds])
  return " ".join(reversed(parts))

if __name__ == "__main__":
  total_count = count_letters(1000)
  print(total_count)
