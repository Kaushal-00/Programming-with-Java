import java.util.Scanner;

class GraterThanTenException extends Exception {
    GraterThanTenException(String msg) {
        super(msg);
    }
}

class EqualsToException extends Exception {
    EqualsToException(String msg) {
        super(msg);
    }
}

class LessThanFiveException extends Exception {
    LessThanFiveException(String msg) {
        super(msg);
    }
}

public class Main {

    static void checkString(String str) throws GraterThanTenException, EqualsToException, LessThanFiveException {

        if(str.equals("Welcome to ADIT")) {
            throw new EqualsToException("Error: Given String is equals to 'Welcome to ADIT'..!!");
        }else if(str.length() > 10) {
            throw new GraterThanTenException("Error: Length of the given String is more than 10..!!");
        }else if(str.length() < 5) {
            throw new LessThanFiveException("Error: Length of the given String is Less than 5..!!");
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String..!!");
        String str = sc.nextLine();

        try{
            checkString(str);
        } catch (GraterThanTenException | EqualsToException | LessThanFiveException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            sc.close();
        }

    }
}