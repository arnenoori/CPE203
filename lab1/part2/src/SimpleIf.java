
public class SimpleIf {

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    if (avg > threshold) {
      return true;
    } else {
      return false;
    }

  }

  public static boolean analyzeApplicant2(Applicant applicant) {
    int score = 0;

    // testing years of experience
    if (applicant.getYearsOfExperience() == 0) {
      score -= 1;
    }
    else if (applicant.getYearsOfExperience() > 0 && applicant.getYearsOfExperience() <= 2) {
      score = score + 1;
    }
    else if (applicant.getYearsOfExperience() >= 3) {
      score = score + 2;
    }

    // testing number of languages
    if (applicant.getNumberOfKnownLanguages() == 0) {
      score = 0;
    }
    else if (applicant.getNumberOfKnownLanguages() > 0 && applicant.getNumberOfKnownLanguages() <= 2) {
      score = score + 1;
    }
    else if (applicant.getNumberOfKnownLanguages() >= 3) {
      score = score + 2;
    }

    // if person has experience
    if (applicant.getPreviousWork()) {
      score += 1;
    }
    else {
      score = 0;
    }

    return score >= 3;

    /*
    A person has to have a score of three of more to qualify for the job.
    - This particular job by Moogle is looking for canidates with previous work experience and coding experience.
    - Coding experience is expressed with the years of experience someone has, and the number of languages they know
    (for this job it's important to know a few different languages as their job is wide ranging.
    - If a person has no experience in a particular category, 1 point is deducted.
    - If they have moderate experience and has done previous work they gain a point (to qualify, a person can just be moderate in all fields)
    - If the person has a ton of experience, they gain 2 points (if people have a ton of experience but have never worked a previous job they can also qualify)

     */
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
    double top = 0;
    if (avg1 > avg2) {
      top = avg1;
    } else {
      top = avg2;
    }
    return top;
  }
}
