package common.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

/**
 *
 * @author jhonfer
 */
public class Console {
    public static <T> boolean writeJumpLine(T tagMessage, boolean isMessage) {
        try {
            System.out.println(tagMessage);
            if (isMessage) {
                System.out.println("Se escribio correctamente!");
            }
            return true;
        } catch (Exception e) {
            if (isMessage) {
                System.out.println("No se pudo escribir correctamente, debibo a " + e.getMessage());
            }
            return false;
        }
    }

    public static <T> boolean writeJumpLine(T[] list, boolean isMessage) {
        for (int index = 0; index < list.length; index++) {
            if (!writeJumpLine((index + 1) + "." + list[index], isMessage)) {
                writeJumpLine("Existe un dato incorrecto del vector que no se puede mostrar", false);
                writeJumpLine(index + "Posicion del vector con el error", false);
            }
        }
        return true;
    }

    public static <T> boolean write(T tagMessage, boolean isMessage) {
        try {
            System.out.print(tagMessage);
            if (isMessage) {
                writeJumpLine("Se escribio correctamente!", false);
            }
            return true;
        } catch (Exception e) {
            if (isMessage) {
                writeJumpLine("No se pudo escribir correctamente, debibo a " + e.getMessage(), false);
            }
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T> T read(T chainInput, boolean isMessage) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String value = "", option = "";
        T backupChainInput = chainInput;
        try {
            value = input.readLine();
            option = ((Object) chainInput).getClass().getSimpleName();
            switch (option) {
                case "String": {
                    if (!isNumber(value)) {
                        chainInput = (T) String.valueOf(value.trim());
                    }
                    break;
                }
                case "Double": {
                    if (isNumber(value) && value.contains(".")) {
                        chainInput = (T) Double.valueOf(value.trim());
                    }
                    break;
                }
                case "Float": {
                    if (isNumber(value) && value.contains(".")) {
                        chainInput = (T) Float.valueOf(value.trim());
                    }
                    break;
                }
                case "Integer": {
                    if (isNumber(value)) {
                        chainInput = (T) Integer.valueOf(value.trim());
                    }
                    break;
                }
            }
            if (isMessage) {
                writeJumpLine("Se ha leido correctamente!", false);
            }
        } catch (IOException | NumberFormatException e) {
            if (isMessage) {
                writeJumpLine("No se pudo leer debido al error: " + e.getMessage(), false);
            }
        }
        if (backupChainInput.equals(chainInput)) {
            writeJumpLine("El dato ingresado no es valido", isMessage);
        }
        return chainInput;
    }

    public static <T> T read(String tagMessage, T chainInput, boolean isMessage) {
        T result;
        do {
            writeJumpLine(tagMessage, isMessage);
            result = read(chainInput, isMessage);
        } while (chainInput.equals(result));
        return result;
    }

    public static boolean isNumber(String chain) {
        return chain.matches("[+-]?\\d*(\\.\\d+)?");
    }
    
    public static String encoder() {
        int i = 100; // longitud
        String theAlphaNumericS;
        StringBuilder builder;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 

        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 
            // generate numeric
            int myindex = (int)(theAlphaNumericS.length()* Math.random()); 

            // add the characters
            builder.append(theAlphaNumericS.charAt(myindex)); 
        }  
        String tokenrandomichars = builder.toString();
        
        //Convertir en base64 y guardar en value        
        return Base64.getEncoder().encodeToString(tokenrandomichars.getBytes());
    }
}