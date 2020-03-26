import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.lang.model.SourceVersion;
import javax.xml.bind.SchemaOutputResolver;

public class BeerSong {
    public static void main(String[] args) {
        int beerNum = 9;
        String word = "бутылок (бутылки)" ;
        while (beerNum > 0){
            beerNum = beerNum - 1 ;

            if (beerNum == 1) {
               word = "бутылка"; // в единственном числе
            } else
            if (beerNum > 0) {
                //System.out.println(beerNum + " " + word + "пива на стене" );
                System.out.println(beerNum + " " + word + " пива на стене" );
                //System.out.println(beerNum + " " + word + " пива." );
                System.out.println("Возьми одну.");
                System.out.println("Пусти по кругу.");
            } else {
                System.out.println(" Нет бутылок пива на стене" );
            }
        }
    }
}
