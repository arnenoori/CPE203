
public class BetterLoop {
  /**
   * Accept an applicant if they have at least 4 grades above 85. Their non-CS
   * GPA counts as a grade in this case.
   * 
   * @param scores The applicant's list of scores
   * @return true if the applicant meets the requirements
   */
  public static boolean atLeastFourOver85(int[] scores) {
    /*
     * Use a FOR-EACH loop. How would you keep count of the number of scores over 85?
     */
    int allscores = 0;
    for (int score: scores) {
      if (score > 85)
        allscores++;
    }
    return allscores >= 4;
  }

  /**
   * Compute an applicant's average score in their 5 CS courses (that is, you must
   * NOT consider the final item in the array, the non-CS GPA).
   * 
   * @param scores
   * @return The average score
   */
  public static double average(int[] scores) {
    /*
     * A "normal" for-loop can sometimes be more useful than a for-each loop. How would
     * you solve this problem with a for loop?
     */
    int courses = 0;
    // NOTE: check back on this
    for (int i = 0; i < scores.length; i++) {
      courses += i;
    }
    double average = (courses/ scores.length);
    return average;
  }
}
