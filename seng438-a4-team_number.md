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
**Analysis:** This mutation replaced the line `this.upper - this.lower` with `this.upper / this.lower`. This mutation was killed in our original test suite in the test case `testGetLengthZero` where it checked if the range of 24,24 did in fact return a length of 0. This mutation was killed by this test case, as by replacing the double subtraction with a division, the length would instead give a value of 24/24 = 1, which is not the expected value of 0, thus, failing the test case successfully.
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
![image](https://user-images.githubusercontent.com/28770261/226054770-116f6a11-5ad6-4043-8fce-5cd109dc2ed1.png)
### Updated Mutation Score
![image](https://user-images.githubusercontent.com/28770261/226055290-ad39e1c8-5eb8-4139-a633-a4027263f6ea.png)
### Additional Test Cases Generated
#### `decimalConstrain()`
This test creates a range between 0.0 and 1.0, and then calls `constrain(double value)` with `value` being 0.5. The expected output of this test is 0.5, since it is within the range. This test targets mutants that increment or decrement the value of `value`. For example, a mutant that increments 0.5 will result in `value` being 1.5. Since this is outside the range, the result will default to the upper bound 1, which is not the expected output. Prior to creating this test case, mutants survived because previous test cases did not account for a scenario in which `value` is a decimal value within a range where the difference between the upper and lower bound is no greater than 1.
#### `lowerBoundConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 0.0. The expected output of this test is 0.0, since it is within the range and is actually the lower bound of the range. This test case was able to kill mutants because the lower bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `upperBoundConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 5.0. The expected output of this test is 5.0, since it is within the range and is actually the upper bound of the range. This test case was able to kill mutants because the upper bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `negativeLowerOutOfBoundsConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being -2.0. The expected output of this test is 0.0, since `value` is less than the lower bound and thus defaults to the value of the lower bound.This test case was able to kill mutants because the below lower bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `positiveUpperOutOfBoundsConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being 6.0. The expected output of this test is 5.0, since `value` is greater than the upper bound and thus defaults to the value of the upper bound. This test case was able to kill mutants because the above upper bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `infiniteUpperBoundsRangeConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being positive infinity. The expected output of this test is 5.0, since `value` is greater than the upper bound and thus defaults to the value of the upper bound. This test case was able to kill mutants because the well above upper bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `negativeInfiniteUpperBoundsRangeConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being negative infinity. The expected output of this test is 0.0, since `value` is less than the lower bound and thus defaults to the value of the lower bound. This test case was able to kill mutants because the well below lower bound of the Range was not being checked beforehand, which also increased the mutation score.
#### `NaNConstrain()`
This test creates a range between 0.0 and 5.0, and then calls `constrain(double value)` with `value` being not a number(NaN). The expected output of this test is NaN, since the argument that was passed in is not a number. This test case was able to kill mutants because the NaN value compared to the bounds of the Range was not being checked beforehand, which also increased the mutation score.
#### `testGetContainsNumberNotExistsLower()`
This test was created to check the below lower bound condition of the `contains(double value)` method in the Range class. With a value of 19 and a range of 20 to 24, the expected output is obviously false. Some mutants were also called by this test case as the below lower bound of the Range was not covered by the previous tests, therefore increasing the mutation score.
#### `testCombineRangeBothNull()`
This test was created to check the both ranges as null for the `combines(Range r1, Range r2)` method in the Range class. With two null ranges, the expected output is a null combine output. Some mutants were also called by this test case as the both ranges as null of the Range was not covered by the previous tests, therefore increasing the mutation score.
#### `testCombineUpperBoundNull()`
This test was created to check the only the second range as null for the `combines(Range r1, Range r2)` method in the Range class. With second null range, the expected output is the r1 range. Some mutants were also called by this test case as the only the second range as null of the Range was not covered by the previous tests, therefore increasing the mutation score.
#### `testCombineLowerBoundNull()`
This test was created to check the only the first range as null for the `combines(Range r1, Range r2)` method in the Range class. With first null range, the expected output is the r2 range. Some mutants were also called by this test case as the only the second range as null of the Range was not covered by the previous tests, therefore increasing the mutation score.
#### `testCombineRangeValid()`
This test was created to check the both ranges as valid for the `combines(Range r1, Range r2)` method in the Range class. With two valid ranges, the expected output is the r1.lowerBound to r2.upperBound range. Some mutants were also called by this test case as the both ranges were positive and valid as part of the Range which was not covered by the previous tests, therefore increasing the mutation score.
#### `testGetLowerBoundNaN()`
This test was created to check the second range lower bound NaN value effect for the `combines(Range r1, Range r2)` method in the Range class. With the NaN lower bound, the expected output is the for the lower bound to be NaN. Some mutants were also called by this test case as the lowerBound is NaN regardless of the other lowerBound of the Range which was not covered by the previous tests, therefore increasing the mutation score.
#### `testGetLowerBoundEpsilon()`
This test was created to check the second range upper bound NaN value effect for the `combines(Range r1, Range r2)` method in the Range class. With the NaN upper bound, the expected output is the for the lower bound to be the lower bound of the smaller lowerBound range. Some mutants were also called by this test case as the lowerBound is lower bound of first range despite the NaN of upperBound of the Range which was not covered by the previous tests, therefore increasing the mutation score.
#### `testGetUpperBoundNaN()`
This test was created to check the second range upper bound NaN value effect for the `combines(Range r1, Range r2)` method in the Range class. With the NaN upper bound, the expected output is the for the upper bound to be NaN. Some mutants were also called by this test case as the upperBound is NaN regardless of the lowerBounds or upperBound of the other range of the Range which was not covered by the previous tests, therefore increasing the mutation score.

## `DataUtilities.java`
### Original Mutation Score
![image](https://user-images.githubusercontent.com/28770261/226055128-e6e1870f-2c82-4ceb-b541-a860aa06be78.png)
### Updated Mutation Score
![image](https://user-images.githubusercontent.com/28770261/226054934-d01acad6-6413-4421-97d5-2005faaf9ffc.png)
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

Then, we considered the step-by-step process by which each functionality could be used. For example, in the case of Search, it required clicking on the search bar, typing in the query, and clicking on the search button. Once we determined the intended process, we considered cases of additional or erroneous user input. Using the same example of Search, this included a test case in which the search query was a random sequence of characters, which represents an invalid input. Finally, all the constructed cases were recorded using Selenium IDE and then appended with assert statements to ensure that the ouput was as intended. 

# Explain the use of assertions and checkpoints

Assertions and checkpoints are utilised to ensure that the UI functionality is working as intended and has not been diverted during its execution. They both do so by checking the current value of a target against its expected value defined by the tester. The difference lies in the action that each takes if the result of the comparison is a mismatch. An assertion will stop the execution entirely and display an error message. Conversely, a checkpoint will allow the execution to continue, although it will also display an error message. Ultimately, where and how the two are used is up to the tester. However, in the majority of cases, checkpoints should be used throughout the program flow, while asserts should typically be saved for the final check or critical points in the execution flow. In our case, we did not think adding checkpoints were necessary, as our tests were short and simple enough that a single assert statement would be adequate to verify the results.

# How did you test each functionality with different test data

We were able to test functionalities like Filter and Add to Cart with different test data by using variables. Using the `store text` function in Selenium IDE, we assigned the value of a target to a variable, which would then be compared in an assert statement. For instance, when testing the Add to Cart functionality, we stored the name of the item being added as a variable. Then, when viewing the cart, we checked to see whether the name of the item in the cart matches the variable. This way, we are able to test adding any items to the cart, without having to manually change the expected values.  
  
For some functionalities, like Search, it was not possible to automate the validation using a variable. This is because there was no way to expect what the output of the search would be until after it was completed. In these cases, we had little choice but to manually update the expected values each time the input data changed.

# Discuss advantages and disadvantages of Selenium vs. Sikulix
Selenium is relatively straightforward to understand and use in a web development context, since it identifies elements using HTML and CSS selectors. In this way, it is likely more intuitive than Sikulix. With tools like Selenium IDE, it is also possible to create and run tests with very little programming involved, saving valuable time for developers. However, Selenium does have constraints in terms of its versatility. For instance, it cannot easily detect attributes like placeholder text in an input field. Moreover, for some functions, components have to be identified via their id attribute, which is not always possible depending on how the page was developed. Sikulix has the advantage in this capacity, since it primarily uses image recognition to detect UI components. This means it can potentially capture a much wider variety of targets than Selenium. However, this comes at the expense of accuracy, as the image recognition system may not always correctly identify a target, unlike how a CSS selector would. 

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
