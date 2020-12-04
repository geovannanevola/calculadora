/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.*;

/**
 *
 * @author Felipe
 *         Geovanna
 *         Mateus
 * 
 */

public class Calculadora {
    
    private List<Double> listOperandos = new ArrayList<>();
    private List<Character> listOperadores = new ArrayList<>();
    private ArrayList<Double> listResultados = new ArrayList();

    public void setarDados(String dado){
    
        int i = listOperandos.size();
        
        if (isOperadores(dado.charAt(i)) == false){
            Double num = Double.parseDouble(dado);
            //System.out.println(listOperandos.get(i));
            listOperandos.add(num);
       } else if (isOperadores(dado.charAt(i)) == true){
            listOperadores.add(dado.charAt(i));
        }
        
    }
    
    private boolean isOperadores(char operador){
        boolean isOperador = false;
        if (operador == '+' || operador == '-' || operador == '/' || operador == '*'){
            isOperador = true;
        }

        return isOperador;
    }
    
    public String verificarConta(){
        String resultadoEmString;
        int j = 0;
        int tam = listOperandos.size();
        System.out.println(tam);
        for (int i = 0; i < listOperandos.size(); i++){
            if (listResultados.isEmpty()){
                double num = listOperandos.get(i);
                char simb = this.listOperadores.get(i);
                double num_prox = listOperandos.get(i+1);
                listResultados.add(realizarConta(num,simb,num_prox));
            } else if (!listResultados.isEmpty()) {
                double num_prox = listOperandos.get(i);
                char simb = this.listOperadores.get(j);
                listResultados.add(realizarConta(listResultados.size(),simb,num_prox));
                j++;
            }
        }
        
        resultadoEmString = String.valueOf(listResultados.size());
        return resultadoEmString;
    }
    
    private double realizarConta(double num, char simb, double num_prox){
        double resultado = listResultados.size()-1;
        try {
            switch (simb){
                case '+':
                    resultado = (num + num_prox);
                    break;
                case '-':
                    resultado = (num - num_prox);
                    break;
                case '*':
                    resultado = (num * num_prox);
                    break;
                case '/':
                    resultado = (num / num_prox);
                    break;
            }
        }catch(ArithmeticException ae) {
                System.out.println("Divisão por 0");
        }
        System.out.println(resultado);
        return resultado;
    }
    
        public List<Double> getListOperandos() {
        return listOperandos;
    }

    public void setListOperandos(List<Double> listOperandos) {
        this.listOperandos = listOperandos;
    }

    public List<Character> getListOperadores() {
        return listOperadores;
    }

    public void setListOperadores(List<Character> listOperadores) {
        this.listOperadores = listOperadores;
    }

    public ArrayList<Double> getListResultados() {
        return listResultados;
    }

    public void setListResultados(ArrayList<Double> listResultados) {
        this.listResultados = listResultados;
    }
    
}