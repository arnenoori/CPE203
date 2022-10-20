import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleMap {

    /**
     * Return a list of "high scoring" students --- High scoring students are
     * students who have all grades strictly greater than the given threshold.
     *
     * @param scoresByApplicantName A map of applicant names to applicant scores
     * @param scoreThreshold        The score threshold
     * @return The list of high-scoring applicant names
     */
    public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {

        List<String> highScoringApplicants = new LinkedList<>();
        Set<String> keys = scoresByApplicantName.keySet();

        for (String key:keys) {
            List<CourseGrade> finalGrade = scoresByApplicantName.get(key);
            boolean score = true;
            for (CourseGrade grade: finalGrade) {
                if (grade.getScore() < scoreThreshold) {
                    score = false;
                }
            }
            if (score) {
                highScoringApplicants.add(key);
            }
        }
        return highScoringApplicants;

            /*
    for (String applicant: scoresByApplicantName.keySet()) {
      int units = 0;

      List<String> scores = scoresByApplicantName.get(applicant);
      for (String score : scores) {
        scores += CourseGrade.getScores();
      }
      if (scores > scoreThreshold) {
        highScoringApplicants.add(applicant);
      }
    }
    return highScoringApplicants;

     */

    }
}
