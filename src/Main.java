public class Main {
    public static void main(String[] args) {


        try {
            checkMethods("login?", "password?", "confirmPassword");
            System.out.println("Логин выполнен");
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Я файнели");
        }


    }

    public static void checkMethods(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException {

        if (!checkSymbols(login)) {
            System.out.println("Логин содержит неправильные символы");
        }
        if (!checkSymbols(password)) {
            System.out.println("Пароль содержит неправильные символы");
        }


        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (password.length() >= 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }






    static boolean checkSymbols(String object) {

        object.toLowerCase();
        char[] preparedObject = object.toCharArray();
        boolean resultChecking = true;

        for (int i = 0; i < preparedObject.length; i++) {
            if ((preparedObject[i] == '_') || ((preparedObject[i] >= '0') && (preparedObject[i] <= '9')) || ((preparedObject[i] >= 'a') && (preparedObject[i] <= 'z'))) {
                resultChecking = true;

            } else {resultChecking = false;}
        }
                return resultChecking;
    }

}












//        LoginOld login = new LoginOld();
//        login.setLogin("fF9_*");
//        CheckMethodsOld.checkSymbols(login.getLogin());

//        PasswordOld password = new PasswordOld();
//        password.setPassword("Qa6_*");
//        CheckMethodsOld.checkSymbols(password.getPassword());

//        PasswordOld confirmPassword = new PasswordOld();
//        confirmPassword.setPassword("Qa6_*");
//        CheckMethodsOld.checkSymbols(confirmPassword.getPassword());