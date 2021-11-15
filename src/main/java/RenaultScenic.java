import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class RenaultScenic {
    public static void main(String[] args) {

        //Ustawienie ilości ogłoszeń z wcześniejszych dni
        int yesterDayalertsOlx = 14;   //stan na - 15.11.2021 21:02
        int yesterdayalertsOtomoto = 6;   //stan na - 15.11.2021 21:02


        //olx
        Document olx = null;
        try {
            olx = Jsoup.connect("https://www.olx.pl/motoryzacja/samochody/renault/scenic/?search%5Bfilter_float_price%3Ato%5D=13000&search%5Bfilter_float_year%3Afrom%5D=2004&search%5Bfilter_float_enginesize%3Afrom%5D=1700&search%5Bfilter_float_enginesize%3Ato%5D=2000&search%5Bfilter_enum_petrol%5D%5B0%5D=petrol&search%5Bfilter_float_milage%3Ato%5D=160000&search%5Bfilter_enum_condition%5D%5B0%5D=notdamaged&search%5Border%5D=created_at%3Adesc").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = olx.getElementsByClass("fixed offers breakword redesigned");

        String streamUrl = new String();
        streamUrl = elements.get(0).text().toString();

        String[] strUrlNeutral = streamUrl.split("Samochody osobowe »");

        int ogloszeniaOLX = 0;
        System.out.println("Ogłoszeń na olx: " + strUrlNeutral.length);
        System.out.println("==================================================================================================================================");
        for (int i = 0; i < strUrlNeutral.length; i++) {
            System.out.println(strUrlNeutral[i]);
            ++ogloszeniaOLX;
        }
        System.out.println();


        //Otomoto
        Document otomoto = null;
        try {
            otomoto = Jsoup.connect("https://www.otomoto.pl/osobowe/renault/scenic/od-2004/?search%5Bfilter_float_price%3Ato%5D=13000&search%5Bfilter_enum_generation%5D%5B0%5D=gen-ii-2003-2009-scenic&search%5Bfilter_float_mileage%3Ato%5D=160000&search%5Bfilter_float_engine_capacity%3Afrom%5D=1700&search%5Bfilter_float_engine_capacity%3Ato%5D=2000&search%5Bfilter_enum_fuel_type%5D%5B0%5D=petrol&search%5Bfilter_enum_damaged%5D=0&search%5Border%5D=created_at_first%3Adesc&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bcountry%5D=").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elementsOto = otomoto.getElementsByClass("offers list");
        //Elements iloscOgloszenOto = otomoto.getElementsByClass("hasPromoted section clr");

        String otomotoStream = elementsOto.get(0).text().toString();
        String[] splitOtomoto = otomotoStream.split(" Obserwuj Usuń z obserwowanych ");


        int ogloszeniaOtomoto = 0;
        System.out.println("\nOgłoszenia na otomoto: : " + splitOtomoto.length);
        System.out.println("==================================================================================================================================");
        for (int i = 0; i < splitOtomoto.length; i++) {
            System.out.println(splitOtomoto[i]);
            ++ogloszeniaOtomoto;
        }


        //Podsumowanie OLX
        System.out.println("\n===================");
        System.out.println("Podsumowanie OLX: ||");
        System.out.println("===================");
        if (ogloszeniaOLX > yesterDayalertsOlx) {
            System.out.println("<<< Ogłoszeń przybyło o " + (ogloszeniaOLX - yesterDayalertsOlx) + " >>>\n");
        } else if (ogloszeniaOLX < yesterDayalertsOlx) {
            System.out.println("-= Ogłoszeń jest mniej o " + (yesterDayalertsOlx - ogloszeniaOLX) + " =-\n");
        } else {
            System.out.println("-= Ogłoszeń jest tyle samo =-\n");
        }

        //Podsumowanie Otomoto
        System.out.println("=======================");
        System.out.println("Podsumowanie OTOMOTO: ||");
        System.out.println("=======================");
        if (ogloszeniaOtomoto > yesterdayalertsOtomoto) {
            System.out.println("<<< Ogłoszeń przybyło o " + (ogloszeniaOtomoto - yesterdayalertsOtomoto) + " >>>\n");
        } else if (ogloszeniaOtomoto < yesterdayalertsOtomoto) {
            System.out.println("-= Ogłoszeń jest mniej o " + (yesterdayalertsOtomoto - ogloszeniaOtomoto) + " =-\n");
        } else {
            System.out.println("-= Ogłoszeń jest tyle samo =-\n");
        }
    }
}



