package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Classe para utilitários
 */
public class Utils {
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateToString(Date date) {
        return df.format(date);
    }
    
    public static Date stringToDate(String string) {
        df.setLenient(true);
        try {
            return df.parse(string);
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static int stringToInt(String string) {
        int result = 0;
        result = Integer.parseInt(string);
        return result;
    }
    
    public static int getAgeInYears(Date birthDate) {
        LocalDate dataNascimento = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
