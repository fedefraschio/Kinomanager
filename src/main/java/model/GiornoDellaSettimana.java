package model;

import java.time.DayOfWeek;

public enum GiornoDellaSettimana {
    Lunedì, Martedì, Mercoledì, Giovedì, Venerdì, Sabato, Domenica;

    public static GiornoDellaSettimana getGiornoDaDay(DayOfWeek d)
    {
        if(d.equals(DayOfWeek.MONDAY))
            return Lunedì;
        else if(d.equals(DayOfWeek.TUESDAY))
            return Martedì;
        else if(d.equals(DayOfWeek.WEDNESDAY))
            return Mercoledì;
        else if(d.equals(DayOfWeek.THURSDAY))
            return Giovedì;
        else if(d.equals(DayOfWeek.FRIDAY))
            return Venerdì;
        else if(d.equals(DayOfWeek.SATURDAY))
            return Sabato;
        else
            return Domenica;
    }

    public static GiornoDellaSettimana getGiornoDaString(String d)
    {
        if(d.equalsIgnoreCase("Lunedì"))
            return Lunedì;
        else if(d.equalsIgnoreCase("Martedì"))
            return Martedì;
        else if(d.equalsIgnoreCase("Mercoledì"))
            return Mercoledì;
        else if(d.equalsIgnoreCase("Giovedì"))
            return Giovedì;
        else if(d.equalsIgnoreCase("Venerdì"))
            return Venerdì;
        else if(d.equalsIgnoreCase("Sabato"))
            return Sabato;
        else
            return Domenica;
    }
}
