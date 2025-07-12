import java.util.*;
import java.io.*;

public class StudentDriver {
   public static void main(String[] args) {
      List<Student> students = new ArrayList<>();
      
      try {
         Scanner input = new Scanner(new File("grades.txt"));
         students = loadStudents(input);
         input.close();
         
         sortAndDisplay(students);
      } catch (FileNotFoundException e) {
         System.out.println("Error opening file: " + e);
      }
   }
   
   public static List<Student> loadStudents(Scanner input) {
      List<Student> students = new ArrayList<>();
   
      while (input.hasNextLine()) {
         String line = input.nextLine();  
   
         String[] tokens = line.split(" ");        
         String lastName = tokens[0].trim();
         String firstName = tokens[1].trim();
         String id = tokens[2].trim();
         double gradePercent = Double.parseDouble(tokens[3].trim());
         String letterGrade = tokens[4].trim();
   
         students.add(new Student(lastName, firstName, id, gradePercent, letterGrade));
      }
   
      return students;
   }
   
   public static void sortAndDisplay(List<Student> students) {
      Scanner console = new Scanner(System.in);
   
      boolean continueSorting = true;
      while (continueSorting) {
         int sortOption = 0;
         while (true) {
            System.out.print(
                "Choose a sort option (1 - Last Name, 2 - ID, 3 - Grade): ");
            if (console.hasNextInt()) {
               sortOption = console.nextInt();
               if (sortOption >= 1 && sortOption <= 3) {
                  break;
               } else {
                  System.out.println("Invalid choice. Please enter 1, 2, or 3.");
               }
            } else {
               console.next();
               System.out.println("Invalid input. Please enter a number.");
            }
         }
   
         int sortOrder = 0;
         while (true) {
            System.out.print(
                "Choose a sort order (1 - Ascending, 2 - Descending): ");
            if (console.hasNextInt()) {
               sortOrder = console.nextInt();
               if (sortOrder == 1 || sortOrder == 2) {
                  break;
               } else {
                  System.out.println("Invalid choice. Please enter 1 or 2.");
               }
            } else {
               console.next();
               System.out.println("Invalid input. Please enter a number.");
            }
         }
   
         Comparator<Student> comparator;
         switch (sortOption) {
            case 1:
               comparator = new LastNameComparator();
               break;
            case 2:
               comparator = new IdComparator();
               break;
            case 3:
               comparator = new GradePercentComparator();
               break;
            default:
               comparator = new LastNameComparator();
         }
   
         if (sortOrder == 2) {
            comparator = Collections.reverseOrder(comparator);
         }
   
         Collections.sort(students, comparator);
         
         System.out.printf("%-12s %-12s %-10s %-9s %-3s\n", "LastName", "FirstName", "ID", "Grade", "Letter");
         for (Student s : students) {
            System.out.println(s);
         }
   
         System.out.print("Sort again? (y/n): ");
         String again = console.next();
         if (!again.equalsIgnoreCase("y")) {
            continueSorting = false;
         }
      }
   }
}