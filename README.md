# TDD_MasterMindGame
Test Driven Development using Design Principles #1


Using Test First Development (no code without test first) let's implement the problem designed in hw2. Feel free to evolve that design 
and use judgment to make changes based on the improved understanding and learning. You are not required to use any of the design idea or
languages you mentioned in hw2, apply decisions based on your renewed learnings.

Please take small steps and ask for frequent reviews.

First start with a tests list (tests.txt) and a canary test. Implement at most two more tests and minimum code to make those tests to 
pass. This is a great first step to complete and ask for a review.

After completing the assignment (and only after) let's answer the following questions:

1. What did you learn mainly in this assignment? 

  This was the first time for us to write programs based on testing first, rather than the tactical design that we draw on paper. 
  We needed to UNLEARN the way we used to code and LEARN an entire new way of developing programs. For example, from reading the 
  requirements, we knew the MasterMind class must have compareGuess() method that takes a list of colors and return a list of feedback 
  including the black and silver color codes. We could be sitting there wondering what the format of the returning variable would be; 
  a List of objects or an array of integers? TDD made us implement that differently. We started to create the class with the one very
  simple method that returns true for 6 correct color guesses. That was it. The next test made us change the return variable to an 
  integer that shows the number of colors guessed correctly. And then, the next test made the method return an object of the MatchResult
  class. Clearly, TDD changes the way we design our code in a different yet effective way.

  When applied properly or with supervision, TDD may require implementation adjustments, but it doesn’t necessarily force major change
  in the strategic design, and certainly begins providing the regression benefit immediately and throughout the development phase.
  Being able to see a clear case such as this assignment where proper testing led to a smooth and effective design that didn’t
  completely change the strategy along the way gave us confidence and respect for the TDD style. Now we have some realistic expectations
  and understanding of how the flow of TDD can go from minimal testing to reliability testing.


2. How is the current design different, if at all, from the strategic design created in hw2?

  Our strategic design consisted of three modular and generalized classes: GameView, GameLogic, and Color. Our TDD tactical design 
  consisted of five classes (excluding the extended/inherited JFrame and JButton classes): MasterMind, MatchResult, Colors, MasterMindUI
  and ColorButton. 

  However, those five TDD classes should be further grouped representing the three original classes. For example, a GameView group would
  include MasterMindUI, and ColorButton could be considered a member of the GameView group as it is directly related to the UI functions
  and the MasterMindUI class. A GameLogic group would include the MasterMind and MatchResult classes. A Color group would include Colors,
  and ColorButton could be considered a member of the Color group as it is also related to the Colors class. 

  By allowing our strategic design to guide us to the correct tactical design, the three core classes from the strategic design provided
  direction on creating the five classes at the tactical level. This TDD tactical design had just enough expansion upon the strategic 
  design to make it efficient and effective while creating just enough cohesion to keep it modular and maintainable


3.1 Were there any surprises or things you did not expect along the way? 

  Surprisingly, we did not deviate from the core strategic plan much at all. We highly suspect that is because this scenario was 
  performed in a lab type environment where, the student designers were the variables, and the design sprint implementations were guided.
  This was a pleasant and unexpected approach that relieved enough pressure to allow us to pay closer attention to the design queue’s
  being presented. 

  Another surprise was the way we perceived progress while developing tests. At some point you get the feeling the tests could go on 
  forever. This introduced an unusual mindset at the typical halfway point in coding. Typically, the halfway point in a standard design 
  style would leave the programmers with a sense of relief being able to see half the actionable code at work. However, halfway into a
  TDD style approach, a programmer could easily feel there is much more test writing that could be done before getting to that expected 
  halfway feeling. Remembering the requirements and making sure we stop testing once the minimum code has expanded to effective code 
  keeps the programmer focused on realistic goals; and once a set of related code gets to be effective, the rest get there quickly too
  which gives the quick catch-up feeling. This all became a very surprising challenge to the expected mental states of a small project. 


3.2 Any particular problem faced, things you had to tackle that you did not expect beforehand?

  A proper beginning was a crucial, challenging, and unexpected hurdle. How easily and often we veered off an effective design course
  early in the testing was particularly troublesome. Having to contemplate a testing progression alongside an effective design was far
  more difficult than expected; even for a simple application such as this assignment. 

  Another problem we faced was to code the MasterMind class without including the guessCount. Looking at the UML that we had from the 
  last assignment, the first thought that came to mind was to make sure that the MasterMind should have a guessCount variable so that 
  it can make sure to stop the game after the number of attempts allowed, and it should be able to generate the selectedColors and 
  provide feedbacks right after. That was not the case with TDD. We did not have guessCount until very later in the code implementation 
  process.

  Timing is always a wild card when it comes to expectations. Fortunately, we expected feedback delays and surprise course changes, so
  we feel we left ourselves just enough time to get the job done (with guidance). Also as mentioned above, there was a moment in the
  middle where it seemed like the testing hallway kept getting longer as we attempted to exit. At some later point we suddenly realized
  we were out of the unit testing dream and gratefully into the UI implementation phase.
 
  In the end, the most difficult, lingering, and unexpected problem we faced was trying to resolve writing the minimum code needed to
  pass tests while trying to contemplate a design for the eventual complexity (included in the example from #1 above referring to this 
  issue). When expanding minimum code to effective code requires class level design changes, it’s initially hard to determine if it is 
  considered a failure or if that is the standard operating procedure for TDD.


Total [100]: 88
Program runs [10]:
Game works as expected [10]:
All tests pass [20]:
Test quality [15]:
Test for randomness [5]: -5
Code coverage [10]:
Code quality [10]:
Design quality [10]: -7
Long functions in the GUI code, need to break down to functions at one level of detail or abstraction
More functions than necessary.
Response to questions [10]:
