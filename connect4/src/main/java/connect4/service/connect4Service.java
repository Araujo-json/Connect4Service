package connect4.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class connect4Service {

    static List<connect4WinningCombo> list = new ArrayList<>();
    static {
        loadTest();
    }
    public static void loadTest(){
        try {
            /*var file = connect4Service.class.getClassLoader().getResource("connect4Combinations.txt").toURI();
            Path path = Paths.get(file);
            String[] lines = Files.readAllLines(path).toArray(String[]::new);*/
            var x= getCSV();
            for (String row: x) {
                int w1,w2,w3,w4;
                String[] column = row.split(",");
                w1 = Integer.parseInt(column[0]);
                w2 = Integer.parseInt(column[1]);
                w3 = Integer.parseInt(column[2]);
                w4 = Integer.parseInt(column[3]);
                //System.out.println(w1);
                connect4WinningCombo statues = new connect4WinningCombo(w1,w2,w3,w4);

                list.add(statues);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static List<String> getCSV() {
        try (InputStream inputStream = connect4Service.class.getResourceAsStream("/connect4Combinations.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> contents = reader.lines()
                    .collect(Collectors.toList());

            return contents;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static connect4Status getStatus(String moves){
        char[] allmoves = moves.toCharArray();
        connect4Status status = new connect4Status(false, new int[0],"?");

        for (connect4WinningCombo wc: list) {
            if (allmoves[wc.w1] == allmoves[wc.w2] && allmoves[wc.w2] == allmoves[wc.w3] && allmoves[wc.w3] == allmoves[wc.w4] && allmoves[wc.w1] != '?'){
                status = new connect4Status(true,new int[]{wc.w1, wc.w2, wc.w3, wc.w4}, allmoves[wc.w1] + "");
                break;
            }
        }
        return status;
    }
}
