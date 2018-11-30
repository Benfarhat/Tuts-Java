package org.bft.java7.exceptionhandling;

public class App {

    public static void main(String[] args)
    {
        try{    
            int array[] = new int[10];    
            array[11] = 30/0;    
        }    
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){  
            System.out.println(e.getMessage());  
        }  
        /* Equivalent to :
        catch(ArithmeticException e){  
            System.out.println(e.getMessage());  
        }    
        catch(ArrayIndexOutOfBoundsException e){  
            System.out.println(e.getMessage());  
        }  
        */  
        catch(Exception e){  
            System.out.println(e.getMessage());  
        }  
        /* Take care if you are using a super exception class like Exception (general)
         * you cannot use child (specialized) class like ArithmeticException
         * For example:
         *    catch(Exception | ArithmeticException | ArrayIndexOutOfBoundsException e)
         * Will cause a compile-time error givin this output:
         *    Compile-time error: The exception ArithmeticException is already caught by the alternative Exception
         * 
         */
    }
}
