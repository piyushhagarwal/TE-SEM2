package Assignment5;

import java.util.HashMap;
import java.util.Scanner;

public class Chatbot {

    // Responses to different queries
    public static HashMap<String, String> responses = new HashMap<String, String>();
    {
        responses.put("hello", "Hello! How can I help you?");
        responses.put("hii", "Hii! How can I help you?");
        responses.put("admission", "For admission related queries, please visit the college website.");
        responses.put("placement",
                "We have amazing placement opportunities for our students. Last year, 90% of our students got placed in top companies.");
        responses.put("fees", "Fees for 1 year is 1,00,000 INR.");
        responses.put("hostel", "We have accomodation facilities for both boys and girls inside the hostel premises.");
        responses.put("faculty", "We have highly qualified faculty members with years of experience.");
        responses.put("library", "We have a well-stocked library with over 10,000 books.");
        responses.put("sports",
                "We have a sports complex with facilities for cricket, football, basketball, and badminton.");
        responses.put("canteen", "We have a canteen that serves delicious food at affordable prices.");
        responses.put("food", "We have a canteen that serves delicious food at affordable prices.");
        responses.put("transport",
                "We have a fleet of buses that provide transportation to students from all parts of the city.");

    }

    public void chatbot() {
        System.out.println("Hello! How can I help you?");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("You: ");

            String query = sc.nextLine().toLowerCase();

            // Split the query into words with space as the delimiter
            String[] words = query.split("\\s+");

            // Check if the query contains any of the keywords
            boolean found = false;
            for (String word : words) {
                if (responses.containsKey(word)) {
                    System.out.println("Chatbot: " + responses.get(word));
                    found = true;
                    break;
                }
            }

            // Check if the user wants to exit the chat
            if (query.equals("exit")) {
                System.out.println("Chatbot: Thank you for chatting with me. Have a great day!");
                break;
            }

            // If the query does not contain any of the keywords
            if (!found) {
                System.out.println("Chatbot: I'm sorry, I do not understand your query.");
            }

        }
        sc.close();
    }

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.chatbot();
    }
}
