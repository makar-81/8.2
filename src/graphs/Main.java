package graphs;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //try {
        String temp;

        //FileReader fr = new FileReader("./test1.txt");
        //FileWriter wr = new FileWriter("./test2.txt");

        //BufferedWriter  bw = new BufferedWriter(wr);
        //BufferedReader br = new BufferedReader(fr);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            List<List<String>> final_store = new ArrayList<>();
            List<List<String>> begin_store = new ArrayList<>();
            int line_num = 0;

            try {
            while ((temp = br.readLine()) != null) {
                while (!temp.isEmpty()) {
                    int pos1 = temp.indexOf("\t");
                    int pos2 = temp.indexOf("\t",pos1+1);
                    ArrayList<String> line = new ArrayList<String>();
                    if (pos1 > 0 && pos2>0) {
                            line.add(temp.substring(0,pos1));
                            line.add(temp.substring(pos1+1,pos2));
                            line.add(temp.substring(pos2+1,temp.length()));
                            begin_store.add(line);
                        }
                    temp="";
                    }
                }
                for (int i=0;i<begin_store.size();i++) {
                    if (!(begin_store.get(i)).get(2).equals("{}")) {
                        final_store.add(begin_store.get(i));

                        String temp_string=(begin_store.get(i)).get(2).substring(1,(begin_store.get(i)).get(2).length()-1);

                        if ((begin_store.get(i)).get(2).contains(",")) {
                            while (!temp_string.isEmpty()) {
                                List<String> temp_list = new ArrayList<>();
                                int pos3 = (temp_string.indexOf(","));
                                // первая строка и последний узел
                                if (pos3 < 0 && i == 0){
                                    temp_list.add(temp_string);
                                    String s = "";
                                    if (!(begin_store.get(i)).get(1).equals("INF")){
                                        Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                        s = sum.toString();
                                    }
                                    else s = "INF";
                                    temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                    temp_list.add("{}");
                                    temp_string="";
                                    final_store.add(temp_list);

                                }
                                // первая строка и непоследний узел
                                else if (pos3 > 0 && i == 0) {
                                    temp_list.add(temp_string.substring(0,pos3));
                                    String s = "";
                                    if (!(begin_store.get(i)).get(1).equals("INF")){
                                        Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                        s = sum.toString();
                                    }
                                    else s = "INF";
                                    temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                    temp_list.add("{}");
                                    temp_string = temp_string.substring(pos3+1,temp_string.length());
                                    final_store.add(temp_list);

                                }
                                // не первая строка и последний узел
                                if (pos3 < 0 && i > 0){
                                    temp_list.add(temp_string);
                                    String s = "";
                                    if (!(begin_store.get(i)).get(1).equals("INF")){
                                        Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                        s = sum.toString();
                                    }
                                    else s = "INF";
                                    temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                    temp_list.add("{}");
                                    final_store.add(temp_list);
                                    temp_string="";
                                }

                                else if (pos3 > 0 && i > 0) {
                                    temp_list.add(temp_string.substring(0,pos3));
                                    String s = "";
                                    if (!(begin_store.get(i)).get(1).equals("INF")){
                                        Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                        s = sum.toString();
                                    }
                                    else s = "INF";
                                    temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                    temp_list.add("{}");
                                    final_store.add(temp_list);
                                    temp_string = temp_string.substring(pos3+1,temp_string.length());
                                }

                            }


                        } else {
                            List<String> temp_list = new ArrayList<>();
                            if (i == 0){
                                temp_list.add(temp_string);
                                String s = "";
                                if (!(begin_store.get(i)).get(1).equals("INF")){
                                    Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                    s = sum.toString();
                                }
                                else s = "INF";
                                temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                temp_list.add("{}");
                                final_store.add(temp_list);
                            }
                            else {

                                temp_list.add(temp_string);
                                String s = "";
                                if (!(begin_store.get(i)).get(1).equals("INF")){
                                    Integer sum = Integer.parseInt((begin_store.get(i)).get(1)) + 1 ;
                                    s = sum.toString();
                                }
                                else s = "INF";
                                temp_list.add(s); // вставляем текущее расстояние + 1, если не INF предыдущее
                                temp_list.add("{}");
                                final_store.add(temp_list);
                            }

                        }
                    } else final_store.add(begin_store.get(i));
                }

                for (int j = 0; j< final_store.size();j++){
                    //System.out.println((final_store.get(j)).get(0) + "\t" + (final_store.get(j)).get(1) + "\t" + (final_store.get(j)).get(2) + "\n");
                    bw.write((final_store.get(j)).get(0) + "\t" + (final_store.get(j)).get(1) + "\t" + (final_store.get(j)).get(2) + "\n");
                    bw.flush();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
}

