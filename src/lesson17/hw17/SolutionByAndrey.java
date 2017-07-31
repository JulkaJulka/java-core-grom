package lesson17.hw17;

/**
 * Created by user on 31.07.2017.
 */
public class SolutionByAndrey {
    // 0) проверка на null  и ""
    // 1) должен начинаться с http:// https://
    // 2) www. не обязательно
    // 3)доменная зона .com, .org, .net
    // 4)другие точки не допускаются и спецсимволы тоже


    // https://www.test.com - valid
    // https://www.test1.com - valid
    // http://wwwtest.com - valid

    public boolean validate(String adress){
        if(adress == null || adress.isEmpty())
        return false;

        adress = adress.trim();

        if(!adress.startsWith("http://") && !adress.startsWith("https://"))
            return false;

        if(!adress.endsWith(".com") && !adress.endsWith(".net") && !adress.endsWith(".org") )
            return false;

        adress = adress.replaceAll("www.", "");
        adress = adress.replaceAll("http://", "");
        adress = adress.replaceAll("https://", "");
        adress = adress.replaceAll(".org", "");
        adress = adress.replaceAll(".net", "");
        adress = adress.replaceAll(".com", "");
return check(adress);
    }

    private boolean check(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }

        return true;
    }


}
