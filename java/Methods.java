import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Methods {
    public static void main(String[] args) {
        //JavaFx
        //Sort
//        void onSort(ActionEvent event) {
//            String methodName = "get" + cBox.getValue().substring(0, 1).toUpperCase() + cBox.getValue().substring(1);
//            versenyzok.sort(Comparator.comparing(o -> {
//                try {
//                    Method method = Versenyzo.class.getMethod(methodName);
//                    return (Comparable) method.invoke(o);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }));
//
//            onLoad(event);
//        }

        //Display filed names
//        for (Versenyzo versenyzo : versenyzok) {
//            for(Field field: versenyzo.getClass().getDeclaredFields()){
//                cBox.getItems().add(field.getName());
//            }
//            break;
//        }

        //Konzolos
        //Raf
//        ArrayList<Bejelentkezes> bejelentkezesek = new ArrayList<>();
//
//        try {
//            RandomAccessFile raf = new RandomAccessFile("bejelentkezesek.txt", "r");
//            raf.readLine();
//            String sor = raf.readLine();
//            while(sor != null) {
//                String[] adatok = sor.split(";");
//                bejelentkezesek.add(new Bejelentkezes(
//                        adatok[0],
//                        Integer.parseInt(adatok[1]),
//                        LocalTime.parse(adatok[2]),
//                        LocalTime.parse(adatok[3])
//                ));
//                sor = raf.readLine();
//            }
//            raf.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //Db szamlalas Map-el
//        Map<String, Integer> dbBejelentekezes = new HashMap<>();
//        for (Bejelentkezes bejelentkezes : bejelentkezesek) {
//            dbBejelentekezes.put(
//                    bejelentkezes.getId(),
//                    dbBejelentekezes.getOrDefault(bejelentkezes.getId(), 0) + 1
//            );
//        }
//       for(Map.Entry<String, Integer> entry : dbBejelentekezes.entrySet()) {
//        System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
//        }
//    }
    }
}
