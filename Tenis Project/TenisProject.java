package com.mycompany.tenisproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TenisProject {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //Input datos
        System.out.println("Ingresar nombre del primer jugador:");
        String nJugador1 = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("Ingresar nombre del segundo jugador:");
        String nJugador2 = myScanner.nextLine();
        System.out.println("");

        System.out.println("Ingresar nombre del Torneo:");
        String nTorneo = myScanner.nextLine();
        System.out.println("");
        
        //Validacion Sets
        String sets = validacionS();
        
        //Validación probabilidades
        String prob1 = validacionProb(nJugador1);
        String prob2 = validacionProb(nJugador2);
        
        //Comentarios
        System.out.println("Los jugadores " + nJugador1 + " y " + nJugador2 + ",");
        System.out.println("participarán del torneo " + nTorneo + " al mejor de " + sets + " sets");
        System.out.println(nJugador1+" tiene un "+prob1+"% de probabilidades de ganar este partido, mientras que "+nJugador2+" tiene un "+prob2+"% de probabilidades.");


        //Revancha
        boolean revanchaBool;
        
        do{
            System.out.println("======================================================================================================================================");
            //Saque
            Random r = new Random();
            int randomSaque = r.nextInt(1-0);

            boolean saque1=false;
            boolean saque2=false;

            if(randomSaque == 1){
                System.out.println("~~~~~~"+nJugador1+" tiene el saque.~~~~~~");
                saque1=true;
            }
            else{
                System.out.println("~~~~~~"+nJugador2+" tiene el saque.~~~~~~");
                saque2=true;
            }
            System.out.println("======================================================================================================================================");

            System.out.println("Presione enter para comenzar!");
            myScanner.nextLine();

            //PARTIDO
            int setsI = Integer.parseInt(sets);
            int contadorSets = 0;
            int sets1=0;
            int sets2=0;
            ArrayList<String> historicoPartido1 = new ArrayList<>();
            ArrayList<String> historicoPartido2 = new ArrayList<>();

            boolean partidoBool=false;

            do{
                //SET
                //6 games = 1 set
                int contadorGames1=0;
                int contadorGames2=0;

                //Lista para Games
                ArrayList<String> historicoGames1 = new ArrayList<>();
                ArrayList<String> historicoGames2 = new ArrayList<>();

                boolean setBool = false;

                while(setBool == false){
                    //GAME
                    boolean gameBool=false;
                    //Tablero de puntaje:
                    int puntaje1=0;
                    int puntaje2=0;

                    //Traducción de puntaje:
                    int puntajeTenis1=0;
                    int puntajeTenis2=0;

                    //Lista para puntajes
                    ArrayList<String> historicoPuntos1 = new ArrayList<>();
                    ArrayList<String> historicoPuntos2 = new ArrayList<>();

                    do{
                        //RNG Punto
                        int punto = punto(prob1,nJugador1,prob2,nJugador2);

                        //Actualización de puntaje
                        switch(punto){
                            case 1:
                                puntaje1++;
                                break;
                            case 2:
                                puntaje2++;
                                break;
                        }
                        //Traduccion a puntaje de Tenis
                        puntajeTenis1 = puntajeTenis(puntaje1,puntajeTenis1);
                        String puntajeStr1 = String.valueOf(puntajeTenis1);
                        if(puntajeTenis1 == 50){
                            historicoPuntos1.add("GAME");
                            contadorGames1++;
                            gameBool=true;
                        }
                        else{
                            historicoPuntos1.add(puntajeStr1);
                        }

                        puntajeTenis2 = puntajeTenis(puntaje2,puntajeTenis2);
                        String puntajeStr2 = String.valueOf(puntajeTenis2);
                        if(puntajeTenis2 == 50){
                            historicoPuntos2.add("GAME");
                            contadorGames2++;
                            gameBool=true;
                        }
                        else{
                            historicoPuntos2.add(puntajeStr2);
                        }

                        //Mostrar x Tablero
                        System.out.println("Puntaje de "+nJugador1+": "+historicoPuntos1);
                        System.out.println("Puntaje de "+nJugador2+": "+historicoPuntos2);
                        System.out.println("======================================================================================================================================");
                    }
                    while(gameBool==false);

                    //Fin GAME
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("======================================================================================================================================");
                    System.out.println("GAME completado!");

                    saque1=!saque1;
                    saque2=!saque2;
                    if(saque1==true){
                        System.out.println("~~~~~~"+nJugador1+" tiene el saque.~~~~~~");
                    }
                    else{
                        System.out.println("~~~~~~"+nJugador2+" tiene el saque.~~~~~~");
                    }

                    System.out.println("El jugador "+nJugador1+" lleva "+contadorGames1+" GAMES ganados.");
                    System.out.println("El jugador "+nJugador2+" lleva "+contadorGames2+" GAMES ganados.");
                    System.out.println("======================================================================================================================================");
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("======================================================================================================================================");

                    //Paso valores de games al historico
                    String contadorGames1Str = String.valueOf(contadorGames1);
                    historicoGames1.add(contadorGames1Str);
                    String contadorGames2Str = String.valueOf(contadorGames2);
                    historicoGames2.add(contadorGames2Str);

                    //SET bool checker
                    if(contadorGames1==6){
                        setBool=true;
                        contadorSets++;
                        sets1++;
                        System.out.println("======================================================================================================================================");
                        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("======================================================================================================================================");
                        System.out.println("El ganador del SET número "+contadorSets+" es "+nJugador1+"!");
                        System.out.println("Games de "+nJugador1+" en el set N°"+contadorSets+": "+historicoGames1);
                        System.out.println("Games de "+nJugador2+" en el set N°"+contadorSets+": "+historicoGames2);
                        System.out.println("======================================================================================================================================");
                        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("======================================================================================================================================");
                    }
                    else if(contadorGames2==6){
                        setBool=true;
                        contadorSets++;
                        sets2++;
                        System.out.println("======================================================================================================================================");
                        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("======================================================================================================================================");
                        System.out.println("El ganador del SET número "+contadorSets+" es "+nJugador2+"!");
                        System.out.println("Games de "+nJugador1+" en el set N°"+contadorSets+": "+historicoGames1);
                        System.out.println("Games de "+nJugador2+" en el set N°"+contadorSets+": "+historicoGames2);
                        System.out.println("======================================================================================================================================");
                        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("======================================================================================================================================");
                    }
                    else{
                        setBool=false;
                    }

                    //GAME uno a uno
                    if(setsI != contadorSets){
                        System.out.println("Presione enter para continuar!");
                        myScanner.nextLine();
                    }

                }//Fin SET
                if(contadorSets == setsI){
                    partidoBool=true;
                    System.out.println("FIN DEL PARTIDO!");
                }
                else{
                    partidoBool=false;
                }

                String contadorGames1Str = String.valueOf(contadorGames1);
                historicoPartido1.add(contadorGames1Str);
                String contadorGames2Str = String.valueOf(contadorGames2);
                historicoPartido2.add(contadorGames2Str);
            }
            while(partidoBool==false);

            System.out.println(nJugador1+": "+historicoPartido1);
            System.out.println(nJugador2+": "+historicoPartido2);

            System.out.println(resultadoFinal(nJugador1,sets1,nJugador2,sets2,nTorneo));
            System.out.println("~~FIN~~");
            
            revanchaBool = validacionRevancha();
        }
        while(revanchaBool==true);
        
        
    }
    static String validacionProb(String nJugador){
        //Validacion probabilidades
        Scanner myScanner = new Scanner(System.in);

        boolean validacionP = false;
        String prob="";
        do{
            System.out.println("Seleccione la probabilidad de ganar de "+nJugador+":");
            System.out.println("(de 1% a 100%)");
            prob = myScanner.nextLine();
            System.out.println("");

            try{
                int intProb = Integer.parseInt(prob);
                //System.out.println(intSets);
                if(intProb > 100){
                    System.out.println("Demasiado alto!");
                    validacionP = false;
                }
                else if(intProb < 1){
                    System.out.println("Demasiado bajo!");
                    validacionP = false;
                }
                else{
                    System.out.println("Seleccionado el "+intProb+"% de probabilidades para "+nJugador+"!");
                    System.out.println("");

                    validacionP = true;
                }
            }
            catch(Exception e){
                System.out.println("Ingrese un número entero!");
                validacionP = false;
            }
        }
        while(validacionP == false);
        //Fin validacion probabilidades
        return prob;
    }
    static String validacionS(){
        Scanner myScanner = new Scanner(System.in);
        //Validación sets
        boolean validacionS = false;
        String sets="";
        do{
            System.out.println("Seleccione la cantidad de sets:");
            System.out.println("(3 o 5)");
            sets = myScanner.nextLine();
            System.out.println("");

            try{
                int intSets = Integer.parseInt(sets);
                //System.out.println(intSets);
                if(intSets == 3){
                    System.out.println("3 seleccionado!");
                    System.out.println("");
                    validacionS = true;
                }
                else if(intSets == 5){
                    System.out.println("5 seleccionado!");
                    System.out.println("");
                    validacionS = true;
                }
                else{
                    System.out.println("Seleccione entre 3 y 5!");
                    System.out.println("");

                    validacionS = false;
                }
            }
            catch(Exception e){
                System.out.println("Ingrese un número!");
                System.out.println("");
                validacionS = false;
            }
        }
        while(validacionS == false);
        //Fin validación sets
        return sets;
    }
    static int punto(String prob1,String nJugador1,String prob2,String nJugador2){
        //RNG
        Random r = new Random();
        boolean rngEmpatado=false;
        int punto=0;
        
        do{
            //Jugador 1
            int max1 = Integer.parseInt(prob1);
            int resultado1 = r.nextInt(max1-0);

            //Jugador 2
            int max2 = Integer.parseInt(prob2);
            int resultado2 = r.nextInt(max2-0);
        
            if(resultado1 > resultado2){
                System.out.println(nJugador1+" es el ganador de este punto!");
                punto=1;
                rngEmpatado=false;
            }
            else if(resultado1 < resultado2){
                System.out.println(nJugador2+" es el ganador de este punto!");
                punto=2;
                rngEmpatado=false;
            }
            else{
                rngEmpatado=true;
                System.out.println("Empate en el RNG //BORRAR//");
            }
        }
        while(rngEmpatado==true);
        
        
        //Fin RNG 
        return punto;
    }
    static int puntajeTenis(int puntaje, int puntajeTenis){
        //Sistema puntaje tenis
        switch(puntaje){
            case 1:
                puntajeTenis = 15;
                break;
            case 2:
                puntajeTenis = 30;
                break;
            case 3:
                puntajeTenis = 40;
                break;
            case 4:
                //Game
                puntajeTenis = 50;
                break;
        }
        return puntajeTenis;
    }
    static String resultadoFinal(String nJugador1,int sets1,String nJugador2,int sets2,String nTorneo){
        String resultado;
        if(sets1>sets2){
            resultado="El ganador del torneo "+nTorneo+" es "+nJugador1+"!";
        }
        else{
            resultado="El ganador del torneo "+nTorneo+" es "+nJugador2+"!";
        }
        
        return resultado;
    }
    static boolean validacionRevancha(){
        Scanner myScanner = new Scanner(System.in);
        boolean revanchaBool=false;
        boolean loopValidacion=true;
        

        while(loopValidacion==true){
            System.out.println("¿Quiere jugar la revancha?");
            System.out.println("(1 => si)");
            System.out.println("(2 => no)");
            String revanchaStr = myScanner.nextLine();
            
            try{
                int revanchaInt = Integer.parseInt(revanchaStr);
                
                if(revanchaInt == 1){
                    //Si
                    revanchaBool=true;
                    loopValidacion=false;               
                }
                else if(revanchaInt == 2){
                    //No
                    revanchaBool=false;
                    loopValidacion=false;
                }
                else{
                    //Numero equivocado
                    System.out.println("Esa no es una de las opciones");
                    
                    loopValidacion=true;
                }
            }
            catch(Exception e){
                System.out.println("Ese no es un número.");
                
                loopValidacion=true;
            }
        }
        return revanchaBool;
    }
}