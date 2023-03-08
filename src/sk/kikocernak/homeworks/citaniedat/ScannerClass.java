package sk.kikocernak.homeworks.citaniedat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerClass {

/*
7. úloha: napíš metódu, ktorej zadáš tvoj dátum narodenia. Na výstupe sa ti vypíše v aké dni budeš mať v budúcnosti mať narodeniny (2019 pondelok, 2020 štvrtok, atď.)

8. úloha: napíš metódu, ktorá vypíše na konzolu či je dnes práve sviatok. Dátumy sviatkov si môžeš pozrieť napríklad tu: http://kalendar.azet.sk/sviatky/. Veľkú noc nemusíš riešiť.
*/



//01.
//      úloha: Napíš metódu, ktorá bude čítať dáta z konzoly. Teda to čo napíšeš na konzolu a stlačíš enter, to sa vypíše. Čítať dáta bude dovtedy kým nenapíšeš q a nestlačíš enter.

    public static void scanner(){
        Scanner scanner = new Scanner(System.in);
         while (true) {
             System.out.println("Napíš niečo: ");
             String input = scanner.nextLine();
             if (input.equals("q")) {
                 System.out.println("Exit!");
                 break;
             }

             System.out.println("input: " + input);
             System.out.println("-------------------");
        }
    }



//02.
//      úloha: Napíš si triedu Osoba, ktorá bude mať meno a priezvisko. Potom napíš metódu, ktorá si bude z konzoly pýtať zadanie mena a priezviska a na základe údajov z konzoly vytvorí inštanciu Osoby. Teda niečo ako new Osoba(menoZKonzoly, priezviskoZKonzoly).

    public static void vytvorOsobu(){
        Scanner scanner = new Scanner(System.in);
        String meno;
        String priezvisko;

        System.out.println("Meno osoby: ");
        meno = scanner.nextLine();
        System.out.println("Priezvisko osoby: ");
        priezvisko = scanner.nextLine();

        Osoba osoba = new Osoba(meno, priezvisko);
        System.out.printf("Meno: %s\nPriezvisko: %s", osoba.getMeno(), osoba.getPriezvisko());
    }



//03.
//      úloha: Napíš metódu, ktorá požiada používateľa o zadanie čísla. Ak zadá číslo vypíš ho na konzolu, ak zadá niečo iné, tak vypíš chybovú hlášku.
    public static void vypisCislo(){
        Scanner scanner = new Scanner(System.in);
        String number;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m;

        while(true){
            System.out.println("Zadajte číslo: ");
            number = scanner.nextLine();
            m= pattern.matcher(number);

            if (number.equals("q")) {
                System.out.println("Exit!");
                break;
            }
            if (!m.find()) {
                System.err.println("Chyba! Zle zadané číslo!");
                System.out.println("-----------------------------");
            } else {
                System.out.printf("Zadané číslo: %s \n", m.group());
                System.out.println("-----------------------------");
            }
        }
    }



//04.
//      úloha: napíš metódu, ktorá načíta z konzoly jednoduché matematické operácie a vykoná ich. Napríklad ak napíšem do konzoly 4+5. Tak sa vykoná sčítanie a na výstup sa napíše výsledok 9.
    public static void pocitaj() {
        Scanner scanner = new Scanner(System.in);
        String number;
        String znamienko = null;
        int indexOperatora;
        double cislo1;
        double cislo2;

        System.out.println("Zadajte príklad: ");
        number = scanner.nextLine();

        if (number.contains("+")) {
            znamienko = "+";
        } else if (number.contains("-")) {
            znamienko = "-";
        } else if (number.contains("*")) {
            znamienko = "*";
        } else if (number.contains("/")) {
            znamienko = "/";
        } else {
            throw new RuntimeException("Zle zadaný operátor! Možné použiť len +, -, * alebo / .");
        }

        indexOperatora = number.indexOf(znamienko);

        cislo1 = Double.parseDouble(number.substring(0, indexOperatora));
        cislo2 = Double.parseDouble(number.substring(indexOperatora + 1, number.length()));

        System.out.printf("Výsledok: ");

        switch (znamienko){
            case "+":
                System.out.println(cislo1+cislo2);
                break;

            case "-":
                System.out.println((cislo1-cislo2));
                break;

            case "*":
                System.out.println(cislo1*cislo2);
                break;

            case "/":
                System.out.println(cislo1/cislo2);
                break;
        }
    }



//05.
//      úloha: napíš metódu, ktorá na vstupe bude akceptovať dáta typu LocalTime, ktorý bude reprezentovať čas nástupu do práce. Na výstupe bude výpis, kedy môžeš odísť z práce. Uvažuje nad 8hodinovou pracovnou dobou.
    public static void pracovnyCas(LocalTime localTime){
        System.out.println("Váš príchod do práce: " + localTime.truncatedTo(ChronoUnit.SECONDS));
        System.out.println("Váš predpokladaný odchod z práce: " + localTime.truncatedTo(ChronoUnit.SECONDS).plusHours(8));
    }



//06.
//      úloha: napíš metódu s tým istým názvom ako v úlohe 5. Táto metóda bude mať ale na vstupe dva údaje, jeden bude údaj typu LocalTime o čase nástupu do práce a druhý údaj bude typu int, ktorý reprezentuje dĺžku pracovnej doby. Na výstupe sa vypíše kedy môžeš ísť domov.
    public static void pracovnyCas(LocalTime localTime, int duration){
        System.out.println("Váš príchod do práce: " + localTime.truncatedTo(ChronoUnit.SECONDS));
        System.out.println("Váš predpokladaný odchod z práce: " + localTime.truncatedTo(ChronoUnit.SECONDS).plusHours(duration));
    }


//07.
//      úloha: napíš metódu, ktorej zadáš tvoj dátum narodenia. Na výstupe sa ti vypíše v aké dni budeš mať v budúcnosti mať narodeniny (2019 pondelok, 2020 štvrtok, atď.)
    public static void dniNarodenia(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please type your date of birth in format YYYY-MM-DD: ");
        String datum = scanner.nextLine().substring(4,10);
        StringBuilder sb = new StringBuilder();
        LocalDate date = LocalDate.now();
        sb.append(date.getYear()).append(datum);
        date = LocalDate.parse(sb);

        for(int i = 0; i<6; i++){
            date = date.plusYears(i);
            System.out.println("In " + date.getYear() + " your birthday will be on " + date.getDayOfWeek());
        }

    }
}
