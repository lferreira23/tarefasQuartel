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
    
    public static boolean validarCPF(String cpf) {
        
        if(cpf.length() != 11)
            return false;
        
        int d = 10;
        int dv1 = 0;
        int dv2 = 0;
        while(d > 1) {
            int _d = cpf.charAt(10-d)-'0';
            dv1 += _d*d;
            --d;
        }
        dv1 = dv1%11;
        if(dv1 < 2)
            dv1 = 0;
        else
            dv1 = 11-dv1;
        d = 11;
        while(d > 1) {
            int _d = cpf.charAt(11-d)-'0';
            dv2 += _d*d;
            --d;
        }
        dv2 = dv2%11;
        if(dv2 < 2)
            dv2 = 0;
        else
            dv2 = 11-dv2;
        return (cpf.charAt(9)-'0') == dv1 && (cpf.charAt(10)-'0') == dv2;
    }
}
