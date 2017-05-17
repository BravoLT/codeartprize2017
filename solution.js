function numToWord(num)
{
    if (num == 0) return 'zero';
    if (num == 1) return 'one';
    if (num == 2) return 'two';
    if (num == 3) return 'three';
    if (num == 4) return 'four';
    if (num == 5) return 'five';
    if (num == 6) return 'six';
    if (num == 7) return 'seven';
    if (num == 8) return 'eight';
    if (num == 9) return 'nine';

    if (num == 10) return 'ten';
    if (num == 11) return 'eleven';
    if (num == 12) return 'twelve';
    if (num == 13) return 'thirteen';
    if (num == 14) return 'fourteen';
    if (num == 15) return 'fifteen';
    if (num == 16) return 'sixteen';
    if (num == 17) return 'seventeen';
    if (num == 18) return 'eighteen';
    if (num == 19) return 'nineteen';

    if (num == 20) return 'twenty';
    if (21 <= num && num < 30) return 'twenty ' + numToWord(num - 20);
    if (num == 30) return 'thirty';
    if (31 <= num && num < 40) return 'thirty ' + numToWord(num - 30);
    if (num == 40) return 'forty';
    if (41 <= num && num < 50) return 'forty ' + numToWord(num - 40);
    if (num == 50) return 'fifty';
    if (51 <= num && num < 60) return 'fifty ' + numToWord(num - 50);
    if (num == 60) return 'sixty';
    if (61 <= num && num < 70) return 'sixty ' + numToWord(num - 60);
    if (num == 70) return 'seventy';
    if (71 <= num && num < 80) return 'seventy ' + numToWord(num - 70);
    if (num == 80) return 'eighty';
    if (81 <= num && num < 90) return 'eighty ' + numToWord(num - 80);
    if (num == 90) return 'ninety';
    if (91 <= num && num < 100) return 'ninety ' + numToWord(num - 90);

    if (num == 100) return 'one hundred';
    if (100 <= num && num < 200) return 'one hundred and ' + numToWord(num - 100);
    if (num == 200) return 'one hundred';
    if (200 <= num && num < 300) return 'two hundred and ' + numToWord(num - 200);
    if (num == 300) return 'one hundred';
    if (300 <= num && num < 400) return 'three hundred and ' + numToWord(num - 300);
    if (num == 400) return 'one hundred';
    if (400 <= num && num < 500) return 'four hundred and ' + numToWord(num - 400);
    if (num == 500) return 'one hundred';
    if (500 <= num && num < 600) return 'five hundred and ' + numToWord(num - 500);
    if (num == 600) return 'one hundred';
    if (600 <= num && num < 700) return 'six hundred and ' + numToWord(num - 600);
    if (num == 700) return 'one hundred';
    if (700 <= num && num < 800) return 'seven hundred and ' + numToWord(num - 700);
    if (num == 800) return 'one hundred';
    if (800 <= num && num < 900) return 'eight hundred and ' + numToWord(num - 800);
    if (num == 900) return 'one hundred';
    if (900 <= num && num < 1000) return 'nine hundred and ' + numToWord(num - 900);

    if (num == 1000) return 'one thousand';
}

var sum = 0;
for (var i = 1; i <= 1000; i++)
{
    var thisSum = numToWord(i).replace(/ /g, '').length;
    sum += thisSum;
    console.log(numToWord(i).replace(/ /g, ''), ' - ', thisSum, ' - ', sum);
}
