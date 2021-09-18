/**
 * @author Somtochukwu Nwagbata
 * @version 1.0.0 This is the StudyBuddies class.
 */
public class StudyBuddies {
    /**
     * Entry point for running class.
     * 
     * @param args - main arguments
     */
    public static void main(String[] args) {
        Student[] group1 = StudyBuddies.groupFinder();
        Student[] group2 = groupFinder();
        groupAnalyzer(group1);
        groupAnalyzer(group2);
        groupScores(group1, group2);
    }

    /**
     * Static class that takes no input returns an array of random.
     * 
     * @return an array of Student with random values
     */
    public static Student[] groupFinder() {
        Student[] studentArray = new Student[6];

        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = Student.values()[(int) (Math.random() * (studentArray.length))];
        }
        return studentArray;
    }

    /**
     * For each element of the student enum, count how many are in studentArray and
     * store that in another array. This new new array will be looped over along
     * with the enum when printing how man if each enum value there are.
     * 
     * @param studentArray - array of Student.
     * 
     */
    public static void groupAnalyzer(Student[] studentArray) {
        int[] count = new int[studentArray.length];
        System.out.println("The following types of students are in your study group:");

        for (int j = 0; j < Student.values().length; j++) {
            int temp = 0;
            for (int i = 0; i < studentArray.length; i++) {
                if (Student.values()[j] == studentArray[i]) {
                    temp++;
                }
            }
            count[j] = temp;
        }

        for (int k = 0; k < Student.values().length; k++) {
            System.out.println(Student.values()[k] + " " + count[k]);
        }
    }

    /**
     * This calculates the overall score of the groups using the ordinal score of
     * the enum.
     * 
     * @param group1 - first group to score
     * @param group2 - second group to score
     */
    public static void groupScores(Student[] group1, Student[] group2) {
        int grp1 = 0;
        int grp2 = 0;
        for (Student s : group1) {
            grp1 += s.ordinal();
        }

        for (Student s : group2) {
            grp2 += s.ordinal();
        }

        if (grp1 > grp2) {
            System.out.println("The former is predicted to perform better than the latter.");
        } else if (grp1 < grp2) {
            System.out.println("The latter is predicted to perform better than the former.");
        } else {
            System.out.println("The two groups are predicted to perform equally well.");
        }

    }
}