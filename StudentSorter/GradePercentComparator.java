import java.util.*;

public class GradePercentComparator implements Comparator<Student> {
   @Override
   public int compare(Student s1, Student s2) {
      return Double.compare(s1.getGradePercent(), s2.getGradePercent());
   }
}