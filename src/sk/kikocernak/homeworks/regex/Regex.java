package sk.kikocernak.homeworks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

//  1. úloha: Napíš metódu, ktorá bude akceptovať na vstupe String predstavujúci email. Metóda overí, či je email v správnom formáte. Metóda vráti true ak áno inak false.
//
//
//  2. úloha: Napíš metódu, ktorá overí zložitosť zadaného hesla. Na vstupe metódy bude heslo. Metóda preverí či heslo spĺňa nasledovné kritéria:
//    minimálne 8 znakov
//    musí obsahovať aspoň jedno veľké písmeno
//    musí obsahovať aspoň jedno číslo
//

//  3. úloha: Napíš metódu, ktorá overí, či daný String je obrázok = koncovka je jedna z nasledujúcich: .jpg, .png, .jpeg, .bmp
//
//
//  4. úloha: Napíš metódu, ktorá zistí, či daný String má správny tvar dátumu. Uvažuj, že správny tvar je nasledujúci: dd/mm/yyyy. Kde dd je den vo formáte 01 pre prvý deň. Kde mm je mesiac vo formáte 02 pre február. Kde yyyy je rok vo formáte 2018.
//

//  5. úloha: Napíš metódu, ktorá pomocou regulárneho výrazu vypíše na konzolu všetky slová začínajúce na veľké písmeno.
//
//            6. úloha: Napíš metódu, ktorá pomocou regulárneho výrazu nájde všetky čísla v texte a vypíše ich na konzolu.

    public static boolean simpleCheckEmailFormat(String email){
        Pattern p = Pattern.compile("\\w+[@]{1}+\\w+[.]\\w+");
        Matcher m = p.matcher(email);

        if(m.find()){
            return true;
        } else return false;
    }
}
