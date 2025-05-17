
package chatbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBotFramework {

    private static Map<String, String> intents = new HashMap<>();
    private static String lastIntent = "";

    public static void main(String[] args) {
        initializeIntents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 Hello! I'm your Java Chatbot. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("🤖 Goodbye!");
                break;
            }

            String response = classifyIntent(input);
            System.out.println("Bot: " + response);
        }

        scanner.close();
    }

    private static void initializeIntents() {
        intents.put("hello", "Hi there! 👋");
        intents.put("how are you", "I'm just a bunch of Java code, but thanks for asking! 😊");
        intents.put("bye", "See you later! 👋");
        intents.put("what is your name", "I'm a Java-based AI chatbot.");
        intents.put("help", "You can say hello, ask my name, or say bye.");
    }

    private static String classifyIntent(String input) {
        for (String key : intents.keySet()) {
            if (input.contains(key)) {
                lastIntent = key;
                return intents.get(key);
            }
        }
        return handleUnknownIntent(input);
    }

    private static String handleUnknownIntent(String input) {
        if (lastIntent.equals("help")) {
            return "Try saying something like 'hello' or 'what is your name'. 🤖";
        }
        return "Sorry, I didn't understand that. 🤔";
    }
}
