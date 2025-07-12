import java.util.*;

public class IdComparator implements Comparator<Student> {
   @Override
   public int compare(Student s1, Student s2) {
      int s1Id = Integer.parseInt(s1.getId());
      int s2Id = Integer.parseInt(s2.getId());
      
      return Integer.compare(s1Id, s2Id);
   }
}