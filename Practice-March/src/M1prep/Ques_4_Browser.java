package M1prep;

import java.util.List;
import java.util.Stack;

public class Ques_4_Browser {
    public static void browserNavigation(List<String> commands) {

                Stack<String> backStack = new Stack<>();
                Stack<String> forwardStack = new Stack<>();

                String currentPage = null;

                for (String command : commands) {

                    if (command.startsWith("visit")) {

                        String page = command.substring(6);

                        if (currentPage != null) {
                            backStack.push(currentPage);
                        }

                        currentPage = page;

                        forwardStack.clear();

                        System.out.println("Current Page: " + currentPage);
                    }

                    else if (command.equals("back")) {

                        if (!backStack.isEmpty()) {
                            forwardStack.push(currentPage);
                            currentPage = backStack.pop();
                        }

                        System.out.println("Current Page: " + currentPage);
                    }

                    else if (command.equals("forward")) {

                        if (!forwardStack.isEmpty()) {
                            backStack.push(currentPage);
                            currentPage = forwardStack.pop();
                        }

                        System.out.println("Current Page: " + currentPage);
                    }
                }
            }

            public static void main(String[] args) {

                List<String> commands = List.of(
                        "visit google",
                        "visit youtube",
                        "visit github",
                        "back",
                        "back",
                        "forward",
                        "visit linkedin",
                        "back"
                );

                browserNavigation(commands);
            }
        }
