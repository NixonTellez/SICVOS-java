/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguaje.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 10 Spring Creators
 */
@FacesConverter("serviceEnglish")
public class ServiciosConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String english = "";
        if (o != null){
            english = (String) o;
            switch(english){
                case("Balanceo en posición de superman"):
                    english = "Swinging in superman position";
                break;
                
                case("Sentadilla trasera con peso detrás de la nuca"):
                    english = "Back squat with weight behind the neck";
                break;
                
                case("Press de banca"):
                    english = "Bench press";
                break;
                
                case("Salto al cajón"):
                    english = "Jump to the drawer";
                break;
                    
                case("Levanta un peso del suelo hasta la extensión completa de cadera"):
                    english = "Lift a weight off the ground to full hip extension";
                break;
                    
                case("Dos vueltas de la comba en un salto"):
                    english = "Two rounds of rope in one jump";
                break;
                
                case("Sentadilla Frontal con el peso por delante"):
                    english = "Front Squat with weight forward";
                break;
                
                case("Balanceo en posición de hollow"):
                    english = "Rocking in hollow position";
                break;
                
                case("Sentadilla con peso por encima de la cabeza"):
                    english = "Overhead weight squat";
                break;
                    
                case("Membresia caducada"):
                    english = "Membership expired";
                break;
                
                case("Por favor renueve su membresia"):
                    english = "Please renew your membership";
                break;
                
                case("DIA"):
                    english = "DAY";
                break;
                
                case("QUINCENAL "):
                    english = "BIWEEKLY";
                break;
                
                case("QUINCENAL"):
                    english = "BIWEEKLY";
                break;
                
                case("MENSUAL"):
                    english = "MONTHLY";
                break;
                
                case("SUGERENCIAS"):
                    english = "SUGGESTIONS";
                break;
                
                case("RECLAMOS"):
                    english = "CLAIMS";
                break;
                
                case("QUEJAS"):
                    english = "COMPLAINTS";
                break;
                
                case("PREGUNTAS"):
                    english = "QUESTIONS";
                break;
                
                case("ANUAL"):
                    english = "ANNUAL";
                break;
                    
                case("SEMESTRAL"):
                    english = "BIANNUAL";
                break;
                
                case("TRIMESTRAL"):
                    english = "QUARTERLY";
                break;
                
                case("1 días restantes"):
                    english = "1 days remaining";
                break;
                
                case("2 días restantes"):
                    english = "2 days remaining";
                break;
                
                case("3 días restantes"):
                    english = "3 days remaining";
                break;
                
                case("4 días restantes"):
                    english = "4 days remaining";
                break;
                
                case("5 días restantes"):
                    english = "5 days remaining";
                break;
                
                case("6 días restantes"):
                    english = "6 days remaining";
                break;
                
                case("7 días restantes"):
                    english = "7 days remaining";
                break;
                
                case("8 días restantes"):
                    english = "8 days remaining";
                break;
                
                case("9 días restantes"):
                    english = "9 days remaining";
                break;
                
                case("10 días restantes"):
                    english = "10 days remaining";
                break;
                
                case("11 días restantes"):
                    english = "11 days remaining";
                break;
                
                case("12 días restantes"):
                    english = "12 days remaining";
                break;
                
                case("13 días restantes"):
                    english = "13 days remaining";
                break;
                
                case("14 días restantes"):
                    english = "14 days remaining";
                break;
                
                case("15 días restantes"):
                    english = "15 days remaining";
                break;
                
                case("16 días restantes"):
                    english = "16 days remaining";
                break;
                
                case("17 días restantes"):
                    english = "17 days remaining";
                break;
                
                case("18 días restantes"):
                    english = "18 days remaining";
                break;
                
                case("19 días restantes"):
                    english = "19 days remaining";
                break;
                
                case("20 días restantes"):
                    english = "20 days remaining";
                break;
                
                case("21 días restantes"):
                    english = "21 days remaining";
                break;
                
                case("22 días restantes"):
                    english = "22 days remaining";
                break;
                
                case("23 días restantes"):
                    english = "23 days remaining";
                break;
                
                case("24 días restantes"):
                    english = "24 days remaining";
                break;
                
                case("25 días restantes"):
                    english = "25 days remaining";
                break;
                
                case("26 días restantes"):
                    english = "26 days remaining";
                break;
                
                case("27 días restantes"):
                    english = "27 days remaining";
                break;
                
                case("28 días restantes"):
                    english = "28 days remaining";
                break;
                
                case("29 días restantes"):
                    english = "29 days remaining";
                break;
                
                case("30 días restantes"):
                    english = "30 days remaining";
                break;
                
                case("31 días restantes"):
                    english = "31 days remaining";
                break;
                
                case("32 días restantes"):
                    english = "32 days remaining";
                break;
                
                case("33 días restantes"):
                    english = "33 days remaining";
                break;
                
                case("34 días restantes"):
                    english = "34 days remaining";
                break;
                
                case("35 días restantes"):
                    english = "35 days remaining";
                break;
                
                case("36 días restantes"):
                    english = "36 days remaining";
                break;
                
                case("37 días restantes"):
                    english = "37 days remaining";
                break;
                
                case("38 días restantes"):
                    english = "38 days remaining";
                break;
                
                case("39 días restantes"):
                    english = "39 days remaining";
                break;
                
                case("40 días restantes"):
                    english = "40 days remaining";
                break;
                
                case("41 días restantes"):
                    english = "41 days remaining";
                break;
                
                case("42 días restantes"):
                    english = "42 days remaining";
                break;
                
                case("43 días restantes"):
                    english = "43 days remaining";
                break;
                
                case("44 días restantes"):
                    english = "44 days remaining";
                break;
                
                case("45 días restantes"):
                    english = "45 days remaining";
                break;
                
                case("46 días restantes"):
                    english = "46 days remaining";
                break;
                
                case("47 días restantes"):
                    english = "47 days remaining";
                break;
                
                case("48 días restantes"):
                    english = "48 days remaining";
                break;
                
                case("49 días restantes"):
                    english = "49 days remaining";
                break;
                
                case("50 días restantes"):
                    english = "50 days remaining";
                break;
                
                case("51 días restantes"):
                    english = "51 days remaining";
                break;
                
                case("52 días restantes"):
                    english = "52 days remaining";
                break;
                
                case("53 días restantes"):
                    english = "53 days remaining";
                break;
                
                case("54 días restantes"):
                    english = "54 days remaining";
                break;
                
                case("55 días restantes"):
                    english = "55 days remaining";
                break;
                
                case("56 días restantes"):
                    english = "56 days remaining";
                break;
                
                case("57 días restantes"):
                    english = "57 days remaining";
                break;
                
                case("58 días restantes"):
                    english = "58 days remaining";
                break;
                
                case("59 días restantes"):
                    english = "59 days remaining";
                break;
                
                case("60 días restantes"):
                    english = "60 days remaining";
                break;
                
                case("61 días restantes"):
                    english = "61 days remaining";
                break;
                
                case("62 días restantes"):
                    english = "62 days remaining";
                break;
                
                case("63 días restantes"):
                    english = "63 days remaining";
                break;
                
                case("64 días restantes"):
                    english = "64 days remaining";
                break;
                
                case("65 días restantes"):
                    english = "65 days remaining";
                break;
                
                case("66 días restantes"):
                    english = "66 days remaining";
                break;
                
                case("67 días restantes"):
                    english = "67 days remaining";
                break;
                
                case("68 días restantes"):
                    english = "68 days remaining";
                break;
                
                case("69 días restantes"):
                    english = "69 days remaining";
                break;
                
                case("70 días restantes"):
                    english = "70 days remaining";
                break;
                
                case("71 días restantes"):
                    english = "71 days remaining";
                break;
                
                case("72 días restantes"):
                    english = "72 days remaining";
                break;
                
                case("73 días restantes"):
                    english = "73 days remaining";
                break;
                
                case("74 días restantes"):
                    english = "74 days remaining";
                break;
                
                case("75 días restantes"):
                    english = "75 days remaining";
                break;
                
                case("76 días restantes"):
                    english = "76 days remaining";
                break;
                
                case("77 días restantes"):
                    english = "77 days remaining";
                break;
                
                case("78 días restantes"):
                    english = "78 days remaining";
                break;
                
                case("79 días restantes"):
                    english = "79 days remaining";
                break;
                
                case("80 días restantes"):
                    english = "80 days remaining";
                break;
                
                case("81 días restantes"):
                    english = "81 days remaining";
                break;
                
                case("82 días restantes"):
                    english = "82 days remaining";
                break;
                
                case("83 días restantes"):
                    english = "83 days remaining";
                break;
                
                case("84 días restantes"):
                    english = "84 days remaining";
                break;
                
                case("85 días restantes"):
                    english = "85 days remaining";
                break;
                
                case("86 días restantes"):
                    english = "86 days remaining";
                break;
                
                case("87 días restantes"):
                    english = "87 days remaining";
                break;
                
                case("88 días restantes"):
                    english = "88 days remaining";
                break;
                
                case("89 días restantes"):
                    english = "89 days remaining";
                break;
                
                case("90 días restantes"):
                    english = "90 days remaining";
                break;
                
                case("91 días restantes"):
                    english = "91 days remaining";
                break;
                
                case("92 días restantes"):
                    english = "92 days remaining";
                break;
                
                case("93 días restantes"):
                    english = "93 days remaining";
                break;
                
                case("94 días restantes"):
                    english = "94 days remaining";
                break;
                
                case("95 días restantes"):
                    english = "95 days remaining";
                break;
                
                case("96 días restantes"):
                    english = "96 days remaining";
                break;
                
                case("97 días restantes"):
                    english = "97 days remaining";
                break;
                
                case("98 días restantes"):
                    english = "98 days remaining";
                break;
                
                case("99 días restantes"):
                    english = "99 days remaining";
                break;
                
                case("100 días restantes"):
                    english = "100 days remaining";
                break;
                
                case("101 días restantes"):
                    english = "101 days remaining";
                break;
                
                case("102 días restantes"):
                    english = "102 days remaining";
                break;
                
                case("103 días restantes"):
                    english = "103 days remaining";
                break;
                
                case("104 días restantes"):
                    english = "104 days remaining";
                break;
                
                case("105 días restantes"):
                    english = "105 days remaining";
                break;
                
                case("106 días restantes"):
                    english = "106 days remaining";
                break;
                
                case("107 días restantes"):
                    english = "107 days remaining";
                break;
                
                case("108 días restantes"):
                    english = "108 days remaining";
                break;
                
                case("109 días restantes"):
                    english = "109 days remaining";
                break;
                
                case("110 días restantes"):
                    english = "110 days remaining";
                break;
                
                case("111 días restantes"):
                    english = "111 days remaining";
                break;
                
                case("112 días restantes"):
                    english = "112 days remaining";
                break;
                
                case("113 días restantes"):
                    english = "113 days remaining";
                break;
                
                case("114 días restantes"):
                    english = "114 days remaining";
                break;
                
                case("115 días restantes"):
                    english = "115 days remaining";
                break;
                
                case("116 días restantes"):
                    english = "116 days remaining";
                break;
                
                case("117 días restantes"):
                    english = "117 days remaining";
                break;
                
                case("118 días restantes"):
                    english = "118 days remaining";
                break;
                
                case("119 días restantes"):
                    english = "119 days remaining";
                break;
                
                case("120 días restantes"):
                    english = "120 days remaining";
                break;
                
                case("121 días restantes"):
                    english = "121 days remaining";
                break;
                
                case("122 días restantes"):
                    english = "122 days remaining";
                break;
                
                case("123 días restantes"):
                    english = "123 days remaining";
                break;
                
                case("124 días restantes"):
                    english = "124 days remaining";
                break;
                
                case("125 días restantes"):
                    english = "125 days remaining";
                break;
                
                case("126 días restantes"):
                    english = "126 days remaining";
                break;
                
                case("127 días restantes"):
                    english = "127 days remaining";
                break;
                
                case("128 días restantes"):
                    english = "128 days remaining";
                break;
                
                case("129 días restantes"):
                    english = "129 days remaining";
                break;
                
                case("130 días restantes"):
                    english = "130 days remaining";
                break;
                
                case("131 días restantes"):
                    english = "131 days remaining";
                break;
                
                case("132 días restantes"):
                    english = "132 days remaining";
                break;
                
                case("133 días restantes"):
                    english = "133 days remaining";
                break;
                
                case("134 días restantes"):
                    english = "134 days remaining";
                break;
                
                case("135 días restantes"):
                    english = "135 days remaining";
                break;
                
                case("136 días restantes"):
                    english = "136 days remaining";
                break;
                
                case("137 días restantes"):
                    english = "137 days remaining";
                break;
                
                case("138 días restantes"):
                    english = "138 days remaining";
                break;
                
                case("139 días restantes"):
                    english = "139 days remaining";
                break;
                
                case("140 días restantes"):
                    english = "140 days remaining";
                break;
                
                case("141 días restantes"):
                    english = "141 days remaining";
                break;
                
                case("142 días restantes"):
                    english = "142 days remaining";
                break;
                
                case("143 días restantes"):
                    english = "143 days remaining";
                break;
                
                case("144 días restantes"):
                    english = "144 days remaining";
                break;
                
                case("145 días restantes"):
                    english = "145 days remaining";
                break;
                
                case("146 días restantes"):
                    english = "146 days remaining";
                break;
                
                case("147 días restantes"):
                    english = "147 days remaining";
                break;
                
                case("148 días restantes"):
                    english = "148 days remaining";
                break;
                
                case("149 días restantes"):
                    english = "149 days remaining";
                break;
                
                case("150 días restantes"):
                    english = "150 days remaining";
                break;
                
                case("151 días restantes"):
                    english = "151 days remaining";
                break;
                
                case("152 días restantes"):
                    english = "152 days remaining";
                break;
                
                case("153 días restantes"):
                    english = "153 days remaining";
                break;
                
                case("154 días restantes"):
                    english = "154 days remaining";
                break;
                
                case("155 días restantes"):
                    english = "155 days remaining";
                break;
                
                case("156 días restantes"):
                    english = "156 days remaining";
                break;
                
                case("157 días restantes"):
                    english = "157 days remaining";
                break;
                
                case("158 días restantes"):
                    english = "158 days remaining";
                break;
                
                case("159 días restantes"):
                    english = "159 days remaining";
                break;
                
                case("160 días restantes"):
                    english = "160 days remaining";
                break;
                
                case("161 días restantes"):
                    english = "161 days remaining";
                break;
                
                case("162 días restantes"):
                    english = "162 days remaining";
                break;
                
                case("163 días restantes"):
                    english = "163 days remaining";
                break;
                
                case("164 días restantes"):
                    english = "164 days remaining";
                break;
                
                case("165 días restantes"):
                    english = "165 days remaining";
                break;
                
                case("166 días restantes"):
                    english = "166 days remaining";
                break;
                
                case("167 días restantes"):
                    english = "167 days remaining";
                break;
                
                case("168 días restantes"):
                    english = "168 days remaining";
                break;
                
                case("169 días restantes"):
                    english = "169 days remaining";
                break;
                
                case("170 días restantes"):
                    english = "170 days remaining";
                break;
                
                case("171 días restantes"):
                    english = "171 days remaining";
                break;
                
                case("172 días restantes"):
                    english = "172 days remaining";
                break;
                
                case("173 días restantes"):
                    english = "173 days remaining";
                break;
                
                case("174 días restantes"):
                    english = "174 days remaining";
                break;
                
                case("175 días restantes"):
                    english = "175 days remaining";
                break;
                
                case("176 días restantes"):
                    english = "176 days remaining";
                break;
                
                case("177 días restantes"):
                    english = "177 days remaining";
                break;
                
                case("178 días restantes"):
                    english = "178 days remaining";
                break;
                
                case("179 días restantes"):
                    english = "179 days remaining";
                break;
                
                case("180 días restantes"):
                    english = "180 days remaining";
                break;
                
                case("181 días restantes"):
                    english = "181 days remaining";
                break;
                
                case("182 días restantes"):
                    english = "182 days remaining";
                break;
                
                case("183 días restantes"):
                    english = "183 days remaining";
                break;
                
                case("184 días restantes"):
                    english = "184 days remaining";
                break;
                
                case("185 días restantes"):
                    english = "185 days remaining";
                break;
                
                case("186 días restantes"):
                    english = "186 days remaining";
                break;
                
                case("187 días restantes"):
                    english = "187 days remaining";
                break;
                
                case("188 días restantes"):
                    english = "188 days remaining";
                break;
                
                case("189 días restantes"):
                    english = "189 days remaining";
                break;
                
                case("190 días restantes"):
                    english = "190 days remaining";
                break;
                
                case("191 días restantes"):
                    english = "191 days remaining";
                break;
                
                case("192 días restantes"):
                    english = "192 days remaining";
                break;
                
                case("193 días restantes"):
                    english = "193 days remaining";
                break;
                
                case("194 días restantes"):
                    english = "194 days remaining";
                break;
                
                case("195 días restantes"):
                    english = "195 days remaining";
                break;
                
                case("196 días restantes"):
                    english = "196 days remaining";
                break;
                
                case("197 días restantes"):
                    english = "197 days remaining";
                break;
                
                case("198 días restantes"):
                    english = "198 days remaining";
                break;
                
                case("199 días restantes"):
                    english = "199 days remaining";
                break;
                
                case("200 días restantes"):
                    english = "200 days remaining";
                break;
                
                case("201 días restantes"):
                    english = "201 days remaining";
                break;
                
                case("202 días restantes"):
                    english = "202 days remaining";
                break;
                
                case("203 días restantes"):
                    english = "203 days remaining";
                break;
                
                case("204 días restantes"):
                    english = "204 days remaining";
                break;
                
                case("205 días restantes"):
                    english = "205 days remaining";
                break;
                
                case("206 días restantes"):
                    english = "206 days remaining";
                break;
                
                case("207 días restantes"):
                    english = "207 days remaining";
                break;
                
                case("208 días restantes"):
                    english = "208 days remaining";
                break;
                
                case("209 días restantes"):
                    english = "209 days remaining";
                break;
                
                case("210 días restantes"):
                    english = "210 days remaining";
                break;
                
                case("211 días restantes"):
                    english = "211 days remaining";
                break;
                
                case("212 días restantes"):
                    english = "212 days remaining";
                break;
                
                case("213 días restantes"):
                    english = "213 days remaining";
                break;
                
                case("214 días restantes"):
                    english = "214 days remaining";
                break;
                
                case("215 días restantes"):
                    english = "215 days remaining";
                break;
                
                case("216 días restantes"):
                    english = "216 days remaining";
                break;
                
                case("217 días restantes"):
                    english = "217 days remaining";
                break;
                
                case("218 días restantes"):
                    english = "218 days remaining";
                break;
                
                case("219 días restantes"):
                    english = "219 days remaining";
                break;
                
                case("220 días restantes"):
                    english = "220 days remaining";
                break;
                
                case("221 días restantes"):
                    english = "221 days remaining";
                break;
                
                case("222 días restantes"):
                    english = "222 days remaining";
                break;
                
                case("223 días restantes"):
                    english = "223 days remaining";
                break;
                
                case("224 días restantes"):
                    english = "224 days remaining";
                break;
                
                case("225 días restantes"):
                    english = "225 days remaining";
                break;
                
                case("226 días restantes"):
                    english = "226 days remaining";
                break;
                
                case("227 días restantes"):
                    english = "227 days remaining";
                break;
                
                case("228 días restantes"):
                    english = "228 days remaining";
                break;
                
                case("229 días restantes"):
                    english = "229 days remaining";
                break;
                
                case("230 días restantes"):
                    english = "230 days remaining";
                break;
                
                case("231 días restantes"):
                    english = "231 days remaining";
                break;
                
                case("232 días restantes"):
                    english = "232 days remaining";
                break;
                
                case("233 días restantes"):
                    english = "233 days remaining";
                break;
                
                case("234 días restantes"):
                    english = "234 days remaining";
                break;
                
                case("235 días restantes"):
                    english = "235 days remaining";
                break;
                
                case("236 días restantes"):
                    english = "236 days remaining";
                break;
                
                case("237 días restantes"):
                    english = "237 days remaining";
                break;
                
                case("238 días restantes"):
                    english = "238 days remaining";
                break;
                
                case("239 días restantes"):
                    english = "239 days remaining";
                break;
                
                case("240 días restantes"):
                    english = "240 days remaining";
                break;
                
                case("241 días restantes"):
                    english = "241 days remaining";
                break;
                
                case("242 días restantes"):
                    english = "242 days remaining";
                break;
                
                case("243 días restantes"):
                    english = "243 days remaining";
                break;
                
                case("244 días restantes"):
                    english = "244 days remaining";
                break;
                
                case("245 días restantes"):
                    english = "245 days remaining";
                break;
                
                case("246 días restantes"):
                    english = "246 days remaining";
                break;
                
                case("247 días restantes"):
                    english = "247 days remaining";
                break;
                
                case("248 días restantes"):
                    english = "248 days remaining";
                break;
                
                case("249 días restantes"):
                    english = "249 days remaining";
                break;
                
                case("250 días restantes"):
                    english = "250 days remaining";
                break;
                
                case("251 días restantes"):
                    english = "251 days remaining";
                break;
                
                case("252 días restantes"):
                    english = "252 days remaining";
                break;
                
                case("253 días restantes"):
                    english = "253 days remaining";
                break;
                
                case("254 días restantes"):
                    english = "254 days remaining";
                break;
                
                case("255 días restantes"):
                    english = "255 days remaining";
                break;
                
                case("256 días restantes"):
                    english = "256 days remaining";
                break;
                
                case("257 días restantes"):
                    english = "257 days remaining";
                break;
                
                case("258 días restantes"):
                    english = "258 days remaining";
                break;
                
                case("259 días restantes"):
                    english = "259 days remaining";
                break;
                
                case("260 días restantes"):
                    english = "260 days remaining";
                break;
                
                case("261 días restantes"):
                    english = "261 days remaining";
                break;
                
                case("262 días restantes"):
                    english = "262 days remaining";
                break;
                
                case("263 días restantes"):
                    english = "263 days remaining";
                break;
                
                case("264 días restantes"):
                    english = "264 days remaining";
                break;
                
                case("265 días restantes"):
                    english = "265 days remaining";
                break;
                
                case("266 días restantes"):
                    english = "266 days remaining";
                break;
                
                case("267 días restantes"):
                    english = "267 days remaining";
                break;
                
                case("268 días restantes"):
                    english = "268 days remaining";
                break;
                
                case("269 días restantes"):
                    english = "269 days remaining";
                break;
                
                case("270 días restantes"):
                    english = "270 days remaining";
                break;
                
                case("271 días restantes"):
                    english = "271 days remaining";
                break;
                
                case("272 días restantes"):
                    english = "272 days remaining";
                break;
                
                case("273 días restantes"):
                    english = "273 days remaining";
                break;
                
                case("274 días restantes"):
                    english = "274 days remaining";
                break;
                
                case("275 días restantes"):
                    english = "275 days remaining";
                break;
                
                case("276 días restantes"):
                    english = "276 days remaining";
                break;
                
                case("277 días restantes"):
                    english = "277 days remaining";
                break;
                
                case("278 días restantes"):
                    english = "278 days remaining";
                break;
                
                case("279 días restantes"):
                    english = "279 days remaining";
                break;
                
                case("280 días restantes"):
                    english = "280 days remaining";
                break;
                
                case("281 días restantes"):
                    english = "281 days remaining";
                break;
                
                case("282 días restantes"):
                    english = "282 days remaining";
                break;
                
                case("283 días restantes"):
                    english = "283 days remaining";
                break;
                
                case("284 días restantes"):
                    english = "284 days remaining";
                break;
                
                case("285 días restantes"):
                    english = "285 days remaining";
                break;
                
                case("286 días restantes"):
                    english = "286 days remaining";
                break;
                
                case("287 días restantes"):
                    english = "287 days remaining";
                break;
                
                case("288 días restantes"):
                    english = "288 days remaining";
                break;
                
                case("289 días restantes"):
                    english = "289 days remaining";
                break;
                
                case("290 días restantes"):
                    english = "290 days remaining";
                break;
                
                case("291 días restantes"):
                    english = "291 days remaining";
                break;
                
                case("292 días restantes"):
                    english = "292 days remaining";
                break;
                
                case("293 días restantes"):
                    english = "293 days remaining";
                break;
                
                case("294 días restantes"):
                    english = "294 days remaining";
                break;
                
                case("295 días restantes"):
                    english = "295 days remaining";
                break;
                
                case("296 días restantes"):
                    english = "296 days remaining";
                break;
                
                case("297 días restantes"):
                    english = "297 days remaining";
                break;
                
                case("298 días restantes"):
                    english = "298 days remaining";
                break;
                
                case("299 días restantes"):
                    english = "299 days remaining";
                break;
                
                case("300 días restantes"):
                    english = "300 days remaining";
                break;
                
                case("301 días restantes"):
                    english = "301 days remaining";
                break;
                
                case("302 días restantes"):
                    english = "302 days remaining";
                break;
                
                case("303 días restantes"):
                    english = "303 days remaining";
                break;
                
                case("304 días restantes"):
                    english = "304 days remaining";
                break;
                
                case("305 días restantes"):
                    english = "305 days remaining";
                break;
                
                case("306 días restantes"):
                    english = "306 days remaining";
                break;
                
                case("307 días restantes"):
                    english = "307 days remaining";
                break;
                
                case("308 días restantes"):
                    english = "308 days remaining";
                break;
                
                case("309 días restantes"):
                    english = "309 days remaining";
                break;
                
                case("310 días restantes"):
                    english = "310 days remaining";
                break;
                
                case("311 días restantes"):
                    english = "311 days remaining";
                break;
                
                case("312 días restantes"):
                    english = "312 days remaining";
                break;
                
                case("313 días restantes"):
                    english = "313 days remaining";
                break;
                
                case("314 días restantes"):
                    english = "314 days remaining";
                break;
                
                case("315 días restantes"):
                    english = "315 days remaining";
                break;
                
                case("316 días restantes"):
                    english = "316 days remaining";
                break;
                
                case("317 días restantes"):
                    english = "317 days remaining";
                break;
                
                case("318 días restantes"):
                    english = "318 days remaining";
                break;
                
                case("319 días restantes"):
                    english = "319 days remaining";
                break;
                
                case("320 días restantes"):
                    english = "320 days remaining";
                break;
                
                case("321 días restantes"):
                    english = "321 days remaining";
                break;
                
                case("322 días restantes"):
                    english = "322 days remaining";
                break;
                
                case("323 días restantes"):
                    english = "323 days remaining";
                break;
                
                case("324 días restantes"):
                    english = "324 days remaining";
                break;
                
                case("325 días restantes"):
                    english = "325 days remaining";
                break;
                
                case("326 días restantes"):
                    english = "326 days remaining";
                break;
                
                case("327 días restantes"):
                    english = "327 days remaining";
                break;
                
                case("328 días restantes"):
                    english = "328 days remaining";
                break;
                
                case("329 días restantes"):
                    english = "329 days remaining";
                break;
                
                case("330 días restantes"):
                    english = "330 days remaining";
                break;
                
                case("331 días restantes"):
                    english = "331 days remaining";
                break;
                
                case("332 días restantes"):
                    english = "332 days remaining";
                break;
                
                case("333 días restantes"):
                    english = "333 days remaining";
                break;
                
                case("334 días restantes"):
                    english = "334 days remaining";
                break;
                
                case("335 días restantes"):
                    english = "335 days remaining";
                break;
                
                case("336 días restantes"):
                    english = "336 days remaining";
                break;
                
                case("337 días restantes"):
                    english = "337 days remaining";
                break;
                
                case("338 días restantes"):
                    english = "338 days remaining";
                break;
                
                case("339 días restantes"):
                    english = "339 days remaining";
                break;
                
                case("340 días restantes"):
                    english = "340 days remaining";
                break;
                
                case("341 días restantes"):
                    english = "341 days remaining";
                break;
                
                case("342 días restantes"):
                    english = "342 days remaining";
                break;
                
                case("343 días restantes"):
                    english = "343 days remaining";
                break;
                
                case("344 días restantes"):
                    english = "344 days remaining";
                break;
                
                case("345 días restantes"):
                    english = "345 days remaining";
                break;
                
                case("346 días restantes"):
                    english = "346 days remaining";
                break;
                
                case("347 días restantes"):
                    english = "347 days remaining";
                break;
                
                case("348 días restantes"):
                    english = "348 days remaining";
                break;
                
                case("349 días restantes"):
                    english = "349 days remaining";
                break;
                
                case("350 días restantes"):
                    english = "350 days remaining";
                break;
                
                case("351 días restantes"):
                    english = "351 days remaining";
                break;
                
                case("352 días restantes"):
                    english = "352 days remaining";
                break;
                
                case("353 días restantes"):
                    english = "353 days remaining";
                break;
                
                case("354 días restantes"):
                    english = "354 days remaining";
                break;
                
                case("355 días restantes"):
                    english = "355 days remaining";
                break;
                
                case("356 días restantes"):
                    english = "356 days remaining";
                break;
                
                case("357 días restantes"):
                    english = "357 days remaining";
                break;
                
                case("358 días restantes"):
                    english = "358 days remaining";
                break;
                
                case("359 días restantes"):
                    english = "359 days remaining";
                break;
                
                case("360 días restantes"):
                    english = "360 days remaining";
                break;
                
                case("361 días restantes"):
                    english = "361 days remaining";
                break;
                
                case("362 días restantes"):
                    english = "362 days remaining";
                break;
                
                case("363 días restantes"):
                    english = "363 days remaining";
                break;
                
                case("364 días restantes"):
                    english = "364 days remaining";
                break;
                
                case("365 días restantes"):
                    english = "365 days remaining";
                break;
                
                case("Caducó hace 1 días"):
                    english = "Expired 1 days ago";
                break;
                
                case("Caducó hace 2 días"):
                    english = "Expired 2 days ago";
                break;
                
                case("Caducó hace 3 días"):
                    english = "Expired 3 days ago";
                break;
                
                case("Caducó hace 4 días"):
                    english = "Expired 4 days ago";
                break;
                
                case("Caducó hace 5 días"):
                    english = "Expired 5 days ago";
                break;
                
                case("Caducó hace 6 días"):
                    english = "Expired 6 days ago";
                break;
                
                case("Caducó hace 7 días"):
                    english = "Expired 7 days ago";
                break;
                
                case("Caducó hace 8 días"):
                    english = "Expired 8 days ago";
                break;
                
                case("Caducó hace 9 días"):
                    english = "Expired 9 days ago";
                break;
                
                case("Caducó hace 10 días"):
                    english = "Expired 10 days ago";
                break;
                
                case("Caducó hace 11 días"):
                    english = "Expired 11 days ago";
                break;
                
                case("Caducó hace 12 días"):
                    english = "Expired 12 days ago";
                break;
                
                case("Caducó hace 13 días"):
                    english = "Expired 13 days ago";
                break;
                
                case("Caducó hace 14 días"):
                    english = "Expired 14 days ago";
                break;
                
                case("Caducó hace 15 días"):
                    english = "Expired 15 days ago";
                break;
                
                case("Caducó hace 16 días"):
                    english = "Expired 16 days ago";
                break;
                
                case("Caducó hace 17 días"):
                    english = "Expired 17 days ago";
                break;
                
                case("Caducó hace 18 días"):
                    english = "Expired 18 days ago";
                break;
                
                case("Caducó hace 19 días"):
                    english = "Expired 19 days ago";
                break;
                
                case("Caducó hace 20 días"):
                    english = "Expired 20 days ago";
                break;
                
                case("Caducó hace 21 días"):
                    english = "Expired 21 days ago";
                break;
                
                case("Caducó hace 22 días"):
                    english = "Expired 22 days ago";
                break;
                
                case("Caducó hace 23 días"):
                    english = "Expired 23 days ago";
                break;
                
                case("Caducó hace 24 días"):
                    english = "Expired 24 days ago";
                break;
                
                case("Caducó hace 25 días"):
                    english = "Expired 25 days ago";
                break;
                
                case("Caducó hace 26 días"):
                    english = "Expired 26 days ago";
                break;
                
                case("Caducó hace 27 días"):
                    english = "Expired 27 days ago";
                break;
                
                case("Caducó hace 28 días"):
                    english = "Expired 28 days ago";
                break;
                
                case("Caducó hace 29 días"):
                    english = "Expired 29 days ago";
                break;
                
                case("Caducó hace 30 días"):
                    english = "Expired 30 days ago";
                break;
                
                case("Caducó hace 31 días"):
                    english = "Expired 31 days ago";
                break;
                
                case("Caducó hace 32 días"):
                    english = "Expired 32 days ago";
                break;
                
                case("Caducó hace 33 días"):
                    english = "Expired 33 days ago";
                break;
                
                case("Caducó hace 34 días"):
                    english = "Expired 34 days ago";
                break;
                
                case("Caducó hace 35 días"):
                    english = "Expired 35 days ago";
                break;
                
                case("Caducó hace 36 días"):
                    english = "Expired 36 days ago";
                break;
                
                case("Caducó hace 37 días"):
                    english = "Expired 37 days ago";
                break;
                
                case("Caducó hace 38 días"):
                    english = "Expired 38 days ago";
                break;
                
                case("Caducó hace 39 días"):
                    english = "Expired 39 days ago";
                break;
                
                case("Caducó hace 40 días"):
                    english = "Expired 40 days ago";
                break;
                
                case("Caducó hace 41 días"):
                    english = "Expired 41 days ago";
                break;
                
                case("Caducó hace 42 días"):
                    english = "Expired 42 days ago";
                break;
                
                case("Caducó hace 43 días"):
                    english = "Expired 43 days ago";
                break;
                
                case("Caducó hace 44 días"):
                    english = "Expired 44 days ago";
                break;
                
                case("Caducó hace 45 días"):
                    english = "Expired 45 days ago";
                break;
                
                case("Caducó hace 46 días"):
                    english = "Expired 46 days ago";
                break;
                
                case("Caducó hace 47 días"):
                    english = "Expired 47 days ago";
                break;
                
                case("Caducó hace 48 días"):
                    english = "Expired 48 days ago";
                break;
                
                case("Caducó hace 49 días"):
                    english = "Expired 49 days ago";
                break;
                
                case("Caducó hace 50 días"):
                    english = "Expired 50 days ago";
                break;
                
                case("Caducó hace 51 días"):
                    english = "Expired 51 days ago";
                break;
                
                case("Caducó hace 52 días"):
                    english = "Expired 52 days ago";
                break;
                
                case("Caducó hace 53 días"):
                    english = "Expired 53 days ago";
                break;
                
                case("Caducó hace 54 días"):
                    english = "Expired 54 days ago";
                break;
                
                case("Caducó hace 55 días"):
                    english = "Expired 55 days ago";
                break;
                
                case("Caducó hace 56 días"):
                    english = "Expired 56 days ago";
                break;
                
                case("Caducó hace 57 días"):
                    english = "Expired 57 days ago";
                break;
                
                case("Caducó hace 58 días"):
                    english = "Expired 58 days ago";
                break;
                
                case("Caducó hace 59 días"):
                    english = "Expired 59 days ago";
                break;
                
                case("Caducó hace 60 días"):
                    english = "Expired 60 days ago";
                break;
                
                case("Caducó hace 61 días"):
                    english = "Expired 61 days ago";
                break;
                
                case("Caducó hace 62 días"):
                    english = "Expired 62 days ago";
                break;
                
                case("Caducó hace 63 días"):
                    english = "Expired 63 days ago";
                break;
                
                case("Caducó hace 64 días"):
                    english = "Expired 64 days ago";
                break;
                
                case("Caducó hace 65 días"):
                    english = "Expired 65 days ago";
                break;
                
                case("Caducó hace 66 días"):
                    english = "Expired 66 days ago";
                break;
                
                case("Caducó hace 67 días"):
                    english = "Expired 67 days ago";
                break;
                
                case("Caducó hace 68 días"):
                    english = "Expired 68 days ago";
                break;
                
                case("Caducó hace 69 días"):
                    english = "Expired 69 days ago";
                break;
                
                case("Caducó hace 70 días"):
                    english = "Expired 70 days ago";
                break;
                
                case("Caducó hace 71 días"):
                    english = "Expired 71 days ago";
                break;
                
                case("Caducó hace 72 días"):
                    english = "Expired 72 days ago";
                break;
                
                case("Caducó hace 73 días"):
                    english = "Expired 73 days ago";
                break;
                
                case("Caducó hace 74 días"):
                    english = "Expired 74 days ago";
                break;
                
                case("Caducó hace 75 días"):
                    english = "Expired 75 days ago";
                break;
                
                case("Caducó hace 76 días"):
                    english = "Expired 76 days ago";
                break;
                
                case("Caducó hace 77 días"):
                    english = "Expired 77 days ago";
                break;
                
                case("Caducó hace 78 días"):
                    english = "Expired 78 days ago";
                break;
                
                case("Caducó hace 79 días"):
                    english = "Expired 79 days ago";
                break;
                
                case("Caducó hace 80 días"):
                    english = "Expired 80 days ago";
                break;
                
                case("Caducó hace 81 días"):
                    english = "Expired 81 days ago";
                break;
                
                case("Caducó hace 82 días"):
                    english = "Expired 82 days ago";
                break;
                
                case("Caducó hace 83 días"):
                    english = "Expired 83 days ago";
                break;
                
                case("Caducó hace 84 días"):
                    english = "Expired 84 days ago";
                break;
                
                case("Caducó hace 85 días"):
                    english = "Expired 85 days ago";
                break;
                
                case("Caducó hace 86 días"):
                    english = "Expired 86 days ago";
                break;
                
                case("Caducó hace 87 días"):
                    english = "Expired 87 days ago";
                break;
                
                case("Caducó hace 88 días"):
                    english = "Expired 88 days ago";
                break;
                
                case("Caducó hace 89 días"):
                    english = "Expired 89 days ago";
                break;
                
                case("Caducó hace 90 días"):
                    english = "Expired 90 days ago";
                break;
                
                case("Caducó hace 91 días"):
                    english = "Expired 91 days ago";
                break;
                
                case("Caducó hace 92 días"):
                    english = "Expired 92 days ago";
                break;
                
                case("Caducó hace 93 días"):
                    english = "Expired 93 days ago";
                break;
                
                case("Caducó hace 94 días"):
                    english = "Expired 94 days ago";
                break;
                
                case("Caducó hace 95 días"):
                    english = "Expired 95 days ago";
                break;
                
                case("Caducó hace 96 días"):
                    english = "Expired 96 days ago";
                break;
                
                case("Caducó hace 97 días"):
                    english = "Expired 97 days ago";
                break;
                
                case("Caducó hace 98 días"):
                    english = "Expired 98 days ago";
                break;
                
                case("Caducó hace 99 días"):
                    english = "Expired 99 days ago";
                break;
                
                case("Caducó hace 100 días"):
                    english = "Expired 100 days ago";
                break;
                
                case("Caducó hace 101 días"):
                    english = "Expired 101 days ago";
                break;
                
                case("Caducó hace 102 días"):
                    english = "Expired 102 days ago";
                break;
                
                case("Caducó hace 103 días"):
                    english = "Expired 103 days ago";
                break;
                
                case("Caducó hace 104 días"):
                    english = "Expired 104 days ago";
                break;
                
                case("Caducó hace 105 días"):
                    english = "Expired 105 days ago";
                break;
                
                case("Caducó hace 106 días"):
                    english = "Expired 106 days ago";
                break;
                
                case("Caducó hace 107 días"):
                    english = "Expired 107 days ago";
                break;
                
                case("Caducó hace 108 días"):
                    english = "Expired 108 days ago";
                break;
                
                case("Caducó hace 109 días"):
                    english = "Expired 109 days ago";
                break;
                
                case("Caducó hace 110 días"):
                    english = "Expired 110 days ago";
                break;
                
                case("Caducó hace 111 días"):
                    english = "Expired 111 days ago";
                break;
                
                case("Caducó hace 112 días"):
                    english = "Expired 112 days ago";
                break;
                
                case("Caducó hace 113 días"):
                    english = "Expired 113 days ago";
                break;
                
                case("Caducó hace 114 días"):
                    english = "Expired 114 days ago";
                break;
                
                case("Caducó hace 115 días"):
                    english = "Expired 115 days ago";
                break;
                
                case("Caducó hace 116 días"):
                    english = "Expired 116 days ago";
                break;
                
                case("Caducó hace 117 días"):
                    english = "Expired 117 days ago";
                break;
                
                case("Caducó hace 118 días"):
                    english = "Expired 118 days ago";
                break;
                
                case("Caducó hace 119 días"):
                    english = "Expired 119 days ago";
                break;
                
                case("Caducó hace 120 días"):
                    english = "Expired 120 days ago";
                break;
                
                case("Caducó hace 121 días"):
                    english = "Expired 121 days ago";
                break;
                
                case("Caducó hace 122 días"):
                    english = "Expired 122 days ago";
                break;
                
                case("Caducó hace 123 días"):
                    english = "Expired 123 days ago";
                break;
                
                case("Caducó hace 124 días"):
                    english = "Expired 124 days ago";
                break;
                
                case("Caducó hace 125 días"):
                    english = "Expired 125 days ago";
                break;
                
                case("Caducó hace 126 días"):
                    english = "Expired 126 days ago";
                break;
                
                case("Caducó hace 127 días"):
                    english = "Expired 127 days ago";
                break;
                
                case("Caducó hace 128 días"):
                    english = "Expired 128 days ago";
                break;
                
                case("Caducó hace 129 días"):
                    english = "Expired 129 days ago";
                break;
                
                case("Caducó hace 130 días"):
                    english = "Expired 130 days ago";
                break;
                
                case("Caducó hace 131 días"):
                    english = "Expired 131 days ago";
                break;
                
                case("Caducó hace 132 días"):
                    english = "Expired 132 days ago";
                break;
                
                case("Caducó hace 133 días"):
                    english = "Expired 133 days ago";
                break;
                
                case("Caducó hace 134 días"):
                    english = "Expired 134 days ago";
                break;
                
                case("Caducó hace 135 días"):
                    english = "Expired 135 days ago";
                break;
                
                case("Caducó hace 136 días"):
                    english = "Expired 136 days ago";
                break;
                
                case("Caducó hace 137 días"):
                    english = "Expired 137 days ago";
                break;
                
                case("Caducó hace 138 días"):
                    english = "Expired 138 days ago";
                break;
                
                case("Caducó hace 139 días"):
                    english = "Expired 139 days ago";
                break;
                
                case("Caducó hace 140 días"):
                    english = "Expired 140 days ago";
                break;
                
                case("Caducó hace 141 días"):
                    english = "Expired 141 days ago";
                break;
                
                case("Caducó hace 142 días"):
                    english = "Expired 142 days ago";
                break;
                
                case("Caducó hace 143 días"):
                    english = "Expired 143 days ago";
                break;
                
                case("Caducó hace 144 días"):
                    english = "Expired 144 days ago";
                break;
                
                case("Caducó hace 145 días"):
                    english = "Expired 145 days ago";
                break;
                
                case("Caducó hace 146 días"):
                    english = "Expired 146 days ago";
                break;
                
                case("Caducó hace 147 días"):
                    english = "Expired 147 days ago";
                break;
                
                case("Caducó hace 148 días"):
                    english = "Expired 148 days ago";
                break;
                
                case("Caducó hace 149 días"):
                    english = "Expired 149 days ago";
                break;
                
                case("Caducó hace 150 días"):
                    english = "Expired 150 days ago";
                break;
                
                case("Caducó hace 151 días"):
                    english = "Expired 151 days ago";
                break;
                
                case("Caducó hace 152 días"):
                    english = "Expired 152 days ago";
                break;
                
                case("Caducó hace 153 días"):
                    english = "Expired 153 days ago";
                break;
                
                case("Caducó hace 154 días"):
                    english = "Expired 154 days ago";
                break;
                
                case("Caducó hace 155 días"):
                    english = "Expired 155 days ago";
                break;
                
                case("Caducó hace 156 días"):
                    english = "Expired 156 days ago";
                break;
                
                case("Caducó hace 157 días"):
                    english = "Expired 157 days ago";
                break;
                
                case("Caducó hace 158 días"):
                    english = "Expired 158 days ago";
                break;
                
                case("Caducó hace 159 días"):
                    english = "Expired 159 days ago";
                break;
                
                case("Caducó hace 160 días"):
                    english = "Expired 160 days ago";
                break;
                
                case("Caducó hace 161 días"):
                    english = "Expired 161 days ago";
                break;
                
                case("Caducó hace 162 días"):
                    english = "Expired 162 days ago";
                break;
                
                case("Caducó hace 163 días"):
                    english = "Expired 163 days ago";
                break;
                
                case("Caducó hace 164 días"):
                    english = "Expired 164 days ago";
                break;
                
                case("Caducó hace 165 días"):
                    english = "Expired 165 days ago";
                break;
                
                case("Caducó hace 166 días"):
                    english = "Expired 166 days ago";
                break;
                
                case("Caducó hace 167 días"):
                    english = "Expired 167 days ago";
                break;
                
                case("Caducó hace 168 días"):
                    english = "Expired 168 days ago";
                break;
                
                case("Caducó hace 169 días"):
                    english = "Expired 169 days ago";
                break;
                
                case("Caducó hace 170 días"):
                    english = "Expired 170 days ago";
                break;
                
                case("Caducó hace 171 días"):
                    english = "Expired 171 days ago";
                break;
                
                case("Caducó hace 172 días"):
                    english = "Expired 172 days ago";
                break;
                
                case("Caducó hace 173 días"):
                    english = "Expired 173 days ago";
                break;
                
                case("Caducó hace 174 días"):
                    english = "Expired 174 days ago";
                break;
                
                case("Caducó hace 175 días"):
                    english = "Expired 175 days ago";
                break;
                
                case("Caducó hace 176 días"):
                    english = "Expired 176 days ago";
                break;
                
                case("Caducó hace 177 días"):
                    english = "Expired 177 days ago";
                break;
                
                case("Caducó hace 178 días"):
                    english = "Expired 178 days ago";
                break;
                
                case("Caducó hace 179 días"):
                    english = "Expired 179 days ago";
                break;
                
                case("Caducó hace 180 días"):
                    english = "Expired 180 days ago";
                break;
                
                case("Caducó hace 181 días"):
                    english = "Expired 181 days ago";
                break;
                
                case("Caducó hace 182 días"):
                    english = "Expired 182 days ago";
                break;
                
                case("Caducó hace 183 días"):
                    english = "Expired 183 days ago";
                break;
                
                case("Caducó hace 184 días"):
                    english = "Expired 184 days ago";
                break;
                
                case("Caducó hace 185 días"):
                    english = "Expired 185 days ago";
                break;
                
                case("Caducó hace 186 días"):
                    english = "Expired 186 days ago";
                break;
                
                case("Caducó hace 187 días"):
                    english = "Expired 187 days ago";
                break;
                
                case("Caducó hace 188 días"):
                    english = "Expired 188 days ago";
                break;
                
                case("Caducó hace 189 días"):
                    english = "Expired 189 days ago";
                break;
                
                case("Caducó hace 190 días"):
                    english = "Expired 190 days ago";
                break;
                
                case("Caducó hace 191 días"):
                    english = "Expired 191 days ago";
                break;
                
                case("Caducó hace 192 días"):
                    english = "Expired 192 days ago";
                break;
                
                case("Caducó hace 193 días"):
                    english = "Expired 193 days ago";
                break;
                
                case("Caducó hace 194 días"):
                    english = "Expired 194 days ago";
                break;
                
                case("Caducó hace 195 días"):
                    english = "Expired 195 days ago";
                break;
                
                case("Caducó hace 196 días"):
                    english = "Expired 196 days ago";
                break;
                
                case("Caducó hace 197 días"):
                    english = "Expired 197 days ago";
                break;
                
                case("Caducó hace 198 días"):
                    english = "Expired 198 days ago";
                break;
                
                case("Caducó hace 199 días"):
                    english = "Expired 199 days ago";
                break;
                
                case("Caducó hace 200 días"):
                    english = "Expired 200 days ago";
                break;
                
                case("Caducó hace 201 días"):
                    english = "Expired 201 days ago";
                break;
                
                case("Caducó hace 202 días"):
                    english = "Expired 202 days ago";
                break;
                
                case("Caducó hace 203 días"):
                    english = "Expired 203 days ago";
                break;
                
                case("Caducó hace 204 días"):
                    english = "Expired 204 days ago";
                break;
                
                case("Caducó hace 205 días"):
                    english = "Expired 205 days ago";
                break;
                
                case("Caducó hace 206 días"):
                    english = "Expired 206 days ago";
                break;
                
                case("Caducó hace 207 días"):
                    english = "Expired 207 days ago";
                break;
                
                case("Caducó hace 208 días"):
                    english = "Expired 208 days ago";
                break;
                
                case("Caducó hace 209 días"):
                    english = "Expired 209 days ago";
                break;
                
                case("Caducó hace 210 días"):
                    english = "Expired 210 days ago";
                break;
                
                case("Caducó hace 211 días"):
                    english = "Expired 211 days ago";
                break;
                
                case("Caducó hace 212 días"):
                    english = "Expired 212 days ago";
                break;
                
                case("Caducó hace 213 días"):
                    english = "Expired 213 days ago";
                break;
                
                case("Caducó hace 214 días"):
                    english = "Expired 214 days ago";
                break;
                
                case("Caducó hace 215 días"):
                    english = "Expired 215 days ago";
                break;
                
                case("Caducó hace 216 días"):
                    english = "Expired 216 days ago";
                break;
                
                case("Caducó hace 217 días"):
                    english = "Expired 217 days ago";
                break;
                
                case("Caducó hace 218 días"):
                    english = "Expired 218 days ago";
                break;
                
                case("Caducó hace 219 días"):
                    english = "Expired 219 days ago";
                break;
                
                case("Caducó hace 220 días"):
                    english = "Expired 220 days ago";
                break;
                
                case("Caducó hace 221 días"):
                    english = "Expired 221 days ago";
                break;
                
                case("Caducó hace 222 días"):
                    english = "Expired 222 days ago";
                break;
                
                case("Caducó hace 223 días"):
                    english = "Expired 223 days ago";
                break;
                
                case("Caducó hace 224 días"):
                    english = "Expired 224 days ago";
                break;
                
                case("Caducó hace 225 días"):
                    english = "Expired 225 days ago";
                break;
                
                case("Caducó hace 226 días"):
                    english = "Expired 226 days ago";
                break;
                
                case("Caducó hace 227 días"):
                    english = "Expired 227 days ago";
                break;
                
                case("Caducó hace 228 días"):
                    english = "Expired 228 days ago";
                break;
                
                case("Caducó hace 229 días"):
                    english = "Expired 229 days ago";
                break;
                
                case("Caducó hace 230 días"):
                    english = "Expired 230 days ago";
                break;
                
                case("Caducó hace 231 días"):
                    english = "Expired 231 days ago";
                break;
                
                case("Caducó hace 232 días"):
                    english = "Expired 232 days ago";
                break;
                
                case("Caducó hace 233 días"):
                    english = "Expired 233 days ago";
                break;
                
                case("Caducó hace 234 días"):
                    english = "Expired 234 days ago";
                break;
                
                case("Caducó hace 235 días"):
                    english = "Expired 235 days ago";
                break;
                
                case("Caducó hace 236 días"):
                    english = "Expired 236 days ago";
                break;
                
                case("Caducó hace 237 días"):
                    english = "Expired 237 days ago";
                break;
                
                case("Caducó hace 238 días"):
                    english = "Expired 238 days ago";
                break;
                
                case("Caducó hace 239 días"):
                    english = "Expired 239 days ago";
                break;
                
                case("Caducó hace 240 días"):
                    english = "Expired 240 days ago";
                break;
                
                case("Caducó hace 241 días"):
                    english = "Expired 241 days ago";
                break;
                
                case("Caducó hace 242 días"):
                    english = "Expired 242 days ago";
                break;
                
                case("Caducó hace 243 días"):
                    english = "Expired 243 days ago";
                break;
                
                case("Caducó hace 244 días"):
                    english = "Expired 244 days ago";
                break;
                
                case("Caducó hace 245 días"):
                    english = "Expired 245 days ago";
                break;
                
                case("Caducó hace 246 días"):
                    english = "Expired 246 days ago";
                break;
                
                case("Caducó hace 247 días"):
                    english = "Expired 247 days ago";
                break;
                
                case("Caducó hace 248 días"):
                    english = "Expired 248 days ago";
                break;
                
                case("Caducó hace 249 días"):
                    english = "Expired 249 days ago";
                break;
                
                case("Caducó hace 250 días"):
                    english = "Expired 250 days ago";
                break;
                
                case("Caducó hace 251 días"):
                    english = "Expired 251 days ago";
                break;
                
                case("Caducó hace 252 días"):
                    english = "Expired 252 days ago";
                break;
                
                case("Caducó hace 253 días"):
                    english = "Expired 253 days ago";
                break;
                
                case("Caducó hace 254 días"):
                    english = "Expired 254 days ago";
                break;
                
                case("Caducó hace 255 días"):
                    english = "Expired 255 days ago";
                break;
                
                case("Caducó hace 256 días"):
                    english = "Expired 256 days ago";
                break;
                
                case("Caducó hace 257 días"):
                    english = "Expired 257 days ago";
                break;
                
                case("Caducó hace 258 días"):
                    english = "Expired 258 days ago";
                break;
                
                case("Caducó hace 259 días"):
                    english = "Expired 259 days ago";
                break;
                
                case("Caducó hace 260 días"):
                    english = "Expired 260 days ago";
                break;
                
                case("Caducó hace 261 días"):
                    english = "Expired 261 days ago";
                break;
                
                case("Caducó hace 262 días"):
                    english = "Expired 262 days ago";
                break;
                
                case("Caducó hace 263 días"):
                    english = "Expired 263 days ago";
                break;
                
                case("Caducó hace 264 días"):
                    english = "Expired 264 days ago";
                break;
                
                case("Caducó hace 265 días"):
                    english = "Expired 265 days ago";
                break;
                
                case("Caducó hace 266 días"):
                    english = "Expired 266 days ago";
                break;
                
                case("Caducó hace 267 días"):
                    english = "Expired 267 days ago";
                break;
                
                case("Caducó hace 268 días"):
                    english = "Expired 268 days ago";
                break;
                
                case("Caducó hace 269 días"):
                    english = "Expired 269 days ago";
                break;
                
                case("Caducó hace 270 días"):
                    english = "Expired 270 days ago";
                break;
                
                case("Caducó hace 271 días"):
                    english = "Expired 271 days ago";
                break;
                
                case("Caducó hace 272 días"):
                    english = "Expired 272 days ago";
                break;
                
                case("Caducó hace 273 días"):
                    english = "Expired 273 days ago";
                break;
                
                case("Caducó hace 274 días"):
                    english = "Expired 274 days ago";
                break;
                
                case("Caducó hace 275 días"):
                    english = "Expired 275 days ago";
                break;
                
                case("Caducó hace 276 días"):
                    english = "Expired 276 days ago";
                break;
                
                case("Caducó hace 277 días"):
                    english = "Expired 277 days ago";
                break;
                
                case("Caducó hace 278 días"):
                    english = "Expired 278 days ago";
                break;
                
                case("Caducó hace 279 días"):
                    english = "Expired 279 days ago";
                break;
                
                case("Caducó hace 280 días"):
                    english = "Expired 280 days ago";
                break;
                
                case("Caducó hace 281 días"):
                    english = "Expired 281 days ago";
                break;
                
                case("Caducó hace 282 días"):
                    english = "Expired 282 days ago";
                break;
                
                case("Caducó hace 283 días"):
                    english = "Expired 283 days ago";
                break;
                
                case("Caducó hace 284 días"):
                    english = "Expired 284 days ago";
                break;
                
                case("Caducó hace 285 días"):
                    english = "Expired 285 days ago";
                break;
                
                case("Caducó hace 286 días"):
                    english = "Expired 286 days ago";
                break;
                
                case("Caducó hace 287 días"):
                    english = "Expired 287 days ago";
                break;
                
                case("Caducó hace 288 días"):
                    english = "Expired 288 days ago";
                break;
                
                case("Caducó hace 289 días"):
                    english = "Expired 289 days ago";
                break;
                
                case("Caducó hace 290 días"):
                    english = "Expired 290 days ago";
                break;
                
                case("Caducó hace 291 días"):
                    english = "Expired 291 days ago";
                break;
                
                case("Caducó hace 292 días"):
                    english = "Expired 292 days ago";
                break;
                
                case("Caducó hace 293 días"):
                    english = "Expired 293 days ago";
                break;
                
                case("Caducó hace 294 días"):
                    english = "Expired 294 days ago";
                break;
                
                case("Caducó hace 295 días"):
                    english = "Expired 295 days ago";
                break;
                
                case("Caducó hace 296 días"):
                    english = "Expired 296 days ago";
                break;
                
                case("Caducó hace 297 días"):
                    english = "Expired 297 days ago";
                break;
                
                case("Caducó hace 298 días"):
                    english = "Expired 298 days ago";
                break;
                
                case("Caducó hace 299 días"):
                    english = "Expired 299 days ago";
                break;
                
                case("Caducó hace 300 días"):
                    english = "Expired 300 days ago";
                break;
                
                case("Caducó hace 301 días"):
                    english = "Expired 301 days ago";
                break;
                
                case("Caducó hace 302 días"):
                    english = "Expired 302 days ago";
                break;
                
                case("Caducó hace 303 días"):
                    english = "Expired 303 days ago";
                break;
                
                case("Caducó hace 304 días"):
                    english = "Expired 304 days ago";
                break;
                
                case("Caducó hace 305 días"):
                    english = "Expired 305 days ago";
                break;
                
                case("Caducó hace 306 días"):
                    english = "Expired 306 days ago";
                break;
                
                case("Caducó hace 307 días"):
                    english = "Expired 307 days ago";
                break;
                
                case("Caducó hace 308 días"):
                    english = "Expired 308 days ago";
                break;
                
                case("Caducó hace 309 días"):
                    english = "Expired 309 days ago";
                break;
                
                case("Caducó hace 310 días"):
                    english = "Expired 310 days ago";
                break;
                
                case("Caducó hace 311 días"):
                    english = "Expired 311 days ago";
                break;
                
                case("Caducó hace 312 días"):
                    english = "Expired 312 days ago";
                break;
                
                case("Caducó hace 313 días"):
                    english = "Expired 313 days ago";
                break;
                
                case("Caducó hace 314 días"):
                    english = "Expired 314 days ago";
                break;
                
                case("Caducó hace 315 días"):
                    english = "Expired 315 days ago";
                break;
                
                case("Caducó hace 316 días"):
                    english = "Expired 316 days ago";
                break;
                
                case("Caducó hace 317 días"):
                    english = "Expired 317 days ago";
                break;
                
                case("Caducó hace 318 días"):
                    english = "Expired 318 days ago";
                break;
                
                case("Caducó hace 319 días"):
                    english = "Expired 319 days ago";
                break;
                
                case("Caducó hace 320 días"):
                    english = "Expired 320 days ago";
                break;
                
                case("Caducó hace 321 días"):
                    english = "Expired 321 days ago";
                break;
                
                case("Caducó hace 322 días"):
                    english = "Expired 322 days ago";
                break;
                
                case("Caducó hace 323 días"):
                    english = "Expired 323 days ago";
                break;
                
                case("Caducó hace 324 días"):
                    english = "Expired 324 days ago";
                break;
                
                case("Caducó hace 325 días"):
                    english = "Expired 325 days ago";
                break;
                
                case("Caducó hace 326 días"):
                    english = "Expired 326 days ago";
                break;
                
                case("Caducó hace 327 días"):
                    english = "Expired 327 days ago";
                break;
                
                case("Caducó hace 328 días"):
                    english = "Expired 328 days ago";
                break;
                
                case("Caducó hace 329 días"):
                    english = "Expired 329 days ago";
                break;
                
                case("Caducó hace 330 días"):
                    english = "Expired 330 days ago";
                break;
                
                case("Caducó hace 331 días"):
                    english = "Expired 331 days ago";
                break;
                
                case("Caducó hace 332 días"):
                    english = "Expired 332 days ago";
                break;
                
                case("Caducó hace 333 días"):
                    english = "Expired 333 days ago";
                break;
                
                case("Caducó hace 334 días"):
                    english = "Expired 334 days ago";
                break;
                
                case("Caducó hace 335 días"):
                    english = "Expired 335 days ago";
                break;
                
                case("Caducó hace 336 días"):
                    english = "Expired 336 days ago";
                break;
                
                case("Caducó hace 337 días"):
                    english = "Expired 337 days ago";
                break;
                
                case("Caducó hace 338 días"):
                    english = "Expired 338 days ago";
                break;
                
                case("Caducó hace 339 días"):
                    english = "Expired 339 days ago";
                break;
                
                case("Caducó hace 340 días"):
                    english = "Expired 340 days ago";
                break;
                
                case("Caducó hace 341 días"):
                    english = "Expired 341 days ago";
                break;
                
                case("Caducó hace 342 días"):
                    english = "Expired 342 days ago";
                break;
                
                case("Caducó hace 343 días"):
                    english = "Expired 343 days ago";
                break;
                
                case("Caducó hace 344 días"):
                    english = "Expired 344 days ago";
                break;
                
                case("Caducó hace 345 días"):
                    english = "Expired 345 days ago";
                break;
                
                case("Caducó hace 346 días"):
                    english = "Expired 346 days ago";
                break;
                
                case("Caducó hace 347 días"):
                    english = "Expired 347 days ago";
                break;
                
                case("Caducó hace 348 días"):
                    english = "Expired 348 days ago";
                break;
                
                case("Caducó hace 349 días"):
                    english = "Expired 349 days ago";
                break;
                
                case("Caducó hace 350 días"):
                    english = "Expired 350 days ago";
                break;
                
                case("Caducó hace 351 días"):
                    english = "Expired 351 days ago";
                break;
                
                case("Caducó hace 352 días"):
                    english = "Expired 352 days ago";
                break;
                
                case("Caducó hace 353 días"):
                    english = "Expired 353 days ago";
                break;
                
                case("Caducó hace 354 días"):
                    english = "Expired 354 days ago";
                break;
                
                case("Caducó hace 355 días"):
                    english = "Expired 355 days ago";
                break;
                
                case("Caducó hace 356 días"):
                    english = "Expired 356 days ago";
                break;
                
                case("Caducó hace 357 días"):
                    english = "Expired 357 days ago";
                break;
                
                case("Caducó hace 358 días"):
                    english = "Expired 358 days ago";
                break;
                
                case("Caducó hace 359 días"):
                    english = "Expired 359 days ago";
                break;
                
                case("Caducó hace 360 días"):
                    english = "Expired 360 days ago";
                break;
                
                case("Caducó hace 361 días"):
                    english = "Expired 361 days ago";
                break;
                
                case("Caducó hace 362 días"):
                    english = "Expired 362 days ago";
                break;
                
                case("Caducó hace 363 días"):
                    english = "Expired 363 days ago";
                break;
                
                case("Caducó hace 364 días"):
                    english = "Expired 364 days ago";
                break;
                
                case("Caducó hace 365 días"):
                    english = "Expired 365 days ago";
                break;

            }
        }
                
        return english;
    }
    
}
