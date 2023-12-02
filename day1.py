# --- Day 1: Trebuchet?! ---

# Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.

# You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.

# Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

# You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

# As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.

# The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

# For example:

# 1abc2
# pqr3stu8vwx
# a1b2c3d4e5f
# treb7uchet
# In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

# Consider your entire calibration document. What is the sum of all of the calibration values?

# To begin, get your puzzle input.

print(list(range(len("line") - 1, -1, -1)))

def findCalibrationNumber(line):
    nums = []
    for char in line:
        # https://www.w3schools.com/python/ref_string_isnumeric.asp#:~:text=The%20isnumeric()%20method%20returns,%2C%20and%20the%20%2D%20and%20the%20.
        if char.isnumeric():
            # https://www.freecodecamp.org/news/python-convert-string-to-int-how-to-cast-a-string-in-python/#:~:text=To%20convert%2C%20or%20cast%2C%20a,int(%22str%22)%20.
            nums.append(int(char))
            break

    # https://www.w3schools.com/python/python_for_loops.asp
    for i in range(len(line) - 1, -1, -1):
        # print("i=", i)
        char = line[i]
        if char.isnumeric():
            nums.append(int(char))
            break

    return nums

# https://www.geeksforgeeks.org/read-a-file-line-by-line-in-python/
file = open('inputs/day1.txt', 'r')

lines = file.readlines()
print("rows in file:", len(lines))

result = 0
for line in lines:
    print(" line is:", line)
    nums = findCalibrationNumber(line)
    print(" number in line {} is {}".format(line, nums))
    result += nums[0]*10 + nums[1]

print("The sum of all of the calibration values is:", result)

file.close

# Your puzzle answer was 54877.

# The first half of this puzzle is complete! It provides one gold star: *

# --- Part Two ---

# Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

# Equipped with this new information, you now need to find the real first and last digit on each line. For example:

# two1nine
# eightwothree
# abcone2threexyz
# xtwone3four
# 4nineeightseven2
# zoneight234
# 7pqrstsixteen
# In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

# What is the sum of all of the calibration values?

letterDigits = {'one':'1', 
                'two':'2', 
                'three':'3',
                'four':'4',
                'five':'5',
                'six':'6',
                'seven':'7',
                'eight':'8',
                'nine':'9'}

for k, v in letterDigits.items():
    print("k={}, v={}".format(k, v))


def replaceLetterDigitsWithNumber(line):
    new_line = line
    print("find first letter digit")
    firstIdx, firstLetter = len(line), None
    # https://www.w3schools.com/python/python_dictionaries_loop.asp
    for k, v in letterDigits.items():
        # print("k={}, v={}".format(k, v))
        idx = line.find(k)
        # print("idx:", idx)
        if idx < 0:
            continue
        elif idx < firstIdx:
            firstIdx = idx
            firstLetter = k
            print("firstIdx={}, firstLetter={}".format(firstIdx, firstLetter))
    
    lastIdx, lastletter = 0, None
    # https://www.w3schools.com/python/python_dictionaries_loop.asp
    for k, v in letterDigits.items():
        idx = line.rfind(k)
        if idx < 0:
            continue
        elif idx > lastIdx:
            lastIdx = idx
            lastletter = k
            print("lastIdx={}, lastLetter={}".format(lastIdx, lastletter))

    if firstLetter is not None:
        # https://www.geeksforgeeks.org/python-string-replace/
        new_line = new_line.replace(firstLetter, "{}{}".format(letterDigits[firstLetter], firstLetter))

    if lastletter is not None:
        # https://www.geeksforgeeks.org/python-string-replace/
        new_line = new_line.replace(lastletter, "{}{}".format(letterDigits[lastletter], lastletter))
    
    return new_line


file = open('inputs/day1.txt', 'r')

lines = file.readlines()
print("rows in file:", len(lines))

result = 0
for line in lines:
    print("--------------------")
    print(" line is:", line)
    new_line = replaceLetterDigitsWithNumber(line)
    print(" replace letter digits, new line=", new_line)
    nums = findCalibrationNumber(new_line)
    print(" number in new_line is {}".format(nums))
    result += nums[0]*10 + nums[1]


print("The sum of all of the calibration values is:", result)

file.close

# The sum of all of the calibration values is: 54100
# That's the right answer! You are one gold star closer to restoring snow operations.