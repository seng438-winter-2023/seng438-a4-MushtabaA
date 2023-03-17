**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |  24  |
| -------------- | --- |
| Student Names: |  Ahad Ali   |
|                |  Mushtaba Al Yasseen   |
|                |  Parbir Lehal   |
|                |  Athul Rajagopal   |

# Introduction

The objective of this lab is to explore mutation testing and web user interface (UI) testing in a controlled environment. To perform mutation testing, we used PITest, which automates the process and generates several mutations, which are in turn reported as either surviving or killed. After analyzing the results, we created additional test cases to kill mutants which were previously surviving, thereby improving the mutation score. Web UI testing was carried out using Selenium IDE, which is a browser extension that can record and replay actions on a webpage. Selenium was used to test and confirm that the webpage functionalities were working as intended.

# Analysis of 10 Mutants of the Range class 

#### 1. **`contains(double value)`**
    Mutation: 48. contains : Incremented (++a) double field lower → KILLED
**Analysis:** This mutation replaced the line `return (value >= this.lower && value <= this.upper);` with `return (value >= (++this.lower) && value <= this.upper);` This mutation was killed in our original test suite as it was covered by test suite `testGetContainsPositiveNumberExistsLowerBound` where the test case checked if the lower bound, `20` is in the range of 20-24. This mutation was killed as incrementing the (++a) double field lower should fail in this case which it does with the test case mentioned above as it would change the range from 20-24 to 21-24 so 20 would not be part of the range due to the mutation. 
#### 2. **`contains(double value)`**
    Mutation: 53. contains : Decremented (--a) double fieldupper → KILLED
**Analysis:** This mutation replaced the line `return (value >= this.lower && value <= this.upper);` with `return (value >= this.lower && value <= (--this.upper));` This mutation was killed in our original test suite as it was covered by test suite `testGetContainsPositiveNumberExistsUpperBound` where the test case checked if the lower bound, `42` is in the range of 42-224. This mutation was killed as decrementing the (--a) double field upper should fail in this case which it does with the test case mentioned above as it would change range from 42-224 to 42-223 so 224 would not be part of the range due to the mutation.
#### 3. **`getLength()`**
    Mutation: 6. getLength : replaced double return with 0.0d for org/jfree/data/Range::getLength → KILLED
**Analysis:** This mutation replaced the line `return this.upper - this.lower;` with `return 0.0d;` This mutation was killed in our original test suite as it was covered by test suite `testGetLengthBothBoundsPositive` where the test case found the range between 0 and 24, which is 24. This mutation was killed as the above-mentioned test case expects a length that is not 0, therefore, the mutation is killed or the test case fails as expected.
#### 4. **`getLength()`**
    Mutation: Line 123, 14. getLength: Replaced double subtraction with division → KILLED
**Analysis:** This mutation replaced the line “this.upper - this.lower” with “this.upper / this.lower”. This mutation was killed in our original test suite in the test case “testGetLengthZero” where it checked if the range of 24,24 did in fact return a length of 0. This mutation was killed by this test case, as by replacing the double subtraction with a division, the length would instead give a value of 24/24 = 1, which is not the expected value of 0, thus, failing the test case successfully.
#### 5. **`constrain(double value)`**
    Mutation: Line 188, 1. constrain: Incremented (a++) double local variable number 1 → SURVIVED
**Analysis:** This mutation post increments the parameter `value`, which is passed into the constrain method. This mutation survived because in the test case `outOfRangeConstrain`, if the value is an intenger, then the result will be the upper bound of range. For example, given a range of (0, 4), when input is incremented from 5 to 6, the result will still be the upper bound value in range, and thus this mutation still survives in our original test suite. For these cases, this can be considered an equivalent mutation. However, for cases where constrain is called on a decimal value inside a small range (e.g. `constrain(0.5)` inside a range (0, 1)), the returned value should become 1, rather than 0.5.
#### 6. **`getUpperBound()`**
    Mutation: 6. Incremented (++a) double field upper → KILLED
**Analysis:** This mutation replaced the line `return this.upper;` with `return (++this.upper);` This mutation was killed in our original test suite as it was covered by the test suite `upperBoundEqualRange()` where the test case found the upper bound in the range of 1-1. This mutation was killed as incrementing the (++a) double field upper should fail in this case which it does with the test case mentioned above. It would change the range from 1-1 to 1-2 so the upper bound changed meaning the test case caught the mutation and killed it.
#### 7. **`getUpperBound()`**
    Mutation: 1. Incremented (a++) double field upper → SURVIVED
**Analysis:** This mutation replaced the line `return this.upper;` with `return (this.upper++);` This mutation survived in our original test suite as it cannot be covered by the test suite `upperBoundEqualRange()` where the test case found the upper bound in the range 1-1. This mutation survived by incrementing the (a++) double field upper passes in this case which it does with the test case mentioned above. It won’t change the range when returning it but will change it after, thus the mutation persists and the test case is not able to catch it.
#### 8. **`constrain(double value)`**
    Mutation: 1. Negated double local variable number 1 → KILLED
**Analysis:** This mutation replaced the `value` variable with `-value`. This mutation was killed because in our original test suite it was covered by the test suite `outOfRangeConstrain`, where the test case found the constrain value in the range 1-1. This mutation was killed as negating the value variable should fail in this case which it does with the test case as mentioned above. It changed the value variable from ‘5’ to ‘-5’ and therefore the constrain returns the lower bound instead of the upper bound and the test case catches this, thus killing the mutation. 
#### 9. **`intersects()`**
    Mutation: Line 157, 9. Greater than to greater or equal → SURVIVED
**Analysis:** This mutation changes the greater-than operator (`>`) to a greater-than-or-equal-to operator (`>=`) in the condition `b1 > this.lower`. This mutation may have survived because changing the operator from `>` to `>=` can potentially increase the number of test cases that pass. If there are test cases that pass with the original code and also pass with the mutated code, then the mutation may be considered equivalent. This is because the >= operator includes the case where b1 is equal to this.lower, which was previously excluded by the > operator.
#### 10. **`intersects()`**
    Mutation: Line 157, 12. Incremented (a++) double local variable number 1 → SURVIVED
**Analysis:** This mutation increments the value of `double b0` prior to checking whether it is less than or equal to the value of `this.lower`. The mutant survived the test cases because changing the value of b0 does not affect the overall behaviour of the method. If the condition fails, the method simply continues to the else-block, where another condition is evaluated. As a result, this can be considered an equivalent mutation, and thus no test cases would be able to catch this mutation.

# Report all the statistics and the mutation score for each test class

## `Range.java`
### Original Mutation Score
Add image here
### Updated Mutation Score
Add image here
### Additional Test Cases Generated
#### `decimalConstrain()`
This test creates a range between 0.0 and 1.0, and then calls `constrain(double value)` with `value` being 0.5. The expected output of this test is 0.5, since it is within the range. This test targets mutants that increment or decrement the value of `value`. For example, a mutant that increments 0.5 will result in `value` being 1.5. Since this is outside the range, the result will default to the upper bound 1, which is not the expected output. Prior to creating this test case, mutants survived because previous test cases did not account for a scenario in which `value` is a decimal value within a range where the difference between the upper and lower bound is no greater than 1.
#### `lowerBoundConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 0.0. The expected output of this test is 0.0, since it is within the range and is actually the lower bound of the range.
#### `upperBoundConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 5.0. The expected output of this test is 5.0, since it is within the range and is actually the upper bound of the range.
#### `negativeLowerOutOfBoundsConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being -2.0. The expected output of this test is 0.0, since `value` is less than the lower bound and thus defaults to the value of the lower bound.
#### `positiveUpperOutOfBoundsConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 6.0. The expected output of this test is 5.0, since `value` is greater than the upper bound and thus defaults to the value of the upper bound.
#### `infiniteUpperBoundsRangeConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being positive infinity. The expected output of this test is 5.0, since `value` is greater than the upper bound and thus defaults to the value of the upper bound.
#### `negativeInfiniteUpperBoundsRangeConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being negative infinity. The expected output of this test is 0.0, since `value` is less than the lower bound and thus defaults to the value of the lower bound.
#### `NaNConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being not a number(NaN). The expected output of this test is NaN, since the argument that was passed in is not a number.

## `DataUtilities.java`
### Original Mutation Score
Add image here
### Updated Mutation Score
Add image here
### Additional Test Cases Generated

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENIUM test case design process

First and foremost, we explored the webpage and made note of what functionalities it offered. This provided us with an understanding of which core UI components we felt needed to be tested. The functionalities we ultimately decided to test were:
-  Login
-  Register
-  Add to Cart
-  Remove from Cart
-  Sign Out
-  Add to List
-  Search
-  Filter

Then, we considered the step-by-step process by which each functionality could be used. For example, in the case of Search, it required clicking on the search bar, typing in the query, and clicking on the search button. Once we determined the intended process, we considered cases of additional or erroneous user input. Finally, all the considered cases were recorded using Selenium IDE, and then appended with assert statements to ensure that the ouput was as intended. 

# Explain the use of assertions and checkpoints

# how did you test each functionality with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
