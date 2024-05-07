
public class StudentMarkSheet {
    public static String generateMarkSheet(String studentName, Map<String, Integer> subjectMarks) {
        String markSheet = 'Mark Sheet for ' + studentName + '\n\n';
        markSheet += 'Subject\tMarks\n';
        markSheet += '--------------------------------\n';
        
        for (String subject : subjectMarks.keySet()) {
            markSheet += subject + '\t' + subjectMarks.get(subject) + '\n';
        }
        
        return markSheet;
    }

    public static void main(){
        Map<String, Integer> marks = new Map<String, Integer>();
        marks.put('English', 85);
        marks.put('Mathematics', 92);
        marks.put('Science', 78);
        
        String markSheet = StudentMarkSheet.generateMarkSheet('John Doe', marks);
        System.debug(markSheet);
    }
}