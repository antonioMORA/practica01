/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaia_01;

import java.util.ArrayList;
import practicaia_01.Transition.Action;

/**
 *
 * @author cristel
 */
public class State {

    public enum Position {

        DERECHA, IZQUIERDA
    }
    public Position oveja;
    public Position repollos;
    public Position lobo;
    public Position granjero;

    public boolean isValid() {
        if ((oveja == Position.DERECHA)
                && (repollos == Position.IZQUIERDA)
                && (granjero == Position.IZQUIERDA)) {
            return false;
        }
        if ((oveja == Position.DERECHA)
                && (lobo == Position.DERECHA)
                && (granjero == Position.IZQUIERDA)) {
            return false;
        }
        //Terminar toda la lista de estados invalidos
        return true;

    }

    public boolean isFinal() {
        if ((oveja == Position.IZQUIERDA)
                && (repollos == Position.IZQUIERDA)
                && (lobo == Position.IZQUIERDA)
                && (granjero == Position.IZQUIERDA)) {
            return false;
        }
        return true;
    }
    public ArrayList<Transition> validTransitions() {
        ArrayList<Transition> result = new
            ArrayList<Transition>();
        //Mover al granjero siempre es posible
        result.add(new Transition(this,Action.Mover_Granjero));
        //Mover a la oveja solo es posible con el granjero
        if (oveja == granjero) {
            result.add(new Transition(this,Action.Mover_Oveja));
        }
        //Mover a los demas objetos queda en la comodidad
        //de su hogar
        return result;
    }
    public static void main(String[] args) {
        State test = new State();
        test.granjero = Position.DERECHA;
        System.out.println(test);
    }
    @Override
    public String toString() {
        return "Posicion Oveja: " + oveja + " , " +
                "Posicion Repollos: " + repollos + " , " +
                "Posicion Lobo: " + lobo + " , " +
                "Posicion Granjero: " + granjero ;

    }
}
