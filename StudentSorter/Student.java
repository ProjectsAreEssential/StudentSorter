public class Student {
   // Instance fields
   private String lastName;
   private String firstName;
   private String id;
   private double gradePercent;
   private String letterGrade;
   
   // Constructor
   public Student(String lastName, String firstName, String id, double gradePercent, String letterGrade) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.id = id;
      this.gradePercent = gradePercent;
      this.letterGrade = letterGrade;
   }
   
   // Gets lastName 
   public String getLastName() {
      return lastName;
   }
   
   // Gets firstName
   public String getFirstName() {
      return firstName;
   }
   
   // Gets id
   public String getId() {
      return id;
   }
   
   // Gets gradePercent
   public double getGradePercent() {
      return gradePercent;
   }
   
   // Gets letterGrade 
   public String getLetterGrade() {
      return letterGrade;
   }
   
   // Sets lastName
   public void setLastName(String newLastName) {
      lastName = newLastName;
   }
   
   // Sets firstName
   public void setFirstName(String newFirstName) {
      firstName = newFirstName;
   }
   
   // Sets id
   public void setId(String newId) {
      id = newId;
   }
   
   // Sets gradePercentage
   public void setGradePercent(double newGradePercent) {
      gradePercent = newGradePercent;
   }
   
   // Sets letterGrade
   public void setLetterGrade(String newLetterGrade) {
      letterGrade = newLetterGrade;
   }
   
   // Prints a string representation
   @Override
   public String toString() {
      return String.format("%-12s %-12s %-10s %4.1f %6s", lastName, firstName, id, gradePercent, letterGrade);
   }
}