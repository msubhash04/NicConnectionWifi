package com.tcpserver.nic.dwnfail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class InsertTicketsFile {

    public static void main(String [] args){
        String readFilePath = "C://Users//XD48_ADMIN//Desktop//GSRTC_INSRT//Ticket213767.txt";
        String writeFilePath ="C://Users//XD48_ADMIN//Desktop//GSRTC_INSRT//junk_depot_ticket-1.txt";

        String versions="43H";
        String	UID="Quantum";
//    	DepotCode="GJ-GDR-LWD";
        String	DepotCode="GJ-BRD-BDL";

        //	EbtmNo="53192113";
        String EbtmNo="53194420";
        try (BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
            String line="";

            File file = new File(writeFilePath);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            while ((line = reader.readLine()) != null) {

                Insert_Tickets("",line,DepotCode,UID,EbtmNo,writeFilePath,versions);
            }
            System.out.println(line);
        } catch (IOException e) {
            // Handle exceptions, e.g., file not found, read error
            e.printStackTrace();
        }

    }

    public void charElementCount(){
        String str= "aabbbccdddaaaa";

        char[] ch = str.toCharArray();
        List<String>  ls = new ArrayList<String>();

        for(int i=0; i<ch.length-2;i++)
        {
            int count=1;
            char ch1 = ch[i];
            char ch2 = ch[i+1];

            while(ch1 == ch2){
                count++;
                i++;
            }

            ls.add(ch1+":"+count);
        }

        System.out.println("The list is like below");
        System.out.println(ls);
    }


    static String Insert_Tickets(String wbillno, String data, String DepotCode, String UID, String EbtmNo,String writeFilePath,String versions) {
        String Result = "",SQL="";

        if (UID.length() == 0) {
            UID = "0";
        }
        int TicketDataInsertedCount = 0;
        int TicketDataEtmCount = 0;

        String[]NewLinesplit={};
        String[] NewFiledsplit = new String[66];

        try {
            System.out.println("data"+data);
            NewLinesplit = data.split("\n");

            for (int i = 0; i < NewLinesplit.length; i++) {
                String EachTicketData = NewLinesplit[i];

                if(versions.equalsIgnoreCase("43J")||versions.equalsIgnoreCase("43H")||versions.equalsIgnoreCase("43G")||versions.equalsIgnoreCase("43E")||versions.equalsIgnoreCase("43C")||versions.equalsIgnoreCase("43B")) {
//                    System.out.println("versions  :::::inside else if condition:::"+versions);

                    try {
                        int a=2;
                        NewFiledsplit[0]=EachTicketData.substring(0,6);
                        NewFiledsplit[1]=EachTicketData.substring(7,13);
                        NewFiledsplit[2]=EachTicketData.substring(14,20);
                        NewFiledsplit[3]=EachTicketData.substring(21,31);
                        NewFiledsplit[4]=EachTicketData.substring(32,40);
                        NewFiledsplit[5]=EachTicketData.substring(41,47);
                        NewFiledsplit[6]=EachTicketData.substring(48,49);
                        NewFiledsplit[7]=EachTicketData.substring(50,52);
                        NewFiledsplit[8]=EachTicketData.substring(53,55);
                        NewFiledsplit[9]=EachTicketData.substring(56,62);
                        NewFiledsplit[10]=EachTicketData.substring(63,64);
                        NewFiledsplit[11]=EachTicketData.substring(65,68);
                        NewFiledsplit[12]=EachTicketData.substring(69,72);
                        NewFiledsplit[13]=EachTicketData.substring(73,76);
                        NewFiledsplit[14]=EachTicketData.substring(77,80);
                        NewFiledsplit[15]=EachTicketData.substring(81,82);
                        NewFiledsplit[16]=EachTicketData.substring(83,84);
                        NewFiledsplit[17]=EachTicketData.substring(85,96);
                        NewFiledsplit[18]=EachTicketData.substring(97,108);
                        NewFiledsplit[19]=EachTicketData.substring(109,115);
                        NewFiledsplit[20]=EachTicketData.substring(116,122);
                        NewFiledsplit[21]=EachTicketData.substring(123,128);
                        NewFiledsplit[22]=EachTicketData.substring(129,131);
                        NewFiledsplit[23]=EachTicketData.substring(132,138);
                        NewFiledsplit[24]=EachTicketData.substring(139,145);
                        //added =+2  index for  new ticket structure
                        NewFiledsplit[25]=EachTicketData.substring(146,152+a);
                        NewFiledsplit[26]=EachTicketData.substring(153+a,154+a);
                        NewFiledsplit[27]=EachTicketData.substring(155+a,157+a);
                        NewFiledsplit[28]=EachTicketData.substring(158+a,160+a);
                        NewFiledsplit[29]=EachTicketData.substring(161+a,167+a);
                        NewFiledsplit[30]=EachTicketData.substring(168+a,170+a);
                        NewFiledsplit[31]=EachTicketData.substring(171+a,181+a);
                        NewFiledsplit[32]=EachTicketData.substring(182+a,190+a);
                        NewFiledsplit[33]=EachTicketData.substring(191+a,200+a);
                        NewFiledsplit[34]=EachTicketData.substring(201+a,209+a);
                        NewFiledsplit[35]=EachTicketData.substring(210+a,212+a);
                        NewFiledsplit[36]=EachTicketData.substring(213+a,214+a);
                        NewFiledsplit[37]=EachTicketData.substring(215+a,224+a);
                        NewFiledsplit[38]=EachTicketData.substring(225+a,227+a);
                        NewFiledsplit[39]=EachTicketData.substring(228+a,234+a);
                        NewFiledsplit[40]=EachTicketData.substring(235+a,241+a);
                        NewFiledsplit[41]=EachTicketData.substring(242+a,248+a);
                        NewFiledsplit[42]=EachTicketData.substring(249+a,255+a);
                        NewFiledsplit[43]=EachTicketData.substring(256+a,262+a);
                        NewFiledsplit[44]=EachTicketData.substring(263+a,269+a);
                        NewFiledsplit[45]=EachTicketData.substring(270+a,276+a);
                        NewFiledsplit[46]=EachTicketData.substring(277+a,283+a);
                        NewFiledsplit[47]=EachTicketData.substring(284+a,290+a);
                        NewFiledsplit[48]=EachTicketData.substring(291+a,298+a);
                        NewFiledsplit[49]=EachTicketData.substring(299+a,306+a);
                        NewFiledsplit[50]=EachTicketData.substring(307+a,314+a);
                        NewFiledsplit[51]=EachTicketData.substring(315+a,322+a);
                        NewFiledsplit[52]=EachTicketData.substring(323+a,326+a);
                        NewFiledsplit[53]=EachTicketData.substring(327+a,330+a);
                        NewFiledsplit[54]=EachTicketData.substring(331+a,342+a);
                        NewFiledsplit[55]=EachTicketData.substring(343+a,344+a);
                        NewFiledsplit[56]=EachTicketData.substring(345+a,346+a);
                        NewFiledsplit[57]=EachTicketData.substring(347+a,351+a);
                        NewFiledsplit[58]=EachTicketData.substring(352+a,353+a);
                        NewFiledsplit[59]=EachTicketData.substring(354+a,361+a);
                        NewFiledsplit[60]=EachTicketData.substring(362+a,369+a);
                        NewFiledsplit[61]=EachTicketData.substring(370+a,386+a);
                        NewFiledsplit[62]=EachTicketData.substring(387+a,389+a);
                        NewFiledsplit[63]=EachTicketData.substring(390+a,400+a);
                        NewFiledsplit[64]=EachTicketData.substring(401+a,410+a);
                        NewFiledsplit[65]=EachTicketData.substring(420, 422);

                        NewFiledsplit[0]=NewFiledsplit[0].replace(",","");
                        NewFiledsplit[1]=NewFiledsplit[1].replace(",","");
                        NewFiledsplit[2]=NewFiledsplit[2].replace(",","");
                        NewFiledsplit[3]=NewFiledsplit[3].replace(",","");
                        NewFiledsplit[4]=NewFiledsplit[4].replace(",","");
                        NewFiledsplit[5]=NewFiledsplit[5].replace(",","");
                        NewFiledsplit[6]=NewFiledsplit[6].replace(",","");
                        NewFiledsplit[7]=NewFiledsplit[7].replace(",","");
                        NewFiledsplit[8]=NewFiledsplit[8].replace(",","");
                        NewFiledsplit[9]=NewFiledsplit[9].replace(",","");
                        NewFiledsplit[10]=NewFiledsplit[10].replace(",","");
                        NewFiledsplit[11]=NewFiledsplit[11].replace(",","");
                        NewFiledsplit[12]=NewFiledsplit[12].replace(",","");
                        NewFiledsplit[13]=NewFiledsplit[13].replace(",","");
                        NewFiledsplit[14]=NewFiledsplit[14].replace(",","");
                        NewFiledsplit[15]=NewFiledsplit[15].replace(",","");
                        NewFiledsplit[16]=NewFiledsplit[16].replace(",","");
                        NewFiledsplit[17]=NewFiledsplit[17].replace(",","");
                        NewFiledsplit[18]=NewFiledsplit[18].replace(",","");
                        NewFiledsplit[19]=NewFiledsplit[19].replace(",","");
                        NewFiledsplit[20]=NewFiledsplit[20].replace(",","");
                        NewFiledsplit[21]=NewFiledsplit[21].replace(",","");
                        NewFiledsplit[22]=NewFiledsplit[22].replace(",","");
                        NewFiledsplit[23]=NewFiledsplit[23].replace(",","");
                        NewFiledsplit[24]=NewFiledsplit[24].replace(",","");
                        NewFiledsplit[25]=NewFiledsplit[25].replace(",","");
                        NewFiledsplit[26]=NewFiledsplit[26].replace(",","");
                        NewFiledsplit[27]=NewFiledsplit[27].replace(",","");
                        NewFiledsplit[28]=NewFiledsplit[28].replace(",","");
                        NewFiledsplit[29]=NewFiledsplit[29].replace(",","");
                        NewFiledsplit[30]=NewFiledsplit[30].replace(",","");
                        NewFiledsplit[31]=NewFiledsplit[31].replace(",","");
                        NewFiledsplit[32]=NewFiledsplit[32].replace(",","");
                        NewFiledsplit[33]=NewFiledsplit[33].replace(",","");
                        NewFiledsplit[34]=NewFiledsplit[34].replace(",","");
                        NewFiledsplit[35]=NewFiledsplit[35].replace(",","");
                        NewFiledsplit[36]=NewFiledsplit[36].replace(",","");
                        NewFiledsplit[37]=NewFiledsplit[37].replace(",","");
                        NewFiledsplit[38]=NewFiledsplit[38].replace(",","");
                        NewFiledsplit[39]=NewFiledsplit[39].replace(",","");
                        NewFiledsplit[40]=NewFiledsplit[40].replace(",","");
                        NewFiledsplit[41]=NewFiledsplit[41].replace(",","");
                        NewFiledsplit[42]=NewFiledsplit[42].replace(",","");
                        NewFiledsplit[43]=NewFiledsplit[43].replace(",","");
                        NewFiledsplit[44]=NewFiledsplit[44].replace(",","");
                        NewFiledsplit[45]=NewFiledsplit[45].replace(",","");
                        NewFiledsplit[46]=NewFiledsplit[46].replace(",","");
                        NewFiledsplit[47]=NewFiledsplit[47].replace(",","");
                        NewFiledsplit[48]=NewFiledsplit[48].replace(",","");
                        NewFiledsplit[49]=NewFiledsplit[49].replace(",","");
                        NewFiledsplit[50]=NewFiledsplit[50].replace(",","");
                        NewFiledsplit[51]=NewFiledsplit[51].replace(",","");
                        NewFiledsplit[52]=NewFiledsplit[52].replace(",","");
                        NewFiledsplit[53]=NewFiledsplit[53].replace(",","");
                        NewFiledsplit[54]=NewFiledsplit[54].replace(",","");
                        NewFiledsplit[55]=NewFiledsplit[55].replace(",","");
                        NewFiledsplit[56]=NewFiledsplit[56].replace(",","");
                        NewFiledsplit[57]=NewFiledsplit[57].replace(",","");
                        NewFiledsplit[58]=NewFiledsplit[58].replace(",","");
                        NewFiledsplit[59]=NewFiledsplit[59].replace(",","");
                        NewFiledsplit[60]=NewFiledsplit[60].replace(",","");
                        NewFiledsplit[61]=NewFiledsplit[61].replace(",","");
                        NewFiledsplit[62]=NewFiledsplit[62].replace(",","");
                        NewFiledsplit[63]=NewFiledsplit[63].replace(",","");
                        NewFiledsplit[64]=NewFiledsplit[64].replace(",","");
                        NewFiledsplit[65]=NewFiledsplit[65].replace(",","");

//previously from etm we are receving ticket type3 is like 4,5,6 now we are receving 04,05,06
//for andling that situation i have added below case statement
                        String ticket_type_3 ="";
                        if(NewFiledsplit[65].length()>0){
//              System.out.println("inside switch case "+NewFiledsplit[65]);
                            switch (NewFiledsplit[65].trim()){

                                case "01": ticket_type_3="1";
                                    break;
                                case "04": ticket_type_3="4";
                                    break;
                                case "05": ticket_type_3="5";
                                    break;
                                case "06": ticket_type_3="6";
                                    break;
                                default  : ticket_type_3=NewFiledsplit[66];
                            }
                        }

                        SQL = "Insert into ETM_TICKET_DATA  values('" + NewFiledsplit[0].trim() + "','" + NewFiledsplit[1].trim() + "','" + NewFiledsplit[2].trim() + "','" + NewFiledsplit[3].trim() + "',"
                                + "'" + NewFiledsplit[4].trim() + "','" + NewFiledsplit[5].trim() + "','" + NewFiledsplit[6].trim() + "','" + NewFiledsplit[7].trim() + "','" + NewFiledsplit[8].trim() + "',	'" + NewFiledsplit[9].trim() + "',\n"
                                + "'" + NewFiledsplit[10].trim() + "','" + NewFiledsplit[11].trim() + "','" + NewFiledsplit[12].trim() + "','" + NewFiledsplit[13].trim() + "',"
                                + "'" + NewFiledsplit[14].trim() + "','" + NewFiledsplit[15].trim() + "','" + NewFiledsplit[16].trim() + "','" + NewFiledsplit[17].trim() + "',	'" + NewFiledsplit[18].trim() + "' ,'"
                                + NewFiledsplit[21].trim() + "',"
                                + "'" + NewFiledsplit[22].trim() + "','" + NewFiledsplit[23].trim() + "','" + NewFiledsplit[24].trim() + "',	\n"
                                + "'" + NewFiledsplit[25].trim() + "','" + NewFiledsplit[26].trim() + "','" + NewFiledsplit[27].trim() + "','" + NewFiledsplit[28].trim() + "', '" + NewFiledsplit[31].trim() + "',"
                                + "'" + NewFiledsplit[32].trim() + "','" + NewFiledsplit[33].trim() + "','" + NewFiledsplit[34].trim() + "','" + NewFiledsplit[35].trim() + "',"
                                + "'" + NewFiledsplit[36].trim() + "','" + NewFiledsplit[37].trim() + "',\n"
                                + "'" + NewFiledsplit[38].trim() + "','" + NewFiledsplit[39].trim() + "','" + NewFiledsplit[40].trim() + "','" + NewFiledsplit[41].trim() + "',"
                                + "'" + NewFiledsplit[42].trim() + "','" + NewFiledsplit[43].trim() + "','" + NewFiledsplit[44].trim() + "','" + NewFiledsplit[45].trim() + "',"
                                + "'" + NewFiledsplit[46].trim() + "','" + NewFiledsplit[47].trim() + "','" + NewFiledsplit[48].trim() + "','" + NewFiledsplit[49].trim() + "',"
                                + "'" + NewFiledsplit[50].trim() + "','" + NewFiledsplit[51].trim() + "','" + NewFiledsplit[52].trim() + "','" + NewFiledsplit[53].trim() + "','" + NewFiledsplit[54].trim() + "',\n"
                                + "'" + DepotCode + "','" + DateAndTimeCalendarFormate("DateAndTimeNoSpace") + "','" + UID.trim() + "','" + NewFiledsplit[61].trim() + "','" + NewFiledsplit[29].trim() + "','" + NewFiledsplit[30].trim()
                                + "','" + NewFiledsplit[19].trim() + "' ,'" + NewFiledsplit[20].trim() + "','" + NewFiledsplit[55].trim() + "' ,'" + NewFiledsplit[56].trim()
                                + "','" + NewFiledsplit[57].trim() + "' ,'" + NewFiledsplit[58].trim() + "','" + NewFiledsplit[59].trim() + "' ,'" + NewFiledsplit[60].trim()
                                + "' ,'" + NewFiledsplit[62].trim() + "' ,'" + NewFiledsplit[63].trim() + "' ,'" + NewFiledsplit[64].trim() + "' ,'" +ticket_type_3 + "')";
                        System.out.println("SQL   " + SQL);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath,true))) {
                            writer.write(SQL);
                            writer.newLine();
                            System.out.println("SQL written to file.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("Done!");
                        Result = "Y";
                    } catch (Exception e) {
//                        System.out.println(e.toString());
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            // session_applet.flush();
            // session_applet.clear();
        }
        if (data.length() > 200) {
//            System.out.println("TicketDataEtmCount   " + TicketDataEtmCount);
//            System.out.println("TicketDataInsertedCount   " + TicketDataInsertedCount);
            if (TicketDataEtmCount == TicketDataInsertedCount) {
                try {
//                 System.out.println("SQL   " + SQL);
//                 System.out.println("Done!");
                 Result = "Y";
                } catch (Exception e) {
                    Result = "N";
                    System.out.println(e.toString());
                }
            } else {
                Result = "N";
            }
        } else {

            Result = "N";
        }

        return Result;
    }

    public static String DateAndTimeCalendarFormate(String PassingParamer) {
        Calendar ca1 = Calendar.getInstance();
        String DateAndTime = "";
        if (PassingParamer.equals("DateAndTimeDayOfWeek")) {
            DateAndTime = (ca1.get(Calendar.DAY_OF_WEEK) - 1) + " " + leftpaddingzero(ca1.get(Calendar.DATE)) + "." + leftpaddingzero(ca1.get(Calendar.MONTH) + 1) + "." + ca1.get(Calendar.YEAR) + ""
                    + " " + leftpaddingzero(ca1.get(Calendar.HOUR_OF_DAY)) + ":" + leftpaddingzero(ca1.get(Calendar.MINUTE)) + ":" + leftpaddingzero(ca1.get(Calendar.SECOND));
//            System.out.println(DateAndTime);
        } else if (PassingParamer.equals("DateAndTime-Formate")) {
            DateAndTime = leftpaddingzero(ca1.get(Calendar.DATE)) + "-" + leftpaddingzero(ca1.get(Calendar.MONTH) + 1) + "-" + ca1.get(Calendar.YEAR) + ""
                    + " " + leftpaddingzero(ca1.get(Calendar.HOUR_OF_DAY)) + ":" + leftpaddingzero(ca1.get(Calendar.MINUTE)) + ":" + leftpaddingzero(ca1.get(Calendar.SECOND));
//            System.out.println(DateAndTime);
        } else if (PassingParamer.equals("YearAndTime-Formate")) {
            DateAndTime = ca1.get(Calendar.YEAR) + "-" + leftpaddingzero(ca1.get(Calendar.MONTH) + 1) + "-" + leftpaddingzero(ca1.get(Calendar.DATE)) + ""
                    + " " + leftpaddingzero(ca1.get(Calendar.HOUR_OF_DAY)) + ":" + leftpaddingzero(ca1.get(Calendar.MINUTE)) + ":" + leftpaddingzero(ca1.get(Calendar.SECOND));
//            System.out.println(DateAndTime);
        } else if (PassingParamer.equals("DateAndTimeNoSpace")) {
            DateAndTime = leftpaddingzero(ca1.get(Calendar.YEAR)) + "" + leftpaddingzero(ca1.get(Calendar.MONTH) + 1) + "" + String.format("%02d", ca1.get(Calendar.DATE)) + "";
//            System.out.println(DateAndTime);
        }
        return DateAndTime;
    }
    public static  String leftpaddingzero(int number) {
        String PaadingNumber = String.format("%02d", number);
        return PaadingNumber;
    }

}
