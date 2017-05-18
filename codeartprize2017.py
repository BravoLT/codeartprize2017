# Created by jcarcamo
#
# 05-17-2017

digitsToLetter = {0:"", 1:"one", 2:"two", 3:"three", 4:"four", 5:"five",6:"six", 7:"seven", 8:"eight", 9:"nine",10:"ten",11:"eleven",12:"twelve", 13:"thirteen", 14:"fourteen", 15:"fifteen", 16:"sixteen", 17:"seventeen", 18:"eighteen", 19:"nineteen",20:"twenty", 30:"thirty", 40:"forty",50:"fifty",60:"sixty",70:"seventy",80:"eighty",90:"ninety",100:"hundred",1000:"thousand"}

def countLettersOfNumber(num):
    numArray = []
    finished = False
    while not finished:
        digit = num%10
        numArray.append(digit)
        num /= 10
        if num == 0:
            finished = True

    result = []
    index = 1
    for number in numArray:
        if len(numArray) > 1:
            if numArray[1] > 1:
                if index == 1 or index == 10:
                    result.append(digitsToLetter [number*index])
            else:
                if index == 10:
                    result.append(digitsToLetter [number*10+numArray[0]])
            if index == 100 and number != 0:
                if numArray[0] != 0 or numArray[1] != 0:
                    result.append("and")
                result.append(digitsToLetter [100])
                result.append(digitsToLetter [number])
            elif index == 100 and number == 0:
                if numArray[0] != 0 or numArray[1] != 0:
                    result.append("and")
            elif index == 1000:
                result.append(digitsToLetter [1000])
                result.append(digitsToLetter [number])
        else:
            result.append(digitsToLetter [number])
        index *= 10
    numText = "".join([str for str in reversed(result)])
    #print numText
    return len(numText)

eulerChallenge = 0
for i in range(1,1001):
    eulerChallenge += countLettersOfNumber(i)

print "The result is", eulerChallenge
