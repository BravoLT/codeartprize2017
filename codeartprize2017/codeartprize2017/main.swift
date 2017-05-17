//
//  main.swift
//  codeartprize2017
//
//  Created by Juan Gonzalo Carcamo on 5/17/17.
//  Copyright © 2017 jcarcamo. All rights reserved.
//

import Foundation

func getArrayOfNumber(number: Int) -> [Int] {
    return  String(number).characters.flatMap{Int(String($0))}
}

func getWrittenNumbersLenght(number:Int) -> Int {
    var units : Int
    switch(number){
    case 0:
        units = 0
    case 1...2:
        units = 3
    case 3:
        units = 5
    case 4...5:
        units = 4
    case 6:
        units = 3
    case 7...8:
        units = 5
    case 9:
        units = 4
    case 10:
        units = 3
    case 11...12:
        units = 6
    case 13...14:
        units = 8
    case 15...16:
        units = 7
    case 17:
        units = 9
    case 18...19:
        units = 8
    case 20:
        units = 6
    case 30:
        units = 6
    case 40:
        units = 5
    case 50:
        units = 5
    case 60:
        units = 5
    case 70:
        units = 7
    case 80:
        units = 6
    case 90:
        units = 6
    case 100:
        units = 7
    case 1000:
        units = 8
    default:
        units = -1
    }
    return units
}

var sum: Int = 0
for currentNumber in 1...1000{
    var currentNumberArray = getArrayOfNumber(number: currentNumber)
    
    if currentNumberArray.count == 2 && currentNumberArray.first! >= 2 {
        var tens =  currentNumberArray.first!*10
        var units = currentNumberArray.last!
        
        sum += getWrittenNumbersLenght(number: tens)
        sum += getWrittenNumbersLenght(number: units)
    }else if  currentNumberArray.count == 3 && currentNumberArray[currentNumberArray.count-2] >= 2 {
        var hundreds = currentNumberArray.first!
        var tens =  currentNumberArray[currentNumberArray.count-2]*10
        var units = currentNumberArray.last!
        
        sum += getWrittenNumbersLenght(number: hundreds)
        sum += getWrittenNumbersLenght(number: 100)
        sum += getWrittenNumbersLenght(number: tens)
        sum += getWrittenNumbersLenght(number: units)
    } else if  currentNumberArray.count == 4{
        var thousands = currentNumberArray.first!
        var hundreds = currentNumberArray[2]*100
        var tens =  currentNumberArray[currentNumberArray.count-2]*10
        var units = currentNumberArray.last!
        sum += getWrittenNumbersLenght(number: thousands)
        sum += getWrittenNumbersLenght(number: 1000)
        
    } else {
        sum += getWrittenNumbersLenght(number: currentNumber)
    }
}

print ("Result is \(sum)")









