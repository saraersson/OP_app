public class Logger {

    static void checkLen(int len){      // throwing the exceptions

        if (len < 10)
            System.out.println("A social security number must be at least 10 characters long.");
        else if (len > 12)
            System.out.println("A social security number must not be more than 12 characters long.");

    }

    static void printResult(PersonalNumber pn) {
        System.out.println("The input given is a valid blabla");
    }

    static void cantBeSwedish() {
        System.out.println("The input given is not a Swedish social security number.");
    }

    static void cantBeCoordination() {
        System.out.println("The input given is not a coordination nr.");
    }

    static void cantBeOrganisation() {
        System.out.println("The input given is not an organisation nr.");
    }
}

