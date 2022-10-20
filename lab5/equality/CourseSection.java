import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   // Need to implement hashcode the long way
    public int hashCode() {
       int hash = 1;
       if(prefix != null){
           hash = hash*31 + prefix.hashCode();
       }
       if(number != null) {
           hash = hash*31 + number.hashCode();
       }
       hash = hash*31 + enrollment;
       if(startTime != null) {
           hash = hash*31 + startTime.hashCode();
       }
       if (endTime != null) {
           hash = hash*31 + endTime.hashCode();
       }
       return hash;
    }

    public boolean equals(Object other) {
       if (other != null) {
           if (getClass() == other.getClass()) {
               String otherPrefix = ((CourseSection) other).prefix;
               String otherNumber = ((CourseSection) other).number;
               int otherEnrollment = ((CourseSection) other).enrollment;
               LocalTime otherStart = ((CourseSection) other).startTime;
               LocalTime otherEnd = ((CourseSection) other).endTime;

               boolean prefixEqual, numberEqual, enrollmentEqual, startTimeEqual, endTimeEqual;

               if (prefix == null) {
                   prefixEqual = (otherPrefix == null);
               } else {
                   prefixEqual = (prefix.equals(otherPrefix));
               }
               if (number == null) {
                   numberEqual = (otherNumber == null);
               } else {
                   numberEqual = (number.equals(otherNumber));
               }
               if (startTime == null) {
                   startTimeEqual = (otherStart == null);
               } else {
                   startTimeEqual = (startTime.equals(otherStart));
               }
               if (endTime == null) {
                   endTimeEqual = (otherEnd == null);
               } else {
                   endTimeEqual = (endTime.equals(otherEnd));
               }

               enrollmentEqual = (enrollment == otherEnrollment);
               return prefixEqual && numberEqual && enrollmentEqual && startTimeEqual && endTimeEqual;
           }
       }
       return false;
    }


}
