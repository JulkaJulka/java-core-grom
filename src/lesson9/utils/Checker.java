package lesson9.utils;

/**
 * Created by user on 25.05.2017.
 */
public class Checker {
    //public - доступ в рамкам проекта
    //private - элемент(поле,метод,конструктор) доступны в пределах класса 90+%
    //default (package private) - если область видимости не указана(доступен в пределах пакета)
    //protected -

    //private
    //default
    //protected
    //public

     int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName){
       //if (companyName == "Google" || companyName == "Amazon")
         //  return false;
       // return true;
        if(companyNamesValidatedCount > 10)
            return  false;

        companyNamesValidatedCount++;
       return companyName != "Google" && companyName != "Amazon";
    }
}
