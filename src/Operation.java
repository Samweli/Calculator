/**
 * Created with IntelliJ IDEA.
 * User: samweli
 * Date: 7/9/14
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */

/*
   This class contains the implementation
   of the all operations that are needed to be
   performed on the calculator
 */

public class Operation {


    private final String SYNTAX_ERROR = "Syntax Error";
    private final String MATH_ERROR = "Math Error";

    public String abs(String textAreaString){

        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString);
            result = Math.abs(number);
        }catch(Exception e){
            return SYNTAX_ERROR;
        }

        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);
    }

    public String sqr(String textAreaString){

        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString);
            result = number * number;
        }catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);

    }
    public String sqrt(String textAreaString){

        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString);
            result = Math.sqrt(number);
        }catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);

    }


    public String add(String textAreaString){

        double firstNumber;
        double secondNumber;

        double result;

        if(textAreaString!=null){
            try{
                firstNumber = Double.parseDouble(textAreaString.substring(0,textAreaString.indexOf("+")));
                secondNumber = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("+") + 1,textAreaString.length()));

                result = firstNumber + secondNumber;
            }catch(Exception e){
                return SYNTAX_ERROR;
            }

            if(result == (long)result){
                return String.valueOf((long)result);
            }

            return String.valueOf(result);

        }
        return null;
    }

    public String subtract(String textAreaString){
        double firstNumber;
        double secondNumber;

        double result;

        if(textAreaString!=null){
            try{
                firstNumber = Double.parseDouble(textAreaString.substring(0,textAreaString.indexOf("-")));
                secondNumber = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("-") + 1,textAreaString.length()));

                result = firstNumber - secondNumber;
            }catch(Exception e){
                return SYNTAX_ERROR;
            }
            if(result == (long)result){
                return String.valueOf((long)result);
            }

            return String.valueOf(result);

        }
        return null;

    }

    public String multiply(String textAreaString){
        double firstNumber;
        double secondNumber;

        double result;

        if(textAreaString!=null){
            try{
                firstNumber = Double.parseDouble(textAreaString.substring(0,textAreaString.indexOf("*")));
                secondNumber = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("*") + 1,textAreaString.length()));

                result = firstNumber * secondNumber;
            }catch(Exception e){
                return SYNTAX_ERROR;
            }

            if(result == (long)result){
                return String.valueOf((long)result);
            }

            return String.valueOf(result);

        }
        return null;
    }

    public String divide(String textAreaString){
        double firstNumber;
        double secondNumber;

        double result;

        if(textAreaString!=null){
            try{
                firstNumber = Double.parseDouble(textAreaString.substring(0,textAreaString.indexOf("/")));
                secondNumber = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("/") + 1,textAreaString.length()));

                result = firstNumber / secondNumber;
            }catch(ArithmeticException e){
                return MATH_ERROR;
            }

            catch(Exception e){
                return SYNTAX_ERROR;
            }

            if(result == (long)result){
                return String.valueOf((long)result);
            }

            return String.valueOf(result);
        }

        return null;
    }


    public String modulo(String textAreaString){
        double firstNumber;
        double secondNumber;

        double result;

        if(textAreaString!=null){
            try{
                firstNumber = Double.parseDouble(textAreaString.substring(0,textAreaString.indexOf("%")));
                secondNumber = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("%") + 1,textAreaString.length()));

                result = firstNumber % secondNumber;
            }catch(Exception e){
                return SYNTAX_ERROR;
            }

            if(result == (long)result){
                return String.valueOf((long)result);
            }

            return String.valueOf(result);

        }
        return null;
    }

    public String logE(String textAreaString){
        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("n")+1,textAreaString.length()));
            result = Math.log(number);
        }
        catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);

    }
    public String log(String textAreaString){
        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("g")+1,textAreaString.length()));
            result = Math.log10(number);
        }
        catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);

    }

    public String sin(String textAreaString){
        double number;
        double result;
        try{
            number = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("n")+1,textAreaString.length()));

            result = Math.round(Math.sin(Math.toRadians(number)) * 10000.0) / 10000.0;
        }
        catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);

    }
    public String cos(String textAreaString){
        double number;
        double result;

        try{
            number = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("s")+1,textAreaString.length()));

            result = Math.round(Math.cos(Math.toRadians(number)) * 10000.0) / 10000.0;
        }
        catch(Exception e){
            return SYNTAX_ERROR;
        }

        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);
    }

    public String tan(String textAreaString){
        double number;
        double result;

        try{
            number = Double.parseDouble(textAreaString.substring(textAreaString.indexOf("n")+1,textAreaString.length()));

            result = Math.round(Math.tan(Math.toRadians(number)) * 10000.0) / 10000.0;
        }
        catch(Exception e){
            return SYNTAX_ERROR;
        }
        if(result == (long)result){
            return String.valueOf((long)result);
        }

        return String.valueOf(result);
    }







}
