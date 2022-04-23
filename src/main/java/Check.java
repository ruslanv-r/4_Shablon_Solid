public class Check {
    public boolean checkForInt(String temp){
        try {
           int choiceNumber1 = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            System.out.println("!!!!Введены не числовые значения!!!!");
            return false;
        }
        return true;
    }
}
