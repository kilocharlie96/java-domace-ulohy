package sk.kikocernak.homeworks.citaniedat;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerClass {

/*
1. úloha: Napíš metódu, ktorá bude čítať dáta z konzoly. Teda to čo napíšeš na konzolu a stlačíš enter, to sa vypíše. Čítať dáta bude dovtedy kým nenapíšeš q a nestlačíš enter.

2. úloha: Napíš si triedu Osoba, ktorá bude mať meno a priezvisko. Potom napíš metódu, ktorá si bude z konzoly pýtať zadanie mena a priezviska a na základe údajov z konzoly vytvorí inštanciu Osoby. Teda niečo ako new Osoba(menoZKonzoly, priezviskoZKonzoly)

3. úloha: Napíš metódu, ktorá požiada používateľa o zadanie čísla. Ak zadá číslo vypíš ho na konzolu, ak zadá niečo iné, tak vypíš chybovú hlášku.

4.úloha: napíš metódu, ktorá načíta z konzoly jednoduché matematické operácie a vykoná ich. Napríklad ak napíšem do konzoly 4+5. Tak sa vykoná sčítanie a na výstup sa napíše výsledok 9.

5. úloha: napíš metódu, ktorá na vstupe bude akceptovať dáta typu LocalTime, ktorý bude reprezentovať čas nástupu do práce. Na výstupe bude výpis, kedy môžeš odísť z práce. Uvažuje nad 8hodinovou pracovnou dobou.

6. úloha: napíš metódu s tým istým názvom ako v úlohe 5. Táto metóda bude mať ale na vstupe dva údaje, jeden bude údaj typu LocalTime o čase nástupu do práce a druhý údaj bude typu int, ktorý reprezentuje dĺžku pracovnej doby. Na výstupe sa vypíše kedy môžeš ísť domov.

7. úloha: napíš metódu, ktorej zadáš tvoj dátum narodenia. Na výstupe sa ti vypíše v aké dni budeš mať v budúcnosti mať narodeniny (2019 pondelok, 2020 štvrtok, atď.)

8. úloha: napíš metódu, ktorá vypíše na konzolu či je dnes práve sviatok. Dátumy sviatkov si môžeš pozrieť napríklad tu: http://kalendar.azet.sk/sviatky/. Veľkú noc nemusíš riešiť.
*/

    //01.
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
}
